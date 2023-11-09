package maelin.assignment.currencyconvertor.presentation.api.controller;

import maelin.assignment.currencyconvertor.domain.use_case.ConvertCurrencyUseCase;
import maelin.assignment.currencyconvertor.presentation.api.request.ConvertCurrencyRequest;
import maelin.assignment.currencyconvertor.presentation.api.response.BaseApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

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

        return null;
    }
}
