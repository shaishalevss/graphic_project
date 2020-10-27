package Geometries;
import Primitives.Ray;

public class Cylinder extends AbstractGeometry{
    protected double _radius;
    protected Ray _axis;
    protected double _height;

    //constructors
    public Cylinder(double _radius, Ray _axis, double _height) {
        this._radius = _radius;
        this._axis = _axis;
        this._height = _height;
    }

    public Cylinder(){
        this._radius = 0.0;
        this._axis = new Ray();
        this._height = 0.0;
    }

    public Cylinder(Cylinder otherCylinder){
        this._radius = otherCylinder._radius;
        this._axis = otherCylinder._axis;
        this._height = otherCylinder._height;
    }

    //getters
    public double getRadius() {
        return _radius;
    }

    public Ray getAxis() {
        return new Ray(_axis);
    }

    public double getHeight() {
        return _height;
    }

    //setters
    public void setRadius(double _radius) {
        this._radius = _radius;
    }

    public void setAxis(Ray _axis) {
        this._axis = _axis;
    }

    public void setHeight(double _height) {
        this._height = _height;
    }

    //equals methods
    @Override
    public boolean equals(Object otherCylinder) {
        return (this._radius==((Cylinder)otherCylinder).getRadius()&&this._axis.equals(((Cylinder)otherCylinder).getAxis())&&this._height==((Cylinder)otherCylinder).getHeight());
    }

    @Override
    public String toString() {
        return getRadius() + " " + getAxis() + " " + getHeight();
    }
}
