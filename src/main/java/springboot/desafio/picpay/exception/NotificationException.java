package springboot.desafio.picpay.exception;

public class NotificationException extends PicpayException{
    public NotificationException() {
        super("Error connecting to notifier");
    }
}
