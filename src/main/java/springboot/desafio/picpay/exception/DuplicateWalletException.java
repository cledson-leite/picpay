package springboot.desafio.picpay.exception;

public  class DuplicateWalletException extends PicpayException {
    public DuplicateWalletException() {
        super("Duplicated Wallet");
    }
}
