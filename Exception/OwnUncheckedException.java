package javalab.Exception;
public class OwnUncheckedException extends RuntimeException {
    String msg;

    public OwnUncheckedException(String msg) {
        this.msg = msg;
    }

    public String getMessage() {
        return "OwnUncheckedException: " + msg;
    }

    public String toString() {
        return getMessage();
    }
}
