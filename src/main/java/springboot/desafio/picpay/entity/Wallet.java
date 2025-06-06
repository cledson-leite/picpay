package springboot.desafio.picpay.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import springboot.desafio.picpay.entity.enums.WalletType;

import java.math.BigDecimal;

@Entity
@Table(name = "WALLETS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;

    @Column(unique = true)
    private String cpfCnpj;

    @Column(unique = true)
    private String email;
    private String password;
    private BigDecimal balance = BigDecimal.ZERO;
    private WalletType walletType;

    public Boolean isUser() {
        return "user".equals(this.getWalletType());
    }

    public Boolean isBalanceAllow(BigDecimal value) {
        return this.balance.compareTo(BigDecimal.ZERO) > 0 && this.balance.compareTo(value) >= 0;
    }

    public void debit(BigDecimal value) {
        this.balance.subtract(value);
    }
    public void credit(BigDecimal value) {
        this.balance.add(value);
    }
}
