import Bank.BankData;
import Bank.BankOnline;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Terminal {

    public static void main(String[] args) {
        BankData bd = new BankData();
        bd.LoadData("Resources\\CardData.txt");
        BankOnline bank = new BankOnline(bd.getBankData());
        Scanner read = new Scanner(System.in);

        System.out.println("Банковский терминал №5");
        System.out.println("Желаете перевести или положить деньги?");

        int answer;
        boolean work = true;
        while (work) {
            try {
                System.out.println("1 - перевести \n2 - положить\n3 - баланс\n4 - заблокировать карту\n5 - закрыть терминал");
                answer = read.nextInt();
                TerminalFunc termFun = new TerminalFunc();
//                try {
                switch (answer) {
                    case 1:
                        termFun.transfer(bank);
                        break;
                    case 2:
                        termFun.addMoney(bank);
                        break;
                    case 3:
                        termFun.balance(bank);
                        break;
                    case 4:
                        termFun.blockCard(bank);
                        break;
                    case 5:
                        work = false;
                        break;
                    default:
                        throw new IllegalStateException("Неверное значение: " + answer);
                }
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
//            } catch (InputMismatchException e) {
//                System.out.println("Неверное значение");
//            }
        }

        System.out.println("(-, – )…zzzZZZ");
    }
}
