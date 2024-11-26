package javalab.Factory.ShapeProject;

// import p1.Shape;
// import p4.MethodException;

public abstract class TwoD implements Shape {
    public double getVolume() throws MethodException {
        throw new MethodException("getVolume is not available for two-dimensional shapes");
    }
}
