package Geometries;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

import java.util.List;

public class Plane extends Geometry {
    protected Point3D _q;
    protected Vector _n;

    //constructors
    public Plane(Point3D _q, Vector _n) {
        this._q = _q;
        this._n = _n;
    }

    public Plane(){
        this._q = new Point3D();
        this._n = new Vector();
    }

    public Plane(Plane otherPlane){
        this._q = otherPlane.getQ();
        this._n = otherPlane.getN();
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

        return null;
    }

    //equals methods override
    @Override
    public boolean equals(Object otherPlane) {
        return (this._q.equals(((Plane)otherPlane).getQ())&&this._n.equals(((Plane)otherPlane).getN()));
    }

    @Override
    public String toString() {
        return getQ() + " " + getN();
    }
}
