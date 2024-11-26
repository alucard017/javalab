package javalab.Multithreading.ProducerConsumer;

public class Consumer implements Runnable {
    Common c;
    Thread t;
    Consumer(Common c, String name) {
        this.c = c;
        t = new Thread(this, name);
        t.start();
    }

    public void run() {
        while (true) {
            c.get();
        }
    }
}