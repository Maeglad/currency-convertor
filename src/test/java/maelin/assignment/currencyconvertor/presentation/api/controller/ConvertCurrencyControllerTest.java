package maelin.assignment.currencyconvertor.presentation.api.controller;

import maelin.assignment.currencyconvertor.domain.use_case.ConvertCurrencyUseCase;
import maelin.assignment.currencyconvertor.presentation.api.request.ConvertCurrencyRequest;
import maelin.assignment.currencyconvertor.presentation.api.response.BaseApiResponse;
import maelin.assignment.currencyconvertor.presentation.api.response.ConvertCurrencyResponse;
import maelin.assignment.currencyconvertor.presentation.api.response.ErrorResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

/**
 * Test for {@link ConvertCurrencyController}
 */
@ExtendWith(MockitoExtension.class)
class ConvertCurrencyControllerTest {

    @Mock
    private ConvertCurrencyUseCase useCase;

    @InjectMocks
    private ConvertCurrencyController controller;

    /**
     * Test convert controller behaviour when empty request is provided<br/>
     * Should end with error response
     */
    @Test
    void callConvertWithEmptyRequest() {
        // setup
        BindingResult bindingResult = Mockito.mock(BindingResult.class);

        Optional<ConvertCurrencyRequest> emptyRequest = Optional.empty();

        String expectedMessage = "Missing request";

        // call controller
        ResponseEntity<? extends BaseApiResponse> result = controller.call(emptyRequest, bindingResult);

        // assert result
        Object body = result.getBody();
        assertNotNull(body);
        assertInstanceOf(ErrorResponse.class, body);
        ErrorResponse errorResponse = (ErrorResponse) body;
        // check if there is error message
        assertNotNull(errorResponse.message);
        assertEquals(errorResponse.message, expectedMessage);
    }

    /**
     * Test convert controller when incomplete request is provided.</br>
     * Should end with error response
     */
    @Test
    void convertWithIncompleteRequest() {
        // setup
        BindingResult bindingResult = Mockito.mock(BindingResult.class);

        ConvertCurrencyRequest request = new ConvertCurrencyRequest();
        request.amount = Optional.empty();
        request.fromCurrency = Optional.of("EUR");
        request.toCurrency = Optional.of("GBP");

        Optional<ConvertCurrencyRequest> randomRequest = Optional.of(request);

        String errorMessage = "amount is missing";

        when(bindingResult.hasErrors()).thenReturn(true);
        when(bindingResult.getAllErrors()).thenReturn(List.of(new ObjectError("amount", errorMessage)));

        // call controller
        ResponseEntity<? extends BaseApiResponse> result = controller.call(randomRequest, bindingResult);

        // assert result
        // assert result
        Object body = result.getBody();
        assertNotNull(body);
        assertInstanceOf(ErrorResponse.class, body);
        ErrorResponse errorResponse = (ErrorResponse) body;
        // check if there is error message
        assertNotNull(errorResponse.message);
        assertEquals(errorResponse.message, errorMessage);
    }

    /**
     * Test convert controller when correct request is provided.<br/>
     * Should end with value being correctly converted
     */
    @Test
    void convertWithCorrectRequest() {
        // setup
        BindingResult bindingResult = Mockito.mock(BindingResult.class);

        ConvertCurrencyRequest request = new ConvertCurrencyRequest();
        request.amount = Optional.of(BigDecimal.TEN);
        request.fromCurrency = Optional.of("EUR");
        request.toCurrency = Optional.of("GBP");

        BigDecimal expectedValue = new BigDecimal("20");

        when(useCase.invoke(request.fromCurrency.get(),
                            request.toCurrency.get(),
                            request.amount.get()))
                .thenReturn(Optional.of(expectedValue));

        Optional<ConvertCurrencyRequest> randomRequest = Optional.of(request);

        // call controller
        ResponseEntity<? extends BaseApiResponse> result = controller.call(randomRequest, bindingResult);

        // assert result
        Object body = result.getBody();
        assertNotNull(body);
        assertInstanceOf(ConvertCurrencyResponse.class, body);
        ConvertCurrencyResponse response = (ConvertCurrencyResponse) body;
        assertEquals(response.amount, expectedValue);
    }
}