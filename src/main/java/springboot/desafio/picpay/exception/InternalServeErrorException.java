package springboot.desafio.picpay.exception;

public class InternalServeErrorException extends PicpayException{
    public InternalServeErrorException() {
        super("Internal Server Error");
    }
}
