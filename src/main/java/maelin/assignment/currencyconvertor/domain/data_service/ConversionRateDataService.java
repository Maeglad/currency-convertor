package maelin.assignment.currencyconvertor.domain.data_service;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import maelin.assignment.currencyconvertor.domain.model.ConversionRate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ConversionRateDataService {

    @Nonnull
    List<ConversionRate> getAllConversionRates();

    @Nullable
    ConversionRate getConversionRate(String from, String to);

}
