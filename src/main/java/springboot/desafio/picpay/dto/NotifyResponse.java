package springboot.desafio.picpay.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotifyResponse {
    private String status;
    private Data data;

    @NoArgsConstructor
    @AllArgsConstructor
    public static class Data {
        private String message;
    }
}
