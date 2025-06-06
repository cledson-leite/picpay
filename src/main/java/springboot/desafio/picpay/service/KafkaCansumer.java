package springboot.desafio.picpay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import springboot.desafio.picpay.client.NotificationClient;
import springboot.desafio.picpay.dto.NotifyResponse;
import springboot.desafio.picpay.entity.Transfer;
import springboot.desafio.picpay.exception.InternalServeErrorException;
import springboot.desafio.picpay.exception.NotificationException;

@Service
public class KafkaCansumer {
    @Autowired
    private NotificationClient notification;

    @KafkaListener(topics = "transaction-notify", groupId = "picpay")
    public void receiveNotification(Transfer transfer){
        ResponseEntity<NotifyResponse> resp = this.notification.postNotification(transfer);
        if(resp.getStatusCode().isError()){
            throw new NotificationException();
        }
        if("fail".equals(resp.getBody().getStatus())){
            throw new NotificationException();
        }
    }
}
