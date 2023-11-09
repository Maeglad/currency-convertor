package maelin.assignment.currencyconvertor.presentation.api.response;

import java.math.BigDecimal;

public class ConvertCurrencyResponse extends BaseApiResponse {
    public final BigDecimal amount;

    public ConvertCurrencyResponse(BigDecimal amount) {
        super(true);
        this.amount = amount;
    }
}
