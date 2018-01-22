package agh.cs.project2;

// class for errors returned as http response
public class ErrorResponse {
    private Error[] errors;

    //getter and setter
    public Error[] getErrors() {
        return errors;
    }
    public void setErrors(Error[] errors) {
        this.errors = errors;
    }
}
