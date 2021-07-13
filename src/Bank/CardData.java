package Bank;

public interface CardData {
    String getCardNum();

    double getBalance();
    void setBalance(double balance);

    boolean isBlocked();
    void setBlocked(boolean blocked);

    int getBalanceLimit();
}
