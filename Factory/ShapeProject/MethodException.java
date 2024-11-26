package javalab.Factory.ShapeProject;

public class MethodException extends Exception {
    private String msg;

    public MethodException(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "p4.MethodException: " + msg;
    }

    @Override
    public String getMessage() {
        return toString();
    }
}
