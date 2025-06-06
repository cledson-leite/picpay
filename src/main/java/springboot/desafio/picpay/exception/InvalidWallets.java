package springboot.desafio.picpay.exception;

public class InvalidWallets extends PicpayException {
    public InvalidWallets() {
        super("Invalid Wallet Id");
    }
}
