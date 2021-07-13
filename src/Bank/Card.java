package Bank;

public class Card implements CardData{
    public Card(String cardNum, double balance) {
        this.cardNum = cardNum;
        this.balance = balance;
    }

    private String cardNum;
    private double balance;
    private boolean isBlocked = false;
    private final int BalanceLimit = 50000;

    @Override
    public String getCardNum() {
        return cardNum;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean isBlocked() {
        return isBlocked;
    }

    @Override
    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    @Override
    public int getBalanceLimit() {
        return BalanceLimit;
    }
}
