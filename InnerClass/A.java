package javalab.InnerClass;

public class A {
    private static int a;
    int b;
    protected int c;
    public int d;

    public static class B {
        private int w;
        int x;
        protected int y;
        public int z;

        B() {
            a = 10;
        }

        public void m1() {
            System.out.println("Inside m1 of inner class B");
        }
    }

    public void m() {
        B b = new B();
        b.w = 10;
        b.x = 11;
        b.y = 12;
        b.z = 13;

        for (int i = 0; i < 5; i++) {
            class C {
                C() {
                    System.out.println("Within local class");
                }
            }

            C c = new C();
        }
    }
}
