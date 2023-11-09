package maelin.assignment.currencyconvertor.domain.use_case;

import maelin.assignment.currencyconvertor.domain.data_service.ConversionRateDataService;
import maelin.assignment.currencyconvertor.domain.model.ConversionRate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetAllConversionsUseCaseTest {

    @Mock
    ConversionRateDataService dataService;

    @InjectMocks
    GetAllConversionsUseCase useCase;

    /**
     * Call {@link GetAllConversionsUseCase#invoke()} and
     * assert if amount of results is same as what was provided to mock object
     */
    @Test
    void testInvokeToGetAllConversionRates() {
        // setup
        ConversionRate rate1 = new ConversionRate(1L, "EUR", "GBP", new BigDecimal("1.1"));
        ConversionRate rate2 = new ConversionRate(2L, "GBP", "EUR", new BigDecimal("0.9"));
        List<ConversionRate> expectedResult = Arrays.asList(rate1, rate2);
        when(dataService.getAllConversionRates()).thenReturn(expectedResult);

        // call use case
        List<ConversionRate> returnedConversionRates = useCase.invoke();

        assertEquals(expectedResult, returnedConversionRates);
    }
}