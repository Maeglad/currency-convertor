package maelin.assignment.currencyconvertor.presentation.api.response;

import maelin.assignment.currencyconvertor.domain.model.ConversionRate;
import maelin.assignment.currencyconvertor.presentation.api.model.ConversionRateDTO;

import java.util.List;

public class GetAllConversionsResponse extends BaseApiResponse {

    private List<ConversionRateDTO> conversionRates;

    public GetAllConversionsResponse(List<ConversionRateDTO> conversionRates) {
        this.conversionRates = conversionRates;
    }
}
