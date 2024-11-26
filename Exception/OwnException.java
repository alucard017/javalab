package javalab.Exception;
public class OwnException extends Exception {
    private String message;

    public OwnException(String msg) {
        this.message = msg;
    }
    
    public String getMessage() {
        return toString();
    }

    public String toString() {
        return "OwnException: " + message;
    }
}
