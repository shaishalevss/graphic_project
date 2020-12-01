package Geometries;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

import java.util.ArrayList;
import java.util.List;

public class Polygon extends Geometry {
    protected List<Point3D> _points;

    //constructors
    public Polygon(List<Point3D> _points) {
        this._points = _points;
    }

    public Polygon(){
        this._points = new ArrayList<Point3D>();
    }

    public Polygon(Polygon otherPolygon){
        this._points = otherPolygon.getPoints();
    }

    //getters
    public List<Point3D> getPoints() {
        return _points;
    }

    //setters
    public void setPoints(List<Point3D> _points) {
        this._points = _points;
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
    public boolean equals(Object otherPolygon) {
        return (this._points.equals(((Polygon)otherPolygon).getPoints()));
    }

    @Override
    public String toString() {
        return getPoints().toString();
    }
}
