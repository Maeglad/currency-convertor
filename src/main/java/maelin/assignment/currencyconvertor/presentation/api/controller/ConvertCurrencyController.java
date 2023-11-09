package maelin.assignment.currencyconvertor.presentation.api.controller;

import maelin.assignment.currencyconvertor.presentation.api.request.ConvertCurrencyRequest;
import maelin.assignment.currencyconvertor.presentation.api.response.BaseApiResponse;
import maelin.assignment.currencyconvertor.presentation.api.response.ConvertCurrencyResponse;
import maelin.assignment.currencyconvertor.presentation.api.response.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/convert")
public class ConvertCurrencyController implements BaseApiController<ConvertCurrencyRequest, ConvertCurrencyResponse> {

    @PostMapping("/convert")
    public ResponseEntity<ConvertCurrencyResponse> call(
            @Validated
            @RequestBody
            ConvertCurrencyRequest request,
            BindingResult bindingResult) {

        return null;
    }
}
