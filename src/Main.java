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
        Money oneWon = Money.won(1);

        // when
        Money twoWon = oneWon.times(2);

        // then
        Assertions.assertEquals(Money.won(2), twoWon);
    }

    @Test
    void 어떤_금액과_어떤_금액을_더한_금액을_얻는다() {
        // given
        Money oneWon = Money.won(1);

        // when
        Money twoWon = oneWon.plus(Money.won(1));
        Money threeWon = oneWon.plus(Money.won(2));

        // then
        Assertions.assertEquals(Money.won(2), twoWon);
        Assertions.assertEquals(Money.won(3), threeWon);
    }
}