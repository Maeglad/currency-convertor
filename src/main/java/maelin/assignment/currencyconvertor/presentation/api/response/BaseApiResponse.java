package maelin.assignment.currencyconvertor.presentation.api.response;

public abstract class BaseApiResponse {
    public final boolean success;

    public BaseApiResponse(boolean success) {
        this.success = success;
    }
}
