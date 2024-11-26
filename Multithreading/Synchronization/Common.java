package javalab.Multithreading.Synchronization;
public class Common {
   void print(String s) {
        System.out.print("[" + s);
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.print( "]");
    }
}
