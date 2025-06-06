package springboot.desafio.picpay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.desafio.picpay.entity.Transfer;

import java.util.UUID;

public interface TransferRepository extends JpaRepository<Transfer, UUID> {
}
