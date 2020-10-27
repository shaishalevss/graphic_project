package Geometries;
import Primitives.Point3D;

public class Sphere extends AbstractGeometry{
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
        this._center = otherSphere.get_center();
        this._radius = otherSphere.get_radius();
    }

    //getters
    public Point3D get_center() {
        return _center;
    }

    public double get_radius() {
        return _radius;
    }

    //setters
    public void set_center(Point3D _center) {
        this._center = _center;
    }

    public void set_radius(double _radius) {
        this._radius = _radius;
    }

    //equal method override
    @Override
    public boolean equals(Object otherSphere) {
        return (this._center==((Sphere)otherSphere).get_center()&&this._radius==((Sphere)otherSphere).get_radius());
    }
}
