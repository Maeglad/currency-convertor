package maelin.assignment.currencyconvertor.presentation.api.controller;

import maelin.assignment.currencyconvertor.presentation.api.request.BaseApiRequest;
import maelin.assignment.currencyconvertor.presentation.api.request.ConvertCurrencyRequest;
import maelin.assignment.currencyconvertor.presentation.api.response.BaseApiResponse;
import maelin.assignment.currencyconvertor.presentation.api.response.GetAllConversionsResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/conversions")
public class GetAllConversionsController implements BaseApiController<BaseApiRequest, GetAllConversionsResponse> {
    @Override
    @GetMapping("/conversions")
    public ResponseEntity<GetAllConversionsResponse> call(
            @Validated
            @RequestBody
            BaseApiRequest request,
            BindingResult bindingResult) {
        return null;
    }
}
