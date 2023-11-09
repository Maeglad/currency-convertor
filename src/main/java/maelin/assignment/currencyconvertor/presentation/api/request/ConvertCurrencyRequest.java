package maelin.assignment.currencyconvertor.presentation.api.request;

import jakarta.validation.constraints.NotBlank;
import maelin.assignment.currencyconvertor.presentation.api.controller.ConvertCurrencyController;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * Request for converting amount from one currency to another
 *
 * @see ConvertCurrencyController
 */
public class ConvertCurrencyRequest extends BaseApiRequest {

    @NotBlank(message = "fromCurrency field is blank")
    public Optional<String> fromCurrency;

    @NotBlank(message = "toCurrency field is blank")
    public Optional<String> toCurrency;

    @NotBlank(message = "amount field is blank")
    public Optional<BigDecimal> amount;

}
