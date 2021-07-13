package Bank.Exception;

public class OutOfTransferLimitException extends BankOnlineException{
    public OutOfTransferLimitException() {

    }

    public OutOfTransferLimitException(String Message) {
        super(Message);
    }

}
