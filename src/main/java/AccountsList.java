import java.util.ArrayList;
import java.util.List;


public class AccountsList {

    private List<Account> accountsList = null;

    private static AccountsList ourInstance = new AccountsList();

    public static AccountsList getInstance() {
        return ourInstance;
    }

    private AccountsList() {
        this.accountsList = new ArrayList<>();
    }

    public List<Account> getAccountsList() {
        return accountsList;
    }

    public void setAccountsList(List<Account> accountsList) {
        this.accountsList = accountsList;
    }
}
