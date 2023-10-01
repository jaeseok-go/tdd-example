import java.math.BigDecimal;
import java.util.Map;
import java.util.Objects;

public class Exchanger {
    public static Map<CurrencyPair, BigDecimal> exchangeRates = Map.of(
            new CurrencyPair(Currency.DOLLAR, Currency.WON), BigDecimal.valueOf(1352.92),
            new CurrencyPair(Currency.WON, Currency.DOLLAR), BigDecimal.valueOf(0.00074)
    );

    static class CurrencyPair {
        private Currency from;
        private Currency to;

        public CurrencyPair(Currency from, Currency to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public boolean equals(Object o) {
            CurrencyPair currencyPair = (CurrencyPair) o;
            return this.from.equals(currencyPair.from)
                    && this.to.equals(currencyPair.to);
        }

        @Override
        public int hashCode() {
            int result = Objects.hashCode(from);
            result = 31 * result + Objects.hashCode(to);
            return result;
        }
    }

    public static Money exchangeTo(Money money, Currency to) {
        Currency from = money.currency();
        BigDecimal exchangeRate = exchangeRates.get(new CurrencyPair(from, to));
        double calculatedAmount = BigDecimal.valueOf(money.amount())
                .multiply(exchangeRate)
                .doubleValue();

        return Money.of(calculatedAmount, to);
    }
}
