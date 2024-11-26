package javalab.Exception;
import java.io.FileNotFoundException;

public class Main2 {
    public static void m() {
        try {
            throw new ArithmeticException("Throwing own exception");
        } catch(ArithmeticException e) {
            e.initCause(new FileNotFoundException("Value is not found"));
            throw e;
        } 
    }

    public static void main(String[] args) {
        try {
            int a = 1;
            int b = 12 / a;
            throw new IllegalArgumentException("Wrong argument");
        } catch(ArithmeticException | IllegalArgumentException e) {
            System.out.println("Some exception");
        }
    }
}
