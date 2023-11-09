package maelin.assignment.currencyconvertor.domain.use_case;

import maelin.assignment.currencyconvertor.domain.data_service.ConversionRateDataService;
import maelin.assignment.currencyconvertor.domain.model.ConversionRate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Test for {@link ConvertCurrencyUseCase}
 */
@ExtendWith(MockitoExtension.class)
class ConvertCurrencyUseCaseTest {

    @Mock
    ConversionRateDataService dataService;

    @InjectMocks
    ConvertCurrencyUseCase useCase;

    /**
     * Call {@link ConvertCurrencyUseCase#invoke(String, String, BigDecimal)} and
     * assert if it returns empty {@link Optional} for non-existent conversion
     */
    @Test
    void convertCurrencyAndCurrencyDoesNotExist() {
        // setUp
        String fromCurrency = "EUR";
        String toCurrency = "GBP";
        BigDecimal amount = BigDecimal.TEN;
        when(dataService.getConversionRate(fromCurrency, toCurrency)).thenReturn(Optional.empty());

        // call use case
        Optional<BigDecimal> convertedValue = useCase.invoke(fromCurrency, toCurrency, amount);

        // assert results
        assert (convertedValue.isEmpty());
    }

    /**
     * Call {@link ConvertCurrencyUseCase#invoke(String, String, BigDecimal)} and
     * assert if converted value corresponds to expected value
     */
    @Test
    void convertCurrencyBetweenTwoExisting() {
        // setUp
        String fromCurrency = "EUR";
        String toCurrency = "GBP";
        BigDecimal amount = BigDecimal.TEN;
        Optional<ConversionRate> conversionRate = Optional.of(new ConversionRate(
                1L,
                fromCurrency,
                toCurrency,
                new BigDecimal("1.2")
        ));
        when(dataService.getConversionRate(fromCurrency, toCurrency)).thenReturn(conversionRate);
        Optional<BigDecimal> expectedResult = conversionRate.map(ConversionRate::getRate)
                .map(amount::multiply);

        // call use case
        Optional<BigDecimal> convertedValue = useCase.invoke(fromCurrency, toCurrency, amount);

        // assert results
        assertEquals(expectedResult, convertedValue);
    }
}