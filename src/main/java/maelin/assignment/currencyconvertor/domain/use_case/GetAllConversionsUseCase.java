package maelin.assignment.currencyconvertor.domain.use_case;

import jakarta.annotation.Nonnull;
import maelin.assignment.currencyconvertor.domain.data_service.ConversionRateDataService;
import maelin.assignment.currencyconvertor.domain.model.ConversionRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Get list of all conversions available to application
 */
@Service
public class GetAllConversionsUseCase {

    @Nonnull
    private final ConversionRateDataService conversionRateDataService;

    @Autowired
    public GetAllConversionsUseCase(@Nonnull ConversionRateDataService conversionRateDataService) {
        this.conversionRateDataService = conversionRateDataService;
    }

    /**
     * @return
     *      if there are no conversions returns empty list<br/>
     *      list with all conversions otherwise
     */
    @Nonnull
    public List<ConversionRate> invoke() {
        return conversionRateDataService.getAllConversionRates();
    }
}
