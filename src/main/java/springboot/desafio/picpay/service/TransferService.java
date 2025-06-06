package springboot.desafio.picpay.service;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.desafio.picpay.dto.TransferDto;
import springboot.desafio.picpay.entity.Transfer;
import springboot.desafio.picpay.exception.InsufficientBalanceException;
import springboot.desafio.picpay.exception.InvalidTransfer;
import springboot.desafio.picpay.exception.InvalidWallets;
import springboot.desafio.picpay.repository.TransferRepository;

@Service
public class TransferService {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private WalletService wallet;

    @Autowired
    private AuthorizationService auth;

    @Autowired
    private NotificationService notification;

    @Autowired
    private TransferRepository repository;

    @Transactional
    public Transfer transfer(TransferDto dto) {
        Transfer transfer = mapper.map(dto, Transfer.class);
        validationTransfer(dto, transfer);
        operation(dto);
        this.repository.save(transfer);
        this.notification.sendNotification(transfer);
        return transfer;
    }

    private void operation(TransferDto dto) {
        this.wallet.debit(dto.payer, dto.value);
        this.wallet.credit(dto.payee, dto.value);
    }

    private void validationTransfer(TransferDto dto, Transfer transfer) {
        Boolean isExists = ensureWalletsExists(dto);
        if(!isExists) throw new InvalidWallets();
        Boolean isUser = this.wallet.isUser(dto.payer);
        if(!isUser) throw new InvalidTransfer();
        Boolean isBalanceAllow = this.wallet.isBalanceAllow(dto.payer, dto.value);
        if(!isBalanceAllow) throw new InsufficientBalanceException();
        if(!auth.isAuthorizated(transfer)) throw new InvalidTransfer();
    }

    private Boolean ensureWalletsExists(TransferDto dto) {
        return this.wallet.isExist(dto.payer) || this.wallet.isExist(dto.payee);
    }
}
