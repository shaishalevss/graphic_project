package Geometries;
import Primitives.Point3D;
import java.util.List;

public class Polygon extends AbstractGeometry{
    protected List<Point3D> _points;

    //constructors
    public Polygon(List<Point3D> _points) {
        this._points = _points;
    }

    public Polygon(){
        this._points = null;
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

    //equal method override
    @Override
    public boolean equals(Object otherPolygon) {
        return (this._points.equals(((Polygon)otherPolygon).getPoints()));
    }
}
