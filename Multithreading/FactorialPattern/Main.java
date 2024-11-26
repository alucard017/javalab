package javalab.Multithreading.FactorialPattern;
import java.math.BigInteger;

public class Main {

    private static class Multiplier implements Runnable {
        private int start, end;
        private Thread t;
        private BigInteger lfact;

        Multiplier(int start, int end) {
            this.start = start;
            this.end = end;
            t = new Thread(this);
            t.start();
        }

        public void run() {
            lfact = new BigInteger("1");
            for(int i=start; i <= end; i++)
                lfact = lfact.multiply(new BigInteger(Integer.toString(i)));
        }

        public void join() throws InterruptedException {
            t.join();
        }

        public BigInteger getValue() {
            return lfact;
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int tcount = 5;
        int perthread = n / tcount; 

        BigInteger fact = new BigInteger("1");
        Multiplier helpers[] = new Multiplier[tcount];
        for(int i=0; i < tcount; i++) {
            helpers[i] = new Multiplier(i * perthread + 1, (i+1) * perthread);
  
        }
        try {
        for(int i=0; i < tcount; i++) {
            helpers[i].join();
            fact = fact.multiply(helpers[i].getValue());
        }
    } catch(InterruptedException ex) {}
        System.out.println(fact.toString());
    }
}
