package Bank.Exception;

public class BlockedCardException extends BankOnlineException{
    public BlockedCardException() {

    }

    public BlockedCardException(String Message) {
        super(Message);
    }

}
