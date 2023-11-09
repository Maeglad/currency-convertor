package maelin.assignment.currencyconvertor.data.data_service;

import maelin.assignment.currencyconvertor.data.data_source.ConversionRateRepository;
import maelin.assignment.currencyconvertor.domain.model.ConversionRate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ConversionRateDataServiceImplTest {

    @Mock
    ConversionRateRepository conversionRateRepository;

    @InjectMocks
    ConversionRateDataServiceImpl conversionRateDataService;


    /**
     * Call {@link ConversionRateDataServiceImpl#getAllConversionRates()} and
     * assert if amount of results is same as what was provided to mock object
     */
    @Test
    void getAllConversionRatesTest() {
        // setup
        ConversionRate rate1 = new ConversionRate(1L, "EUR", "GBP", new BigDecimal("1.1"));
        ConversionRate rate2 = new ConversionRate(2L, "GBP", "EUR", new BigDecimal("0.9"));
        List<ConversionRate> expectedResult = Arrays.asList(rate1, rate2);
        when(conversionRateRepository.getAllConversionRates()).thenReturn(expectedResult);

        // get all conversion rates
        List<ConversionRate> conversionRates = conversionRateDataService.getAllConversionRates();

        // assert results
        assertEquals(expectedResult, conversionRates);
    }

    /**
     * We are expecting conversion rate to exist.
     * Call {@link ConversionRateDataServiceImpl#getConversionRate(String, String)} and
     * assert if conversion rate is same as one provided by mock object.
     */
    @Test
    void getConversionRate() {
        // setup
        ConversionRate expectedConversionRate =
                new ConversionRate(1L,
                        "EUR",
                        "GBP",
                        new BigDecimal("1.1"));

        String fromCurrency = "EUR";
        String toCurrency = "GBP";
        when(conversionRateRepository.getConversionRate(fromCurrency, toCurrency))
                .thenReturn(new ConversionRate(
                        1L,
                        "EUR",
                        "GBP",
                        new BigDecimal("1.1")));

        // get conversion rate between EUR and GBP
        ConversionRate actualConversionRate = conversionRateDataService
                .getConversionRate(fromCurrency, toCurrency);

        // assert results
        assertEquals(expectedConversionRate, actualConversionRate);
    }

    /**
     * We are expecting conversion rate to not exist.
     * Call {@link ConversionRateDataServiceImpl#getConversionRate(String, String)} and
     * assert if function returned null as expected for non-existent conversion rate.
     */
    @Test
    void getConversionRate_NotFound() {
        // setup
        String fromCurrency = "EUR";
        String toCurrency = "GBP";
        when(conversionRateRepository.getConversionRate(fromCurrency, toCurrency))
                .thenReturn(null);

        // get conversion rate between EUR and GBP
        ConversionRate actualConversionRate = conversionRateDataService
                .getConversionRate(fromCurrency, toCurrency);

        // assert results
        assertNull(actualConversionRate);
    }
}