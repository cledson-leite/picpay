package springboot.desafio.picpay.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "WALLET_TYPES")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WalletType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    public WalletType(String description) {
        this.description = description;
    }

    public enum  Types {
        USER("user"),
        MERCHANT("merchant");

        private String description;

        Types(String description) {
            this.description = description;
        }

        public WalletType getValue(){
            return new WalletType(description);
        }
    }
}
