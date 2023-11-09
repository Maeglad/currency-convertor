package maelin.assignment.currencyconvertor.presentation.api.controller;

import maelin.assignment.currencyconvertor.domain.model.ConversionRate;
import maelin.assignment.currencyconvertor.domain.use_case.GetAllConversionsUseCase;
import maelin.assignment.currencyconvertor.presentation.api.model.ConversionRateDTO;
import maelin.assignment.currencyconvertor.presentation.api.request.GetAllConversionsRequest;
import maelin.assignment.currencyconvertor.presentation.api.response.BaseApiResponse;
import maelin.assignment.currencyconvertor.presentation.api.response.GetAllConversionsResponse;
import maelin.assignment.currencyconvertor.presentation.api.util.EntityMapper;
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
import static org.mockito.Mockito.when;

/**
 * Test for {@link GetAllConversionsController}
 */
@ExtendWith(MockitoExtension.class)
class GetAllConversionsControllerTest {

    @Mock
    private GetAllConversionsUseCase useCase;

    @Mock
    private EntityMapper entityMapper;
    
    @InjectMocks
    private GetAllConversionsController controller;

    /**
     * Get all conversion after empty request is made<br/>
     * Should end with controller returning all conversions
     */
    @Test
    void getAllConversionsAfterCallIsMadeWithNoRequest() {
        // setup
        BindingResult bindingResult = Mockito.mock(BindingResult.class);

        ConversionRate rate1 = new ConversionRate(1L, "EUR", "GBP", new BigDecimal("1.1"));
        ConversionRate rate2 = new ConversionRate(2L, "GBP", "EUR", new BigDecimal("0.9"));
        List<ConversionRate> rates = Arrays.asList(rate1, rate2);

        ConversionRateDTO rate1DTO = new ConversionRateDTO("EUR", "GBP", "1.1");
        ConversionRateDTO rate2DTO = new ConversionRateDTO( "GBP", "EUR", "0.9");
        List<ConversionRateDTO> expectedResult = Arrays.asList(rate1DTO, rate2DTO);

        Optional<GetAllConversionsRequest> emptyRequest = Optional.empty();

        when(useCase.invoke()).thenReturn(rates);
        when(entityMapper.convertToDTO(rate1)).thenReturn(rate1DTO);
        when(entityMapper.convertToDTO(rate2)).thenReturn(rate2DTO);

        // call controller
        ResponseEntity<? extends BaseApiResponse> result = controller.call(emptyRequest, bindingResult);

        // assert result
        Object body = result.getBody();
        assertNotNull(body);
        assertInstanceOf(GetAllConversionsResponse.class, body);
        GetAllConversionsResponse conversionRatesResponse = (GetAllConversionsResponse) body;
        assertEquals(expectedResult, conversionRatesResponse.conversionRates);
    }
}