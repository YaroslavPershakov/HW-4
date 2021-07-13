package Bank;

import MyUtil.Util.List.SingleList;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BankData {

    private SingleList<CardData> bd = new SingleList<>();

    public void LoadData(String textLocation) {
        try (FileReader file = new FileReader(textLocation)) {
            BufferedReader read = new BufferedReader(file);

            while(read.ready()) {
                CardData note = new Card(read.readLine().replaceAll(" ", ""), 0);
                bd.add(note);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла");
        } catch (Exception e) {
            System.out.println("Ошибка при закрытии файла");
        }
    }

    public SingleList<CardData> getBankData() {
        return bd;
    }

}
