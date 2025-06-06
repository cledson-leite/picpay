package springboot.desafio.picpay.exception;

public class InvalidTransfer extends PicpayException{
    public InvalidTransfer() {
        super("Invalid Transfer");
    }
}
