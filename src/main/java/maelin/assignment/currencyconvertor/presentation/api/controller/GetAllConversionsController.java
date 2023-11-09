package maelin.assignment.currencyconvertor.presentation.api.controller;

import maelin.assignment.currencyconvertor.domain.use_case.GetAllConversionsUseCase;
import maelin.assignment.currencyconvertor.presentation.api.model.ConversionRateDTO;
import maelin.assignment.currencyconvertor.presentation.api.request.GetAllConversionsRequest;
import maelin.assignment.currencyconvertor.presentation.api.response.BaseApiResponse;
import maelin.assignment.currencyconvertor.presentation.api.response.ConvertCurrencyResponse;
import maelin.assignment.currencyconvertor.presentation.api.response.ErrorResponse;
import maelin.assignment.currencyconvertor.presentation.api.response.GetAllConversionsResponse;
import maelin.assignment.currencyconvertor.presentation.api.util.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Handles requests for getting all conversions<br/>
 *
 * @see ConvertCurrencyResponse
 */
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class GetAllConversionsController implements BaseApiController<GetAllConversionsRequest> {

    private final GetAllConversionsUseCase useCase;

    private final EntityMapper entityMapper;

    @Autowired
    public GetAllConversionsController(GetAllConversionsUseCase useCase,
                                       EntityMapper entityMapper) {
        this.useCase = useCase;
        this.entityMapper = entityMapper;
    }

    @Override
    @GetMapping(value = "/conversions", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<? extends BaseApiResponse> call(
            @Validated
            @RequestBody
            Optional<GetAllConversionsRequest> request,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String errorMessage = bindingResult.getAllErrors().stream()
                    .map(ObjectError::getDefaultMessage)
                    .collect(Collectors.joining("\n"));
            return ResponseEntity.badRequest().body(new ErrorResponse(errorMessage));
        }

        List<ConversionRateDTO> results = useCase.invoke()
                .stream().map(entityMapper::convertToDTO).toList();

        return ResponseEntity.ok(new GetAllConversionsResponse(results));
    }
}
