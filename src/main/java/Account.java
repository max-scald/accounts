import java.math.BigDecimal;
import java.util.List;
import java.util.regex.Pattern;

public class Account {
    private String accountNumber;
    private double ammount;

    private Account(String accountNumber){
            this.accountNumber = accountNumber;
            this.ammount = 0.0;
    }

    public static void createNewAccount(String number){
        AccountsList accountsList = AccountsList.getInstance();
        Account account = null;
        List<Account> list = null;
        if(checkLengthNumbetOfAccount(number)){
            account = new Account(number);
            list = accountsList.getAccountsList();

            if (!accountIsAlreadyThere(number)){
                list.add(account);
                System.out.println("OK");
            }else {
                System.out.println("ERROR");
            }
        }else {
            System.out.println("ERROR");
        }
    }



    public String getAccountNumber() {
        return accountNumber;
    }

    public double getAmmount() {
        return ammount;
    }

    public void setAmmount(Double ammount) {
        this.ammount = ammount;
    }

    private static boolean checkLengthNumbetOfAccount(String in) {
        return Pattern.matches("\\d{5}", in);
    }

    public static void deposit(String number, String ammount){
        AccountsList accountsList = AccountsList.getInstance();
        List<Account> list = accountsList.getAccountsList();
        int index;
            if(checkLengthNumbetOfAccount(number) && checkForPositiveNumber(ammount) && accountIsAlreadyThere(number)){
                  index = returnAccountIndex(number);
                  double sum = list.get(index).getAmmount() + Double.parseDouble(ammount);
                  list.get(index).setAmmount(sum);
                  System.out.println("OK");
            }else {
                System.out.println("ERROR");
            }
    }

    public static void withdraw(String number, String withdraw){
        AccountsList accountsList = AccountsList.getInstance();
        List<Account> list = accountsList.getAccountsList();
        int index;
            if(checkLengthNumbetOfAccount(number) && checkForPositiveNumber(withdraw) && accountIsAlreadyThere(number)){
                    index = returnAccountIndex(number);
                    double sum = list.get(index).getAmmount() - Double.parseDouble(withdraw);
                    if(sum >= 0) {
                        list.get(index).setAmmount(sum);
                        System.out.println("OK");
                    }else {
                        System.out.println("ERROR");
                    }
            }else {
                System.out.println("ERROR");
            }
    }

    public static void balance(String number){
        if(checkLengthNumbetOfAccount(number)) {
            AccountsList accountsList = AccountsList.getInstance();
            List<Account> list = accountsList.getAccountsList();
            int index;
                if(accountIsAlreadyThere(number)){
                    index = returnAccountIndex(number);
                    String balance = String.valueOf(list.get(index).getAmmount());
                    System.out.println(balance);
                }else {
                    System.out.println("ERROR");
                }
        }else {System.out.println("ERROR");}
    }

    private static boolean accountIsAlreadyThere(String number){
        AccountsList accountsList = AccountsList.getInstance();
        List <Account> list = accountsList.getAccountsList();
        if(!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                if (number.equals(list.get(i).getAccountNumber())) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkForPositiveNumber(String ammount){
        try{
            double number = Double.parseDouble(ammount);
            if(number >= 0){
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            return false;
        }
    }

    private static int returnAccountIndex(String number){
        AccountsList accountsList = AccountsList.getInstance();
        List <Account> list = accountsList.getAccountsList();

        if(!list.isEmpty()){
         for (int i = 0; i < list.size(); i++){
             if(list.get(i).accountNumber.equals(number)){
                 return i;
             }
         }
        }
        System.out.println("ERROR");
        return -1;
    }

    @Override
    public int hashCode() {
        return Integer.parseInt(accountNumber);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(!(obj instanceof Account)){
            return false;
        }

        Account account = (Account) obj;
        return account.accountNumber.equals(accountNumber);
    }

}
