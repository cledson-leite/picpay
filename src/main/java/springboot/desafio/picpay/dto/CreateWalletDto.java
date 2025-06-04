package springboot.desafio.picpay.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class CreateWalletDto {
    @NotBlank(message = "Campo Obrigatório")
    private String fullName;

    @NotBlank(message = "Campo Obrigatório")
    private String cpfCnpj;

    @NotBlank(message = "Campo Obrigatório")
    @Email(message = "Email inválido")
    private String email;

    @NotBlank(message = "Campo Obrigatório")
    private String password;

    @NotBlank(message = "Campo Obrigatório")
    private String walletType;
}
