package Primitives;

import java.util.Objects;

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
        this._direction = otherRay.get_direction();
    }

    public Point3D get_00P() {
        return new Point3D();
    }

    public void set_00P(Point3D newPoint) {
        this._00P = newPoint;
    }

    public Vector get_direction() {
        return new Vector(this._direction);
    }

    public void set_direction(Vector _direction) {
        this._direction = _direction;
    }

    @Override
    public boolean equals(Object otherRay) {
        return this._direction.equals(((Ray)otherRay).get_direction());
    }
}
