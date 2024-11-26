package javalab.Factory.ShapeProject;

// import p2.ThreeD;

public class Sphere extends ThreeD{
    private double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    public double getVolume() {
        return (4 * Math.PI * radius * radius * radius) / 3;
    }
}
