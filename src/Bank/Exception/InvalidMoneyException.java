package Bank.Exception;

public class InvalidMoneyException extends BankOnlineException {
    public InvalidMoneyException() {

    }

    public InvalidMoneyException(String Message) {
        super(Message);
    }

}
