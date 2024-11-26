package javalab.Factory.ShapeProject;

// import p2.TwoD;

public class Rectangle extends TwoD {
    private double width, height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }

}
