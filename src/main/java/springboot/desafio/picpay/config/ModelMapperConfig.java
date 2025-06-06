package springboot.desafio.picpay.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springboot.desafio.picpay.dto.CreateWalletDto;
import springboot.desafio.picpay.dto.TransferDto;
import springboot.desafio.picpay.entity.Transfer;
import springboot.desafio.picpay.entity.Wallet;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);
        modelMapper.createTypeMap(CreateWalletDto.class, Wallet.class)
                .addMappings(mapper -> {
                    mapper.skip(Wallet::setId);
                    mapper.skip(Wallet::setWalletType);
                    mapper.skip(Wallet::setBalance);
                });
        modelMapper.createTypeMap(TransferDto.class, Transfer.class);
        return modelMapper;
    }
}
