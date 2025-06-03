package springboot.desafio.picpay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.desafio.picpay.entity.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, Long> {
}
