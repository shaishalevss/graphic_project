package Geometries;
import Primitives.Point3D;
import Primitives.Vector;

public class Plane extends AbstractGeometry{
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
        this._q = otherPlane.get_q();
        this._n = otherPlane.get_n();
    }

    //getters
    public Point3D get_q() {
        return _q;
    }

    public void set_q(Point3D _q) {
        this._q = _q;
    }

    //setters
    public Vector get_n() {
        return _n;
    }

    public void set_n(Vector _n) {
        this._n = _n;
    }

    //equals methods override
    @Override
    public boolean equals(Object otherPlane) {
        return (this._q==((Plane)otherPlane).get_q()&&this._n==((Plane)otherPlane).get_n());
    }

}
