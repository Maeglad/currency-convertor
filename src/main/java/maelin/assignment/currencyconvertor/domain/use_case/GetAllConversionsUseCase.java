package maelin.assignment.currencyconvertor.domain.use_case;

import jakarta.annotation.Nonnull;
import maelin.assignment.currencyconvertor.data.data_source.ConversionRateRepository;
import maelin.assignment.currencyconvertor.domain.data_service.ConversionRateDataService;
import maelin.assignment.currencyconvertor.domain.model.ConversionRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetAllConversionsUseCase {

    @Nonnull
    private final ConversionRateDataService conversionRateDataService;

    @Autowired
    public GetAllConversionsUseCase(@Nonnull ConversionRateDataService conversionRateDataService) {
        this.conversionRateDataService = conversionRateDataService;
    }

    @Nonnull
    public List<ConversionRate> invoke() {
        return conversionRateDataService.getAllConversionRates();
    }
}
