package maelin.assignment.currencyconvertor.domain.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;


@Entity(name = ConversionRate.TABLE_NAME)
public class ConversionRate {

    public static final String TABLE_NAME = "CONVERSION_RATE";
    public static final String ID_NAME = "ID";
    public static final String FROM_CURRENCY_NAME = "FROM_CURRENCY";
    public static final String TO_CURRENCY_NAME = "TO_CURRENCY";
    public static final String RATE_NAME = "RATE";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Nonnull
    @Column(name = ID_NAME)
    private Long id;

    @Column(name = FROM_CURRENCY_NAME)
    @Nonnull
    private String fromCurrency;

    @Column(name = TO_CURRENCY_NAME)
    @Nonnull
    private String toCurrency;

    @Column(name = RATE_NAME)
    @Nonnull
    private BigDecimal rate;

    public ConversionRate(@Nonnull Long id,
                          @Nonnull String fromCurrency,
                          @Nonnull String toCurrency,
                          @Nonnull BigDecimal rate) {
        this.id = id;
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.rate = rate;
    }


    public ConversionRate() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConversionRate that = (ConversionRate) o;
        return Objects.equals(id, that.id)
                && Objects.equals(fromCurrency, that.fromCurrency)
                && Objects.equals(toCurrency, that.toCurrency)
                && Objects.equals(rate, that.rate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fromCurrency, toCurrency, rate);
    }
}
