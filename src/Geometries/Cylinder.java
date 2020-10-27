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

    //getters and setters
    public double get_radius() {
        return _radius;
    }

    public void set_radius(double _radius) {
        this._radius = _radius;
    }

    public Ray get_axis() {
        return new Ray(_axis);
    }

    public void set_axis(Ray _axis) {
        this._axis = _axis;
    }

    public double get_height() {
        return _height;
    }

    public void set_height(double _height) {
        this._height = _height;
    }

    //equals methods
    @Override
    public boolean equals(Object otherCylinder) {
        return (this._radius==((Cylinder)otherCylinder).get_radius()&&this._axis.equals(((Cylinder)otherCylinder).get_axis())&&this._height==((Cylinder)otherCylinder).get_height());
    }
}
