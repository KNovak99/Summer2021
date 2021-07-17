public class Account {
    public static double APR;
    public final int accountNum;
    public int value;

    public Account(int i, double v) {
        this.accountNum = i;
        this.APR = v;
    }

    public int getAccountNumber() {
        return this.accountNum;
    }

    public double getAPR() {
        return this.APR;
    }

    public int getValue() {
        return this.value;
    }

    public void deposit(int amount) {
        this.value += amount;
    }

    public void withdraw(int amount) {
        if (this.value - amount < 0) {
            this.value = 0;
        } else {
            this.value -= amount;
        }
    }
}
