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
        this._points = otherPolygon.get_points();
    }

    //getters
    public List<Point3D> get_points() {
        return _points;
    }

    //setters
    public void set_points(List<Point3D> _points) {
        this._points = _points;
    }

    //equal method override
    @Override
    public boolean equals(Object otherPolygon) {
        return (this._points.equals(((Polygon)otherPolygon).get_points()));
    }
}
