package maelin.assignment.currencyconvertor.data.data_service;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import maelin.assignment.currencyconvertor.data.data_source.ConversionRateRepository;
import maelin.assignment.currencyconvertor.domain.data_service.ConversionRateDataService;
import maelin.assignment.currencyconvertor.domain.model.ConversionRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConversionRateDataServiceImpl implements ConversionRateDataService {

    private final ConversionRateRepository conversionRateRepository;

    @Autowired
    public ConversionRateDataServiceImpl(ConversionRateRepository conversionRateRepository) {
        this.conversionRateRepository = conversionRateRepository;
    }

    @Nonnull
    @Override
    public List<ConversionRate> getAllConversionRates() {
        return conversionRateRepository.getAllConversionRates();

    }

    @Nullable
    @Override
    public ConversionRate getConversionRate(String from, String to) {
        return conversionRateRepository.getConversionRate(from, to);
    }
}
