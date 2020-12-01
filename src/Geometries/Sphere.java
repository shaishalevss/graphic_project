package Geometries;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

import java.awt.*;
import java.util.ArrayList;
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
        List<Point3D> points = new ArrayList<Point3D>();
        double th = 0;
        Vector v = ray.getDirection().normalize();                      //normalized ray
        Point3D p0 = ray.get00P();                                      //camera
        Vector u = _center.subtract(p0);                                //O - P0
        double tm = v.dotProduct(u);                                    //v*u
        double d = Math.sqrt(u.length()*u.length()-tm*tm);              //sqrt  of (|u|^2 - tm^2)

        if(d > _radius){
            return null;
        } else if(d == _radius){
            double t1 = tm;
            if(t1>0){
                Vector t1MultiplyV = v.scale(t1);                        //t*v
                Point3D p = p0.add(t1MultiplyV);                         //P = P0 + t*v
                points.add(p);
            }
        } else if(d < _radius){
            th = Math.sqrt(Math.pow(_radius,2) - Math.pow(d,2));         //th = sqrt(r^2-tm^2)
            double t1 = tm+th;
            double t2 = tm-th;
            if(t1 > 0){
                Vector t1MultiplyV = v.scale(t1);                        //t*v
                Point3D p = p0.add(t1MultiplyV);                         //P = P0 + t*v
                points.add(p);
            }
            if(t2 > 0){
                Vector t2MultiplyV = v.scale(t2);                        //t*v
                Point3D p = p0.add(t2MultiplyV);                         //P = P0 + t*v
                points.add(p);
            }
        }

        if(points.size() == 0){                                          //in case there's no points in the list
            return null;
        }

        return points;
    }

    public Vector getNormal(Point3D point){
        return new Vector(point.subtract(_center));
    }

    //equal method override
    @Override
    public boolean equals(Object otherSphere) {
        return (this._center.equals(((Sphere)otherSphere)._center)&&this._radius==((Sphere)otherSphere)._radius);
    }

    @Override
    public String toString() {
        return _center + " " + _radius;
    }
}
