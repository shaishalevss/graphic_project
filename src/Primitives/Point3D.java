package Primitives;

import java.util.Objects;

public class Point3D {
    private Coordinate _x;
    private Coordinate _y;
    private Coordinate _z;

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
        return _x;
    }

    public void set_x(Coordinate _x) {
        this._x = _x;
    }

    public Coordinate get_y() {
        return _y;
    }

    public void set_y(Coordinate _y) {
        this._y = _y;
    }

    public Coordinate get_z() {
        return _z;
    }

    public void set_z(Coordinate _z) {
        this._z = _z;
    }

    @Override
    public boolean equals(Object otherPoint) {
        return (this._x==((Point3D)otherPoint).get_x()&&this._y==((Point3D)otherPoint).get_y()&&this._z==((Point3D)otherPoint).get_z());
    }

    @Override
    public String toString() {
        return "This point's coordinates are: ("+ _x + "," + _y + "," + _z + ").";
    }
}
