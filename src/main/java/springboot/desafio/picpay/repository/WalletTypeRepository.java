package springboot.desafio.picpay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.desafio.picpay.entity.WalletType;

public interface WalletTypeRepository extends JpaRepository<WalletType, Long> {
}
