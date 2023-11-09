package maelin.assignment.currencyconvertor.presentation.api.controller;

import maelin.assignment.currencyconvertor.domain.model.ConversionRate;
import maelin.assignment.currencyconvertor.domain.use_case.GetAllConversionsUseCase;
import maelin.assignment.currencyconvertor.presentation.api.model.ConversionRateDTO;
import maelin.assignment.currencyconvertor.presentation.api.request.BaseApiRequest;
import maelin.assignment.currencyconvertor.presentation.api.request.ConvertCurrencyRequest;
import maelin.assignment.currencyconvertor.presentation.api.response.BaseApiResponse;
import maelin.assignment.currencyconvertor.presentation.api.response.GetAllConversionsResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link GetAllConversionsController}
 */
@ExtendWith(MockitoExtension.class)
class GetAllConversionsControllerTest {

    @Mock
    private GetAllConversionsUseCase useCase;
    
    @InjectMocks
    private GetAllConversionsController controller;

    /**
     * Get all conversion after request is made
     */
    @Test
    void getAllConversionsAfterCallIsMadeWithNoRequest() {
        // setup
        BindingResult bindingResult = Mockito.mock(BindingResult.class);

        ConversionRateDTO rate1 = new ConversionRateDTO("EUR", "GBP", new BigDecimal("1.1"));
        ConversionRateDTO rate2 = new ConversionRateDTO( "GBP", "EUR", new BigDecimal("0.9"));
        List<ConversionRateDTO> expectedResult = Arrays.asList(rate1, rate2);
        Optional<BaseApiRequest> emptyRequest = Optional.empty();

        // call controller
        ResponseEntity<? extends BaseApiResponse> result = controller.call(emptyRequest, bindingResult);

        // assert result
        assertNotNull(result.getBody());
        assertInstanceOf(GetAllConversionsResponse.class, result.getBody());
        GetAllConversionsResponse conversionRatesResponse = (GetAllConversionsResponse) result.getBody();
        assertEquals(expectedResult, conversionRatesResponse.conversionRates);
    }

    @Test
    void getAllConversionsAfterCallIsMadeWithSomeRandomRequest() {
        // setup
        BindingResult bindingResult = Mockito.mock(BindingResult.class);

        ConversionRateDTO rate1 = new ConversionRateDTO("EUR", "GBP", new BigDecimal("1.1"));
        ConversionRateDTO rate2 = new ConversionRateDTO( "GBP", "EUR", new BigDecimal("0.9"));
        List<ConversionRateDTO> expectedResult = Arrays.asList(rate1, rate2);

        ConvertCurrencyRequest request = new ConvertCurrencyRequest();
        request.amount = Optional.of(BigDecimal.ZERO);
        request.fromCurrency = Optional.of("EUR");
        request.toCurrency = Optional.of("GBP");

        Optional<BaseApiRequest> randomRequest = Optional.of(request);

        // call controller
        ResponseEntity<? extends BaseApiResponse> result = controller.call(randomRequest, bindingResult);

        // assert result
        assertNotNull(result.getBody());
        assertInstanceOf(GetAllConversionsResponse.class, result.getBody());
        GetAllConversionsResponse conversionRatesResponse = (GetAllConversionsResponse) result.getBody();
        assertEquals(expectedResult, conversionRatesResponse.conversionRates);
    }
}