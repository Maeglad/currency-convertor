package maelin.assignment.currencyconvertor.presentation.api.response;

import maelin.assignment.currencyconvertor.presentation.api.model.ConversionRateDTO;

import java.util.List;

/**
 * API response containing all available conversions
 */
public class GetAllConversionsResponse extends BaseApiResponse {

    public final List<ConversionRateDTO> conversionRates;

    public GetAllConversionsResponse(List<ConversionRateDTO> conversionRates) {
        super(true);
        this.conversionRates = conversionRates;
    }
}
