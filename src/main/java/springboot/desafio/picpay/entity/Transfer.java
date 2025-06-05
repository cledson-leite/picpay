package springboot.desafio.picpay.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "TRANSACTIONS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "wallet-sender-id")
    private Wallet sender;

    @ManyToOne
    @JoinColumn(name = "wallet-receive-id")
    private Wallet receiver;

    private BigDecimal value;
}
