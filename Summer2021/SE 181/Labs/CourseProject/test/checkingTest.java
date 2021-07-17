import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class checkingTest {

    @Test
    void create_checking() {
        Checking ckg = new Checking(12345678, 0.01);
        Assertions.assertEquals(ckg.getAccountNumber(), 12345678);
        Assertions.assertEquals(ckg.getAPR(), 0.01);
    }

    @Test
    void deposit_into_checking() {
        Checking ckg = new Checking(12345678, 0.01);
        ckg.deposit(1000);
        Assertions.assertEquals(ckg.getValue(), 1000);
    }

    @Test
    void make_two_deposits_into_checking() {
        Checking ckg = new Checking(12345678, 0.01);
        ckg.deposit(1000);
        ckg.deposit(500);
        Assertions.assertEquals(ckg.getValue(), 1500);
    }

    @Test
    void withdraw_from_checking() {
        Checking ckg = new Checking(1234578, 0.01);
        ckg.deposit(1000);
        ckg.withdraw(500);
        Assertions.assertEquals(ckg.getValue(), 500);
    }

    @Test
    void withdraw_from_checking_twice() {
        Checking ckg = new Checking(1234578, 0.01);
        ckg.deposit(1000);
        ckg.withdraw(500);
        ckg.withdraw(250);
        Assertions.assertEquals(ckg.getValue(), 250);
    }
}
