package maelin.assignment.currencyconvertor.presentation.api.request;

import jakarta.validation.constraints.NotBlank;
import maelin.assignment.currencyconvertor.presentation.api.controller.ConvertCurrencyController;
import maelin.assignment.currencyconvertor.presentation.api.util.validator.NotBlankBigDecimal;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * Request for converting amount from one currency to another
 *
 * @see ConvertCurrencyController
 */
public class ConvertCurrencyRequest extends BaseApiRequest {

    @NotBlank(message = "fromCurrency field is blank")
    public String fromCurrency;

    @NotBlank(message = "toCurrency field is blank")
    public String toCurrency;

    @NotBlankBigDecimal(message = "amount field is blank")
    public BigDecimal amount;

}
