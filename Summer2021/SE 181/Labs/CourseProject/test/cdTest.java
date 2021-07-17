import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class cdTest {
    @Test
    void withdraw_from_cd() {
        CD cd = new CD(1234578, 0.01, 1000);
        cd.deposit(1000);
        cd.withdraw(500);
        Assertions.assertEquals(cd.getValue(), 1500);
    }

    @Test
    void withdraw_from_cd_twice() {
        CD cd = new CD(1234578, 0.01, 1000);
        cd.deposit(1000);
        cd.withdraw(500);
        cd.withdraw(250);
        Assertions.assertEquals(cd.getValue(), 1250);
    }
}
