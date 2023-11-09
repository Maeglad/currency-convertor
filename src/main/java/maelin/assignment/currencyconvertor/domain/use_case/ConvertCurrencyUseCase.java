package maelin.assignment.currencyconvertor.domain.use_case;

import jakarta.annotation.Nonnull;
import maelin.assignment.currencyconvertor.domain.data_service.ConversionRateDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class ConvertCurrencyUseCase {

    private final ConversionRateDataService conversionRateDataService;

    @Autowired
    public ConvertCurrencyUseCase(ConversionRateDataService conversionRateDataService) {
        this.conversionRateDataService = conversionRateDataService;
    }

    @Nonnull
    public Optional<BigDecimal> invoke(
            @Nonnull String from,
            @Nonnull String to,
            @Nonnull BigDecimal amount) {
        return null;
    }
}
