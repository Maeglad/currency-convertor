package maelin.assignment.currencyconvertor.presentation.api.model;

import maelin.assignment.currencyconvertor.domain.model.ConversionRate;

import java.math.BigDecimal;

/**
 * Data transfer object that holds data from {@link ConversionRate}
 * without exposing internal data that are not relevant for request
 */
public class ConversionRateDTO {
    public String fromCurrency;
    public String toCurrency;
    public String conversionRate;

    public ConversionRateDTO() {

    }

    public ConversionRateDTO(String fromCurrency, String toCurrency, String conversionRate) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.conversionRate = conversionRate;
    }
}
