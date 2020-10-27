package Primitives;

public class Ray {
    protected Point3D _00P;
    protected Vector _direction;

    public Ray(Vector _direction) {
        this._00P = new Point3D();
        this._direction = _direction;
    }

    public Ray() {
        this._00P = new Point3D();
        this._direction = new Vector();
    }

    public Ray(Ray otherRay) {
        this._direction = otherRay.getDirection();
    }

    public Point3D get00P() {
        return new Point3D();
    }

    public void set00P(Point3D newPoint) {
        this._00P = newPoint;
    }

    public Vector getDirection() {
        return new Vector(this._direction);
    }

    public void setDirection(Vector _direction) {
        this._direction = _direction;
    }

    @Override
    public boolean equals(Object otherRay) {
        return this._direction.equals(((Ray)otherRay).getDirection());
    }
}
