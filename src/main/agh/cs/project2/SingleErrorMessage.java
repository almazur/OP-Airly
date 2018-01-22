package agh.cs.project2;

// class for error message returned as single error, not an array (-> Error, ErrorResponse)
public class SingleErrorMessage {
    private String message;

    //setter and getter
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
