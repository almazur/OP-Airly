package agh.cs.project2;

// class for own exception
public class HttpRequestException extends Exception{
    HttpRequestException(String message) {
        super(message);
    }
}
