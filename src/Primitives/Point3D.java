package Primitives;

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
        this._x = otherPoint.getX();
        this._y = otherPoint.getY();
        this._z = otherPoint.getZ();
    }


    //getters
    public Coordinate getX() {
        return new Coordinate(_x);
    }

    public Coordinate getY() {
        return new Coordinate(_y);
    }

    public Coordinate getZ() {
        return new Coordinate(_z);
    }

    //setters
    public void setX(Coordinate _x) {
        this._x = _x;
    }

    public void setY(Coordinate _y) {
        this._y = _y;
    }

    public void setZ(Coordinate _z) {
        this._z = _z;
    }

    @Override
    public boolean equals(Object otherPoint) {
        return (this._x.equals(((Point3D)otherPoint).getX())&&this._y.equals(((Point3D)otherPoint).getY())&&this._z.equals(((Point3D)otherPoint).getZ()));
    }

    @Override
    public String toString() {
        return "("+ _x + "," + _y + "," + _z + ")";
    }
}
