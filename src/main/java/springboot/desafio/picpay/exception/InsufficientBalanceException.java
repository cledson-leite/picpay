package springboot.desafio.picpay.exception;

public class InsufficientBalanceException extends PicpayException{
    public InsufficientBalanceException() {
        super("Insufficient balance");
    }
}
