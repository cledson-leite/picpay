package springboot.desafio.picpay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.desafio.picpay.client.NotificationClient;
import springboot.desafio.picpay.entity.Transfer;

@Service
public class NotificationService {
    @Autowired
    private NotificationClient notification;
    public void sendNotification(Transfer transfer){
        this.notification.sendNotification(transfer);
    }
}
