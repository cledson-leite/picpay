package springboot.desafio.picpay.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class CreateWalletDto {
    @NotNull(message = "Campo Obrigatório")
    private String fullName;

    @NotNull(message = "Campo Obrigatório")
    private String cpfCnpj;

    @NotNull(message = "Campo Obrigatório")
    @Email(message = "Email inválido")
    private String email;

    @NotNull(message = "Campo Obrigatório")
    private String password;

    @NotNull(message = "Campo Obrigatório")
    private String walletType;
}
