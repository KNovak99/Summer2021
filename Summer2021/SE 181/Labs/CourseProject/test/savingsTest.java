import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class savingsTest {
    @Test
    void deposit_into_savings() {
        Savings svg = new Savings(12345678, 0.01);
        svg.deposit(1000);
        Assertions.assertEquals(svg.getValue(), 1000);
    }

    @Test
    void make_two_deposits_into_savings() {
        Savings svg = new Savings(12345678, 0.01);
        svg.deposit(1000);
        svg.deposit(500);
        Assertions.assertEquals(svg.getValue(), 1500);
    }

    @Test
    void withdraw_from_savings() {
        Savings svg = new Savings(1234578, 0.01);
        svg.deposit(1000);
        svg.withdraw(500);
        Assertions.assertEquals(svg.getValue(), 500);
    }

    @Test
    void withdraw_from_savings_twice() {
        Savings svg = new Savings(1234578, 0.01);
        svg.deposit(1000);
        svg.withdraw(500);
        svg.withdraw(250);
        Assertions.assertEquals(svg.getValue(), 250);
    }
}
