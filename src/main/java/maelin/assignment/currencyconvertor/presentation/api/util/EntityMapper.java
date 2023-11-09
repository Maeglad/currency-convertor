package maelin.assignment.currencyconvertor.presentation.api.util;

import maelin.assignment.currencyconvertor.domain.model.ConversionRate;
import maelin.assignment.currencyconvertor.presentation.api.model.ConversionRateDTO;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * Helper class for converting entities to DTO
 *
 * @see ConversionRateDTO
 * @see ConversionRate
 */
@Component
public class EntityMapper {

    ModelMapper modelMapper;

    @Autowired
    public EntityMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        modelMapper.addConverter(new BigDecimalStringConverter());
        configure();
    }

    public void configure() {
        modelMapper.addMappings(new PropertyMap<ConversionRate, ConversionRateDTO>() {
            @Override
            protected void configure() {
                map(source.getFromCurrency(), destination.fromCurrency);
                map(source.getToCurrency(), destination.toCurrency);
                map(source.getRate(), destination.conversionRate);
            }
        });
    }

    public ConversionRateDTO convertToDTO(ConversionRate conversionRate) {
        return modelMapper.map(conversionRate, ConversionRateDTO.class);
    }

    private class BigDecimalStringConverter implements Converter<BigDecimal, String> {

        @Override
        public String convert(MappingContext<BigDecimal, String> context) {
            if (context.getSource() != null) {
                return context.getSource().toPlainString();
            }

            return null;
        }
    }
}
