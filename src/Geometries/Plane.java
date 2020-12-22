package Geometries;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Plane extends Geometry {
    protected Point3D _q;
    protected Vector _n;
    protected Point3D _b;
    protected Point3D _c;
    protected Color _emission;

    //constructors
    public Plane(Point3D _q, Vector _n) {
        this._q = _q;
        this._n = _n;
        this._emission = Color.black;
    }

    public Plane(Point3D _q, Vector _n, Color emission) {
        this._q = _q;
        this._n = _n;
        this._emission = emission;
    }

    public Plane(Point3D _q, Point3D _b, Point3D _c) {
        this._q = _q;
        this._b = _b;
        this._c = _c;
        this._n = getNormal(new Point3D());
        this._emission = Color.black;
    }

    public Plane(Point3D _q, Point3D _b, Point3D _c, Color emission) {
        this._q = _q;
        this._b = _b;
        this._c = _c;
        this._n = getNormal(new Point3D());
        this._emission = emission;
    }

    public Plane(){
        this._q = new Point3D();
        this._n = new Vector();
        this._emission = Color.black;
    }

    public Plane(Plane otherPlane){
        this._q = otherPlane.getQ();
        if(!otherPlane._n.equals(new Vector()))
            this._n = otherPlane.getN();
        else {
            this._b = new Point3D(otherPlane._b);
            this._c = new Point3D(otherPlane._c);
        }
        this._emission = otherPlane.getEmission();
    }

    //getters
    public Point3D getQ() {
        return new Point3D(_q);
    }

    public Vector getN() {
        return new Vector(_n);
    }

    public Color getEmission() {
        return new Color(_emission.getRed(),_emission.getGreen(), _emission.getBlue());
    }

    //setters
    public void setQ(Point3D _q) {
        this._q = _q;
    }

    public void setN(Vector _n) {
        this._n = _n;
    }

    public void setEmission(Color newEmission){
        this._emission = newEmission;
    }

    public void setEmission(int r, int g, int b){
        this._emission = new Color(r,g,b);
    }

    //edit
    public List<GeoPoint> findIntersections(Ray ray){
        List<GeoPoint> pointList = new ArrayList<GeoPoint>();                //Declaring point list and camera ray
        Vector v = ray.getDirection().normalize();                         //variables.
        Point3D p0 = ray.get00P();

        if(this._q.equals(ray.get00P()))                                   //If the camera is in the plane return null.
            return null;

        if(getNormal(new Point3D()).dotProduct(v) == 0)                    //If triangle normal and camera
            return null;                                                   //vector are perpendicular return null.

        //Calculate distance from camera to plane.
        double t = (getNormal(new Point3D()).dotProduct((_q.subtract(p0))))/(getNormal(new Point3D()).dotProduct(v));

        if(t <= 0)                                                         //if vector is facing away return null.
            return null;

        //Return intersection point of the ray with the plane.
        pointList.add(new GeoPoint(this,p0.add(v.scale(t))));
        return pointList;
    }

    public Vector getNormal(Point3D point){
        if(_n!=null)
            return getN();
        Vector a = new Vector(_b.subtract(_q));
        Vector b = new Vector(_c.subtract(_q));
        return new Vector ((a.crossProduct(b)).normalize());
    }

    //equals methods override
    @Override
    public boolean equals(Object otherPlane) {
        return (this._q.equals(((Plane)otherPlane)._q)&&
                this._n.equals(((Plane)otherPlane)._n)&&
                this._emission.equals(((Plane)otherPlane)._emission));
    }

    @Override
    public String toString() {
        return _q + " " + _n + " " + _emission;
    }
}