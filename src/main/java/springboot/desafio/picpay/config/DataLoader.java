package springboot.desafio.picpay.config;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import springboot.desafio.picpay.entity.WalletType;
import springboot.desafio.picpay.repository.WalletTypeRepository;

import java.util.Arrays;

@Configuration
public class DataLoader implements CommandLineRunner {

    @Autowired
    private WalletTypeRepository typeRepository;

    @Transactional
    @Override
    public void run(String... args) {
        Arrays.stream(WalletType.Types.values())
                .forEach(type -> typeRepository.save(type.getValue()));
    }
}
