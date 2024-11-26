package javalab.Factory.ShapeProject;

// import p1.Shape;
// import p4.MethodException;

public abstract class ThreeD implements Shape {
    public double getArea() throws MethodException {
        throw new MethodException("getArea is not available for three-dimensional shapes");
    }

}
