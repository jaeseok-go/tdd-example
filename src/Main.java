import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    /*
        1. 어떤 금액을 어떤 수에 곱한 금액을 결과로 얻을 수 있어야 한다.
        2. 통화가 다른 두 금액을 더해서 주어진 환율에 맞게 변한 금액을 결과로 얻을 수 있어야 한다.
    */

    @Test
    void 어떤_금액을_어떤_수에_곱한_금액을_얻는다() {
        // given
        Money oneWon = Money.of(1, Currency.WON);

        // when
        Money twoWon = oneWon.times(2);

        // then
        Assertions.assertEquals(Money.of(2, Currency.WON), twoWon);
    }

    @Test
    void 어떤_금액과_어떤_금액을_더한_금액을_얻는다() {
        // given
        Money oneWon = Money.of(1, Currency.WON);

        // when
        Money twoWon = oneWon.plus(Money.of(1, Currency.WON));
        Money threeWon = oneWon.plus(Money.of(2, Currency.WON));

        // then
        Assertions.assertEquals(Money.of(2, Currency.WON), twoWon);
        Assertions.assertEquals(Money.of(3, Currency.WON), threeWon);
    }

    @Test
    void 어떤_통화를_다른_통화로_환전한다() {
        // given
        Money thousandWon = Money.of(1000, Currency.WON);

        // when
        Money oneDollar = Exchanger.exchangeTo(thousandWon, Currency.DOLLAR);
        double exceptedAmount = Exchanger.exchangeRates.get(new Exchanger.CurrencyPair(Currency.WON, Currency.DOLLAR)).doubleValue() * 1000;

        // then
        Assertions.assertEquals(Money.of(exceptedAmount, Currency.DOLLAR), oneDollar);
    }

    @Test
    void 특정_통화의_금액과_다른_통화의_금액을_더할_수_있다() {
        // given
        Money thousandWon = Money.of(1000, Currency.WON);
        Money oneDollar = Money.of(1, Currency.DOLLAR);

        // when
        Money firstResult = thousandWon.plus(oneDollar);
        Money secondResult = oneDollar.plus(thousandWon);

        // then
        Assertions.assertEquals(Money.of(1000 + 1352.92, Currency.WON), firstResult);
        Assertions.assertEquals(Money.of(1 + (1000 * 0.00074), Currency.DOLLAR), secondResult);
    }
}