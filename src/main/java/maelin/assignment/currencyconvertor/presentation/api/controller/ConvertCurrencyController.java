package maelin.assignment.currencyconvertor.presentation.api.controller;

import maelin.assignment.currencyconvertor.domain.use_case.ConvertCurrencyUseCase;
import maelin.assignment.currencyconvertor.presentation.api.request.ConvertCurrencyRequest;
import maelin.assignment.currencyconvertor.presentation.api.response.BaseApiResponse;
import maelin.assignment.currencyconvertor.presentation.api.response.ConvertCurrencyResponse;
import maelin.assignment.currencyconvertor.presentation.api.response.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Handles {@link ConvertCurrencyRequest}<br/>
 *
 * @see ConvertCurrencyResponse
 */
@RestController
@RequestMapping(value = "/api/convert", produces = MediaType.APPLICATION_JSON_VALUE)
public class ConvertCurrencyController implements BaseApiController<ConvertCurrencyRequest> {

    private ConvertCurrencyUseCase useCase;

    @Autowired
    public ConvertCurrencyController(ConvertCurrencyUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping(value = "/convert", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<? extends BaseApiResponse> call(
            @Validated
            @RequestBody
            Optional<ConvertCurrencyRequest> request,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String errorMessage = bindingResult.getAllErrors().stream()
                    .map(ObjectError::getDefaultMessage)
                    .collect(Collectors.joining("\n"));
            return ResponseEntity.badRequest().body(new ErrorResponse(errorMessage));
        }

        if (request.isEmpty()) {
            return ResponseEntity.badRequest().body(new ErrorResponse("Missing request"));
        }

        ConvertCurrencyRequest convertRequest = request.get();

        Optional<BigDecimal> convertedAmount = useCase.invoke(convertRequest.fromCurrency.get(),
                convertRequest.toCurrency.get(),
                convertRequest.amount.get());

        if (convertedAmount.isEmpty()) {
            return ResponseEntity.badRequest().body(new ErrorResponse("Conversion rate does not exist"));
        }

        return ResponseEntity.ok(new ConvertCurrencyResponse(convertedAmount.get()));
    }
}
