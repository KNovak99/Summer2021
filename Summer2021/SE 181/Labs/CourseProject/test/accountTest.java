import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class accountTest {
    @Test
    void balance_below_zero() {
        Checking ckg = new Checking(12345678, 0.01);
        Savings svg = new Savings(87654321, 0.06);
        CD cd = new CD(12348765, 0.06, 1000);
        ckg.deposit(500);
        svg.deposit(500);
        ckg.withdraw(600);
        svg.withdraw(600);
        cd.withdraw(1100);
        Assertions.assertEquals(ckg.getValue(), 0);
        Assertions.assertEquals(svg.getValue(), 0);
        Assertions.assertEquals(cd.getValue(), 0);
    }
}
