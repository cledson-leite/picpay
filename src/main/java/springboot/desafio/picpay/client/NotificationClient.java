package springboot.desafio.picpay.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import springboot.desafio.picpay.dto.NotifyResponse;
import springboot.desafio.picpay.entity.Transfer;

@FeignClient(url = "${client.notification-service.url}")
public interface NotificationClient {
    @PostMapping
    ResponseEntity<NotifyResponse> postNotification(@RequestBody Transfer transfer);
}
