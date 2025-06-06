package springboot.desafio.picpay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import springboot.desafio.picpay.entity.Transfer;

@Service
public class KafkaProducer {
    @Autowired
    private KafkaTemplate<String, Transfer> kafka;

    public void sendNotification(Transfer transfer){
        kafka.send("transaction-notify", transfer);
    }
}
