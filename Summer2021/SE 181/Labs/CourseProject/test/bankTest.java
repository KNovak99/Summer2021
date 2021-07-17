import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class bankTest {

    @Test
    void create_bank() {
        Bank bank = new Bank();
    }

    @Test
    void add_checking_account() {
        Checking ckg = new Checking(12345678, 0.01);
        Bank bank = new Bank();
        bank.addAccount(ckg);
        Assertions.assertEquals(bank.getAccount(12345678), ckg);
    }

    @Test
    void add_savings_account() {
        CD cd = new CD(12345678, 1.2, 2000);
        Bank bank = new Bank();
        bank.addAccount(cd);
        Assertions.assertEquals(bank.getAccount(12345678), cd);
    }

    @Test
    void add_cd_account() {
        Savings svg = new Savings(12345678, 0.06);
        Bank bank = new Bank();
        bank.addAccount(svg);
        Assertions.assertEquals(bank.getAccount(12345678), svg);
    }

    @Test
    void account_doesnt_exist() {
        Checking ckg = new Checking(12345678, 0.01);
        Savings svg = new Savings(12348765, 0.01);
        Bank bank = new Bank();
        bank.addAccount(ckg);
        bank.addAccount(svg);
        Assertions.assertNull(bank.getAccount(11112222));
    }

    @Test
    void create_all_accounts() {
        Checking ckg = new Checking(12345678, 0.01);
        Savings svg = new Savings(87654321, 0.06);
        CD cd = new CD(12348765, 0.06, 1000);
        Bank bank = new Bank();
        bank.addAccount(ckg);
        bank.addAccount(svg);
        bank.addAccount(cd);
        Assertions.assertEquals(bank.getAccount(12345678), ckg);
        Assertions.assertEquals(bank.getAccount(87654321), svg);
        Assertions.assertEquals(bank.getAccount(12348765), cd);
    }

}
