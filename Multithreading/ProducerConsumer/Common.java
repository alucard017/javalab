package javalab.Multithreading.ProducerConsumer;

public class Common {
    int container;
    boolean daalo = false;

    synchronized public void put(int n) {
        while (daalo) {
            try {
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        container = n;
        System.out.println("Daal diya: " + n);
        daalo = true;
        notify();
    }

    synchronized public int get() {
        while (!daalo) {
            try {
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("Nikal diya: " + container);
        daalo = false;
        notify();
        return container;

    }
}
