package springboot.desafio.picpay.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransferDto {
    @DecimalMin("0.01")
    @NotNull(message = "Campo Obrigatório")
    public BigDecimal value;

    @NotNull(message = "Campo Obrigatório")
    public Long payer;

    @NotNull(message = "Campo Obrigatório")
    public Long payee;
}
