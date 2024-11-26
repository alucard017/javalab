package javalab.FileIO;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumTwoIntegers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter two integers separated by space: ");

        String line = reader.readLine();  
        String[] numbers = line.split(" ");

        int num1 = Integer.parseInt(numbers[0]);
        int num2 = Integer.parseInt(numbers[1]);
        
        int sum = num1 + num2;
        System.out.println("The sum is: " + sum);
    }
}

