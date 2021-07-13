package Bank.Exception;

public class OutOfBalanceLimit extends BankOnlineException{
    public OutOfBalanceLimit() {

    }

    public OutOfBalanceLimit(String Message) {
        super(Message);
    }

}
