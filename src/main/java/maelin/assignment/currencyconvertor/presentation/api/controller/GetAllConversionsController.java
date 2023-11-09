package maelin.assignment.currencyconvertor.presentation.api.controller;

import maelin.assignment.currencyconvertor.domain.use_case.GetAllConversionsUseCase;
import maelin.assignment.currencyconvertor.presentation.api.request.BaseApiRequest;
import maelin.assignment.currencyconvertor.presentation.api.response.BaseApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api/conversions", produces = MediaType.APPLICATION_JSON_VALUE)
public class GetAllConversionsController implements BaseApiController<BaseApiRequest> {

    private GetAllConversionsUseCase useCase;

    @Autowired
    public GetAllConversionsController(GetAllConversionsUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    @GetMapping(value = "/conversions", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<? extends BaseApiResponse> call(
            @Validated
            @RequestBody
            Optional<BaseApiRequest> request,
            BindingResult bindingResult) {
        return null;
    }
}
