package javalab.Factory.ShapeProject;

import java.lang.reflect.Method;

// import p3.*;
// import p4.MethodException;

public interface Shape {
    double getArea() throws MethodException;
    double getVolume() throws MethodException;

    public static Shape getShape(String type, double... params) {
        switch(type) {
            case "Circle": return new Circle(params[0]);
            case "Sphere": return new Sphere(params[0]);
            case "Rectangle": return new Rectangle(params[0], params[1]);
            default: return null;
        }
    } 
}