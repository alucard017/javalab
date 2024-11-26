package javalab.Factory.ShapeProject;

// import p1.Shape;
// import p4.MethodException;

public class Main {
    public static void main(String[] args) {
        Shape circle = Shape.getShape("Circle", 5.0);
        Shape sphere = Shape.getShape("Sphere", 5.0);
        Shape rect = Shape.getShape("Rectangle", 3.0, 5.0);

        try {
            System.out.println(circle.getArea());
            System.out.println(rect.getArea());
            System.out.println(sphere.getVolume());
        } catch (MethodException ex) {
            System.out.println("Invalid call to method: " + ex.getMessage());
        }
    }
}
