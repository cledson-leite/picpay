package springboot.desafio.picpay.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import springboot.desafio.picpay.dto.ClientResponse;

@FeignClient(url = "${client.authorization-service.url}")
public interface AuthorizationClient {
    @GetMapping
    ResponseEntity<ClientResponse> isAuthorized();
}
