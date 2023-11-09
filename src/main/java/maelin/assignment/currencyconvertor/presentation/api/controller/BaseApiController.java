package maelin.assignment.currencyconvertor.presentation.api.controller;

import maelin.assignment.currencyconvertor.presentation.api.request.BaseApiRequest;
import maelin.assignment.currencyconvertor.presentation.api.request.ConvertCurrencyRequest;
import maelin.assignment.currencyconvertor.presentation.api.response.BaseApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface BaseApiController <T extends BaseApiRequest, V extends BaseApiResponse> {

     ResponseEntity<V> call(
             @Validated
             @RequestBody
             T request,
             BindingResult bindingResult);
}
