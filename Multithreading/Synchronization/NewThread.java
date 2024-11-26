package javalab.Multithreading.Synchronization;
public class NewThread implements Runnable {
    Common ob11;
    String msg;
    Thread t;

    NewThread(Common ob, String msg, String thr) {
        ob11 = ob;
        this.msg = msg;
        t = new Thread(this, thr);
        t.start();
    }

    public void join() {
        try {
            t.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        synchronized (ob11) {
            ob11.print(msg);
        }
    }
}
