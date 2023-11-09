package maelin.assignment.currencyconvertor.presentation.api.controller;

import maelin.assignment.currencyconvertor.presentation.api.request.BaseApiRequest;
import maelin.assignment.currencyconvertor.presentation.api.response.BaseApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public interface BaseApiController <T extends BaseApiRequest> {

     ResponseEntity<? extends BaseApiResponse> call(
             @Validated
             @RequestBody
             Optional<T> request,
             BindingResult bindingResult);
}
