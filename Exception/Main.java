package javalab.Exception;
import java.io.FileReader;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("Within outer try");
            try {
        //    int a = 0;
        //    int b = 15/a;
        //    FileReader file = new FileReader("text.txt");
        //    System.out.println("This will not be printed");
                throw new ArithmeticException("Wrong arithmetic operation");
            } catch(IOException ex) {
                System.out.println("Arithmetic exception caught");
            } 
            System.out.println("After first try block");
        } catch(ArithmeticException ex) {
            System.out.println("Exception caught");
        }
    }
}
