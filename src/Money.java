public class Money {
    private int amount;

    public Money(int amount) {
        this.amount = amount;
    }

    public static Money won(int amount) {
        return new Money(amount);
    }

    public Money times(int number) {
        return new Money(amount * number);
    }

    @Override
    public boolean equals(Object o) {
        Money money = (Money) o;
        return money.amount == this.amount;
    }
}
