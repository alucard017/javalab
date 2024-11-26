package javalab.Multithreading.ProducerConsumer;

public class Producer implements Runnable {
    Common c;
    Thread t;
    Producer(Common c, String name) {
        this.c = c;
        t = new Thread(this, name);
        t.start();
    }

    public void run() {
        int i = 0;
        while (true) {
            try {
                c.put(++i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
