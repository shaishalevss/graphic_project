package Geometries;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

import java.util.List;

public class Sphere extends Geometry {
    protected Point3D _center;
    protected double _radius;

    //constructors
    public Sphere(Point3D _center, double _radius) {
        this._center = _center;
        this._radius = _radius;
    }

    public Sphere(){
        this._center = new Point3D();
        this._radius = 0.0;
    }

    public Sphere(Sphere otherSphere){
        this._center = otherSphere.getCenter();
        this._radius = otherSphere.getRadius();
    }

    //getters
    public Point3D getCenter() {
        return new Point3D(_center);
    }

    public double getRadius() {
        return _radius;
    }

    //setters
    public void setCenter(Point3D _center) {
        this._center = _center;
    }

    public void setRadius(double _radius) {
        this._radius = _radius;
    }

    //edit
    public List<Point3D> findIntersections(Ray ray){
        return null;
    }
    public Vector getNormal(Point3D point){
        return null;
    }

    //equal method override
    @Override
    public boolean equals(Object otherSphere) {
        return (this._center.equals(((Sphere)otherSphere).getCenter())&&this._radius==((Sphere)otherSphere).getRadius());
    }

    @Override
    public String toString() {
        return getCenter() + " " + getRadius();
    }
}
