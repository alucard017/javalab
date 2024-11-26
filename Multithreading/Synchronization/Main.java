package javalab.Multithreading.Synchronization;

public class Main {
    public static void main(String[] args) {
        Common c = new Common();
        NewThread t1 = new NewThread(c, "Hello1", "Thread1");
        NewThread t2 = new NewThread(c, "Hello2", "Thread2");
        NewThread t3 = new NewThread(c, "Hello3", "Thread3");

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (Exception e) {
            e.printStackTrace();

        }
        
        // for(int i=1;i<=10000000;i++){
        //     System.out.println("Hi nadarcod");
        // }
    }
}