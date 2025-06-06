package springboot.desafio.picpay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import springboot.desafio.picpay.client.NotificationClient;
import springboot.desafio.picpay.dto.NotifyResponse;
import springboot.desafio.picpay.entity.Transfer;
import springboot.desafio.picpay.exception.InternalServeErrorException;

@Service
public class NotificationService {
    @Autowired
    private KafkaProducer kafka;


    public void sendNotification(Transfer transfer){
       this.kafka.sendNotification(transfer);
    }
}
