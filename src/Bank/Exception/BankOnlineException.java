package Bank.Exception;

public class BankOnlineException extends RuntimeException {
    public BankOnlineException() {

    }

    private String msg;

    public BankOnlineException(String Message) {
        super(Message);
        this.msg = Message;
    }

    public String getErrorMsg() {
        return msg;
    }

}
