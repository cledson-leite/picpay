package springboot.desafio.picpay.service;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.desafio.picpay.dto.CreateWalletDto;
import springboot.desafio.picpay.entity.Wallet;
import springboot.desafio.picpay.entity.enums.WalletType;
import springboot.desafio.picpay.exception.DuplicateWalletException;
import springboot.desafio.picpay.repository.WalletRepository;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class WalletService {
    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private ModelMapper mapper;

    public Wallet save(CreateWalletDto dto) {
        WalletType type = formatType(dto);
        Wallet entity = this.mapper.map(dto, Wallet.class);
        entity.setWalletType(type);
        ensuredWalletNotExist(entity);
        return this.walletRepository.save(entity);
    }

    private static WalletType formatType(CreateWalletDto dto) {
        String typeRaw = dto.getWalletType().trim().toUpperCase();
        return WalletType.valueOf(typeRaw);
    }

    private void ensuredWalletNotExist(Wallet entity) {
        Optional<Wallet> existedEntity = this.walletRepository.findByCpfCnpjOrEmail(entity.getCpfCnpj(), entity.getEmail());
        existedEntity.ifPresent(wallet -> {
            throw new DuplicateWalletException();
        });
    }

    public Boolean isExist( Long id) {
        Optional<Wallet> isExist = this.walletRepository.findById(id);
        return isExist.isPresent();
    }

    public Boolean isUser(Long id) {
        return this.walletRepository.findById(id)
                .map(Wallet:: isUser)
                .orElse(false);
    }

    public Boolean isBalanceAllow(Long id, BigDecimal value) {
        return this.walletRepository.findById(id)
                .map(wallet -> wallet.isBalanceAllow(value))
                .orElse(false);
    }

    public void debit(Long id, BigDecimal value) {
        Optional<Wallet> debitedWallet = this.walletRepository.findById(id);
        debitedWallet.ifPresent(wallet -> {
            wallet.debit(value);
            this.walletRepository.save(wallet);
        } );
    }
    public void credit(Long id, BigDecimal value) {
        Optional<Wallet> debitedWallet = this.walletRepository.findById(id);
        debitedWallet.ifPresent(wallet -> {
            wallet.credit(value);
            this.walletRepository.save(wallet);
        } );
    }
}
