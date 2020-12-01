package Geometries;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

import java.awt.*;
import java.util.List;

public class Plane extends Geometry {
    protected Point3D _q;
    protected Vector _n;
    protected Point3D _b;
    protected Point3D _c;

    //constructors
    public Plane(Point3D _q, Vector _n) {
        this._q = _q;
        this._n = _n;
    }

    public Plane(Point3D _q, Point3D _b, Point3D _c) {
        this._q = _q;
        this._b = _b;
        this._c = _c;
    }

    public Plane(){
        this._q = new Point3D();
        this._n = new Vector();
    }

    public Plane(Plane otherPlane){
        this._q = otherPlane.getQ();
        if(!otherPlane._n.equals(new Vector()))
            this._n = otherPlane.getN();
        else {
            this._b = new Point3D(otherPlane._b);
            this._c = new Point3D(otherPlane._c);
        }
    }

    //getters
    public Point3D getQ() {
        return new Point3D(_q);
    }

    public Vector getN() {
        return new Vector(_n);
    }

    //setters
    public void setQ(Point3D _q) {
        this._q = _q;
    }

    public void setN(Vector _n) {
        this._n = _n;
    }

    //edit
    public List<Point3D> findIntersections(Ray ray){
        return null;
    }

    public Vector getNormal(Point3D point){
        Vector a = new Vector(_b.subtract(_q));
        Vector b = new Vector(_c.subtract(_q));
        return new Vector (((a.crossProduct(b)).normalize()));
    }

    //equals methods override
    @Override
    public boolean equals(Object otherPlane) {
        return (this._q.equals(((Plane)otherPlane)._q)&&this._n.equals(((Plane)otherPlane)._n));
    }

    @Override
    public String toString() {
        return _q + " " + _n;
    }
}
