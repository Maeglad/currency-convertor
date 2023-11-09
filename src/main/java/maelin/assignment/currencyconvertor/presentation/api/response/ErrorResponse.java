package maelin.assignment.currencyconvertor.presentation.api.response;

public class ErrorResponse extends BaseApiResponse {

    public final String message;

    public ErrorResponse(String message) {
        super(false);
        this.message = message;
    }
}
