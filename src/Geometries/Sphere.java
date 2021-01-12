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
    protected Color _emission;

    //constructors
    public Sphere(Point3D _center, double _radius) {
        this._center = _center;
        this._radius = _radius;
        this._emission = Color.black;
    }

    public Sphere(Point3D _center, double _radius, Color emission) {
        this._center = _center;
        this._radius = _radius;
        this._emission = emission;
    }

    public Sphere() {
        this._center = new Point3D();
        this._radius = 0.0;
        this._emission = Color.black;
    }

    public Sphere(Sphere otherSphere) {
        this._center = otherSphere.getCenter();
        this._radius = otherSphere.getRadius();
        this._emission = otherSphere.getEmission();
    }

    //getters
    public Point3D getCenter() {
        return new Point3D(_center);
    }

    public double getRadius() {
        return _radius;
    }

    public Color getEmission() {
        return new Color(_emission.getRed(), _emission.getGreen(), _emission.getBlue());
    }

    //setters
    public void setCenter(Point3D _center) {
        this._center = _center;
    }

    public void setRadius(double _radius) {
        this._radius = _radius;
    }

    public void setEmission(Color newEmission) {
        this._emission = newEmission;
    }

    public void setEmission(int r, int g, int b) {
        this._emission = new Color(r, g, b);
    }

    //edit
    public List<GeoPoint> findIntersections(Ray ray) {
//        List<GeoPoint> points = new ArrayList<GeoPoint>();
//        double th = 0;
//        Vector v = ray.getDirection().normalize();                      //normalized ray
//        Point3D p0 = ray.get00P();                                      //camera
//        Vector u = _center.subtract(p0);                                //O - P0
//        double tm = v.dotProduct(u);                                    //v*u
//        double d = Math.sqrt(u.length()*u.length()-tm*tm);              //sqrt  of (|u|^2 - tm^2)
//
//        if(d > _radius){
//            return null;
//        } else if(d == _radius){
//            double t1 = tm;
//            if(t1>0){
//                Vector t1MultiplyV = v.scale(t1);                        //t*v
//                Point3D p = p0.add(t1MultiplyV);                         //P = P0 + t*v
//                points.add(new GeoPoint(this,p));
//            }
//        } else if(d < _radius){
//            th = Math.sqrt(Math.pow(_radius,2) - Math.pow(d,2));         //th = sqrt(r^2-tm^2)
//            double t1 = tm+th;
//            double t2 = tm-th;
//            if(t1 > 0){
//                Vector t1MultiplyV = v.scale(t1);                        //t*v
//                Point3D p = p0.add(t1MultiplyV);                         //P = P0 + t*v
//                points.add(new GeoPoint(this,p));
//            }
//            if(t2 > 0){
//                Vector t2MultiplyV = v.scale(t2);                        //t*v
//                Point3D p = p0.add(t2MultiplyV);                         //P = P0 + t*v
//                points.add(new GeoPoint(this,p));
//            }
//        }
//
//        if(points.size() == 0){                                          //in case there's no points in the list
//            return null;
//        }
//
//        return points;


        List<GeoPoint> points = new ArrayList<>();
        Point3D cameraOrigin = ray.get00P();
        Vector cameraVector = ray.getDirection().normalize();
        Vector vectorU = this._center.subtract(cameraOrigin);
        double tm = cameraVector.dotProduct(vectorU);
        double d = Math.sqrt((vectorU.length()*vectorU.length()) - tm*tm);
        if (d > _radius) {
            return null;
        } else if (d == _radius) {
            if (tm > 0) {
                Point3D outerPoint = cameraOrigin.add(cameraVector.scale(tm));
                points.add(new GeoPoint(this, outerPoint));
            }
        } else {
            double th = Math.sqrt(_radius*_radius - d*d);
            double t1 = tm + th;
            double t2 = tm - th;
            if (t1 > 0) {
                Point3D p1 = cameraOrigin.add(cameraVector.scale(t1));
                points.add(new GeoPoint(this, p1));
            }
            if (t2 > 0) {
                Point3D p2 = cameraOrigin.add(cameraVector.scale(t2));
                points.add(new GeoPoint(this, p2));
            }
        }
        if (points.size() == 0)
            return null;
        return points;

    }

    public Vector getNormal(Point3D point) {
        return new Vector(point.subtract(_center));
    }

    //equal method override
    @Override
    public boolean equals(Object otherSphere) {
        return (this._center.equals(((Sphere) otherSphere)._center) &&
                this._radius == ((Sphere) otherSphere)._radius &&
                this._emission == ((Sphere) otherSphere)._emission);
    }

    @Override
    public String toString() {
        return _center + " " + _radius + " " + _emission;
    }
}
