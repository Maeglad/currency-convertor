package maelin.assignment.currencyconvertor.domain.data_service;

import jakarta.annotation.Nonnull;
import maelin.assignment.currencyconvertor.data.data_service.ConversionRateDataServiceImpl;
import maelin.assignment.currencyconvertor.domain.model.ConversionRate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Binds domain and data layer
 * <p>
 *  Implementations: {@link ConversionRateDataServiceImpl}
 * </p>
 */
@Service
public interface ConversionRateDataService {

    /**
     * Get list of all {@link ConversionRate}s available to application
     * @return
     *      if there are no conversions returns empty list<br/>
     *      list with all conversions otherwise
     */
    @Nonnull
    List<ConversionRate> getAllConversionRates();

    /**
     * Get {@link ConversionRate} between two currencies.
     * @return
     *      if conversion rate does not exist returns empty {@link Optional}<br/>
     *      single conversion rate between two currencies otherwise
     */
    @Nonnull
    Optional<ConversionRate> getConversionRate(String from, String to);

}
