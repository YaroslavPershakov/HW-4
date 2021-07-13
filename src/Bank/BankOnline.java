package Bank;

import Bank.Exception.*;
import MyUtil.Util.List.SingleList;

public class BankOnline {
    public BankOnline(SingleList<CardData> bd) {
        this.bd = bd;
    }

    private SingleList<CardData> bd;
    private final int TransferLimit = 50000;

    private CardData getCard(String cardNum) {
        String trCardNum = cardNum;
        cardNum = cardNum.replaceAll(" ", "");
        if (cardNum.length() == 16) {
            boolean foundCard = false;
            for (int i = 0; i < bd.size(); i++) {
                if (bd.get(i).getCardNum().equals(cardNum)) {
                    if (!bd.get(i).isBlocked()) {
                        foundCard = true;
                        return bd.get(i);
                    } else {
                        throw new BlockedCardException("Карта с номером " + trCardNum + " заблокирована");
                    }
                }
            }
            if (!foundCard) {
                throw new NotFoundCardException("Карта с номером " + trCardNum + " не найдена");
            }
        } else {
            throw new InvalidCardNumberException("Неверно указан номер карты " + trCardNum);
        }
        return null;
    }

    public void addMoney(String cardNum, double cash) {
        if (cash >= 0) {
            if (cash <= TransferLimit) {
                CardData card = getCard(cardNum);
                if (card.getBalanceLimit() >= card.getBalance() + cash) {
                    card.setBalance(card.getBalance() + cash);
                } else {
                    throw new OutOfBalanceLimit("Достигнут предел денежных средств на карте " + card.getCardNum());
                }
            } else {
                throw new OutOfTransferLimitException("Превышен предел перевода денежных средств");
            }
        } else {
            throw new InvalidMoneyException("Неверная сумма перевода");
        }

        System.out.println("Перевод выполнен успешно!");
    }

    public void send(String myCardNum, String cardNum, double transfer) {
        if (transfer >= 0) {
            if (transfer <= TransferLimit) {
                CardData card = getCard(myCardNum);
                CardData cardTr = getCard(cardNum);
                if (cardTr.getBalanceLimit() >= cardTr.getBalance() + transfer) {
                    if (card.getBalance() >= transfer) {
                        card.setBalance(card.getBalance() - transfer);
                    } else {
                        throw new InvalidMoneyException("Сумма перевода превышает баланс на карте " + card.getCardNum());
                    }
                    cardTr.setBalance(cardTr.getBalance() + transfer);
                } else {
                    throw new OutOfBalanceLimit("Достигнут предел денежных средств на карте " + cardTr.getCardNum());
                }
            } else {
                throw new OutOfTransferLimitException("Превышен предел перевода денежных средств");
            }
        } else {
            throw new InvalidMoneyException("Неверная сумма перевода");
        }
    }

    public double getBalance(String cardNum) {
        return getCard(cardNum).getBalance();
    }

    public void blockCard(String cardNum) {
        getCard(cardNum).setBlocked(true);
    }

}
