package maelin.assignment.currencyconvertor.presentation.api.response;

/**
 * Base response class that should contain any shared features between responses.<br/>
 * All api responses should extend this class.
 */
public abstract class BaseApiResponse {
    public final boolean success;

    public BaseApiResponse(boolean success) {
        this.success = success;
    }
}
