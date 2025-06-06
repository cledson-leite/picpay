package springboot.desafio.picpay.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {
    private String status;
    private Data data;

    @NoArgsConstructor
    @AllArgsConstructor
    public static class Data {
        public Boolean authorization;
    }
}
