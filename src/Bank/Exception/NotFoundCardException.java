package Bank.Exception;

public class NotFoundCardException extends BankOnlineException{
    public NotFoundCardException() {

    }

    public NotFoundCardException(String Message) {
        super(Message);
    }

}
