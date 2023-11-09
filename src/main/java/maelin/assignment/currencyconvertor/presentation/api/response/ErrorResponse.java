package maelin.assignment.currencyconvertor.presentation.api.response;

public class ErrorResponse extends BaseApiResponse {

    private String message;

    public ErrorResponse(String message) {
        success = false;
        this.message = message;
    }
}
