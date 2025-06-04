package springboot.desafio.picpay.exception;

public class PicpayException extends RuntimeException{
    public PicpayException(String message) {
        super(message);
    }
}
