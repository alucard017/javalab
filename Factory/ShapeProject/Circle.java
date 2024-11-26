package javalab.Factory.ShapeProject;

// import p2.TwoD;

public class Circle extends TwoD {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }
    
    public double getArea() {
        return Math.PI * radius * radius;
    }
}
