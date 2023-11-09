package maelin.assignment.currencyconvertor.presentation.api.response;

import java.math.BigDecimal;

/**
 * API response containing amount after it was converted
 */
public class ConvertCurrencyResponse extends BaseApiResponse {
    public final String amount;

    public ConvertCurrencyResponse(String amount) {
        super(true);
        this.amount = amount;
    }
}
