import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> accounts = new ArrayList<Account>();


    public Account getAccount(int i) {
        for (Account acct : this.accounts) {
            if (acct.getAccountNumber() == i) {
                return acct;
            }
        }
        return null;
    }

    public void addAccount(Account acct) {
        this.accounts.add(acct);
    }
}
