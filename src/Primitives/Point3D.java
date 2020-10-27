package Primitives;

import java.util.Objects;

public class Point3D {
    protected Coordinate _x;
    protected Coordinate _y;
    protected Coordinate _z;

    public Point3D(Coordinate _x, Coordinate _y, Coordinate _z) {
        this._x = _x;
        this._y = _y;
        this._z = _z;
    }

    public Point3D() {
        Coordinate newX = new Coordinate ();
        Coordinate newY = new Coordinate ();
        Coordinate newZ = new Coordinate ();
        this._x = newX;
        this._y = newY;
        this._z = newZ;
    }

    public Point3D(Point3D otherPoint) {
        this._x = otherPoint.get_x();
        this._y = otherPoint.get_y();
        this._z = otherPoint.get_z();
    }

    public Coordinate get_x() {
        return new Coordinate(_x);
    }

    public void set_x(Coordinate _x) {
        this._x = _x;
    }

    public Coordinate get_y() {
        return new Coordinate(_y);
    }

    public void set_y(Coordinate _y) {
        this._y = _y;
    }

    public Coordinate get_z() {
        return new Coordinate(_z);
    }

    public void set_z(Coordinate _z) {
        this._z = _z;
    }

    @Override
    public boolean equals(Object otherPoint) {
        return (this._x.equals(((Point3D)otherPoint).get_x())&&this._y.equals(((Point3D)otherPoint).get_y())&&this._z.equals(((Point3D)otherPoint).get_z()));
    }

    @Override
    public String toString() {
        return "("+ _x + "," + _y + "," + _z + ")";
    }
}
