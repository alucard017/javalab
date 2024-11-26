package javalab.Singleton;
public class Singleton {
    private Singleton() {
        a = 10;
    }

    private static Singleton object;
    public int a;

    public static Singleton getSingleton() {
        if (object == null)
            object = new Singleton();

        return object;
    }
}
