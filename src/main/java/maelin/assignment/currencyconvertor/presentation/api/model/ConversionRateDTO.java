package maelin.assignment.currencyconvertor.presentation.api.model;

import java.math.BigDecimal;
import java.util.Optional;

public class ConversionRateDTO {
    public final String fromCurrency;
    public final String toCurrency;
    public final BigDecimal conversionRate;

    public ConversionRateDTO(String fromCurrency, String toCurrency, BigDecimal conversionRate) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.conversionRate = conversionRate;
    }
}
