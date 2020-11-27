package Primitives;

public class Ray {
    protected Point3D _00P;
    protected Vector _direction;

    //constructors
    public Ray(Vector _direction) {
        this._00P = new Point3D();
        this._direction = _direction;
    }

    public Ray(Point3D _originPoint, Vector _direction) {
        this._00P = _originPoint;
        this._direction = _direction;
    }

    public Ray() {
        this._00P = new Point3D();
        this._direction = new Vector();
    }

    public Ray(Ray otherRay) {
        this._00P = otherRay.get00P();
        this._direction = otherRay.getDirection();
    }

    //getters
    public Point3D get00P() {
        return new Point3D(this._00P);
    }

    public Vector getDirection() {
        return new Vector(this._direction);
    }

    //setters
    public void set00P(Point3D newPoint) {
        this._00P = newPoint;
    }

    public void setDirection(Vector _direction) {
        this._direction = _direction;
    }

    @Override
    public boolean equals(Object otherRay) {
        return this._direction.equals(((Ray)otherRay)._direction);
    }

    @Override
    public String toString() {
        return get00P() + "" + _direction;
    }
}
