package maelin.assignment.currencyconvertor.presentation.api.response;

import java.math.BigDecimal;

/**
 * API response containing amount after it was converted
 */
public class ConvertCurrencyResponse extends BaseApiResponse {
    public final BigDecimal amount;

    public ConvertCurrencyResponse(BigDecimal amount) {
        super(true);
        this.amount = amount;
    }
}
