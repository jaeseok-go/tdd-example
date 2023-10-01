public class Money {
    private double amount;

    private Currency currency;

    public Money(double amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public static Money of(double amount, Currency currency) {
        return new Money(amount, currency);
    }

    public Money times(double number) {
        return new Money(amount * number, currency);
    }

    public Money plus(Money money) {
        return new Money(amount + money.amount, currency);
    }

    public double amount() {
        return this.amount;
    }

    public Currency currency() {
        return this.currency;
    }

    @Override
    public boolean equals(Object o) {
        Money money = (Money) o;
        return money.amount == this.amount
                && money.currency.equals(this.currency);
    }

    @Override
    public String toString() {
        return String.format("[amount: %s, currency: %s]", this.amount, this.currency);
    }
}
