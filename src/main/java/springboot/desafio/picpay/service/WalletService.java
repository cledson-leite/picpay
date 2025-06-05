package springboot.desafio.picpay.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.desafio.picpay.dto.CreateWalletDto;
import springboot.desafio.picpay.entity.Wallet;
import springboot.desafio.picpay.entity.enums.WalletType;
import springboot.desafio.picpay.exception.DuplicateWalletException;
import springboot.desafio.picpay.repository.WalletRepository;

import java.util.Optional;

@Service
public class WalletService {
    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private ModelMapper mapper;

    public Wallet save(CreateWalletDto dto) {
        String typeRaw = dto.getWalletType().trim().toUpperCase();
        WalletType type = WalletType.valueOf(typeRaw);
        Wallet entity = this.mapper.map(dto, Wallet.class);
        entity.setWalletType(type);
        ensuredWalletNotExist(entity);
        return this.walletRepository.save(entity);
    }

    private void ensuredWalletNotExist(Wallet entity) {
        Optional<Wallet> existedEntity = this.walletRepository.findByCpfCnpjOrEmail(entity.getCpfCnpj(), entity.getEmail());
        existedEntity.ifPresent(wallet -> {
            throw new DuplicateWalletException();
        });
    }
}
