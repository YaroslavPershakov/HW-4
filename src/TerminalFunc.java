import Bank.BankOnline;
import Bank.Exception.*;

import java.util.Scanner;

public class TerminalFunc {

    private Scanner read = new Scanner(System.in);

    public void transfer(BankOnline bank) {
        System.out.println("Введите свой номер карты, номер карты, на которую выполняется перевод, сумму перевода");
        System.out.print("Ваш номер карты - ");
        String myCardNum = read.nextLine();
        System.out.print("\nНомер карты на которую выполняется перевод - ");
        String cardNum = read.nextLine();
        System.out.print("\nСумма перевода - ");
        double transfer = read.nextDouble();
        System.out.println();
        try {
            bank.send(myCardNum, cardNum, transfer);
        }
        catch (BlockedCardException | InvalidCardNumberException | InvalidMoneyException
                | NotFoundCardException | OutOfBalanceLimit | OutOfTransferLimitException e) {
            System.out.println(e.getErrorMsg());
        } catch (NullPointerException e) {
            System.out.println("Найден указатель на null");
        }
        finally {
            System.out.println("Перевод не завершён");
        }

    }

    public void addMoney(BankOnline bank) {
        System.out.println("Введите номер карты, на которую выполняется пополнение и сумму пополнения");
        System.out.print("\nНомер карты на которую выполняется пополнение - ");
        String cardNum = read.nextLine();
        System.out.print("\nСумма пополнения - ");
        double transfer = read.nextDouble();
        System.out.println();
        try {
            bank.addMoney(cardNum, transfer);
        }
        catch (BlockedCardException | InvalidCardNumberException | InvalidMoneyException
                | NotFoundCardException | OutOfBalanceLimit | OutOfTransferLimitException e) {
            System.out.println(e.getErrorMsg());
        } catch (NullPointerException e) {
            System.out.println("Найден указатель на null");
        }
        finally {
            System.out.println("Пополнение не выполнено");
        }
    }

    public void balance(BankOnline bank) {
        System.out.print("Введите номер карты - ");
        String cardNum = read.nextLine();
        System.out.println();
        try {
            System.out.println("Баланс карты " + cardNum + " равен: " + bank.getBalance(cardNum));
        }
        catch (BlockedCardException | InvalidCardNumberException | NotFoundCardException e) {
            System.out.println(e.getErrorMsg());
        } catch (NullPointerException e) {
            System.out.println("Найден указатель на null");
        }
    }

    public void blockCard(BankOnline bank) {
        System.out.print("Введите номер карты, которую надо заблокировать - ");
        String cardNum = read.nextLine();
        System.out.println();
        try {
            bank.blockCard(cardNum);
        }
        catch (InvalidCardNumberException | NotFoundCardException | BlockedCardException e) {
            System.out.println(e.getErrorMsg());
        } catch (NullPointerException e) {
            System.out.println("Найден указатель на null");
        }
    }

}
