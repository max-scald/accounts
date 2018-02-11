
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        boolean work = true;

        List<Account> accountsList = new ArrayList<>();

        while (work) {
            input = reader.readLine();

            String[] param = input.split(" ");
            if (param.length <= 3) {
                String command = param[0].toUpperCase();
                switch (command) {
                    case "NEWACCOUNT":
                        // Создаём новый счёт
                        if(param.length == 2) {
                            Account.createNewAccount(param[1]);
                        }else {
                            System.out.println("ERROR");
                        }
                        break;
                    case "DEPOSIT":
                        // Внести сумму на счёт
                        if(param.length == 3) {
                            String number = param[1];
                            String sum = param[2];
                            Account.deposit(number,sum);
                        }else {
                            System.out.println("ERROR");
                        }
                        break;
                    case "WITHDRAW":
                        // Снять сумму со счёта
                        if(param.length == 3) {
                            String number = param[1];
                            String sum = param[2];
                            Account.withdraw(number,sum);
                        }else {
                            System.out.println("ERROR");
                        }
                        break;
                    case "BALANCE":
                        // Узнать баланс счёта
                        if(param.length == 2) {
                            String number = param[1];
                            Account.balance(number);
                        }else {
                            System.out.println("ERROR");
                        }
                        break;
                    case "EXIT":
                        // Закрыть программу
                        System.out.println("Close");
                        work = false;
                        break;
                    default:
                        System.out.println("ERROR");
                }

            }
        }
    }
}
