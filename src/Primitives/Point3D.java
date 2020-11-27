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

    public Point3D(double newX, double newY, double newZ) {
        this._x = new Coordinate(newX);
        this._y = new Coordinate(newY);
        this._z = new Coordinate(newZ);
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
        this._x = new Coordinate(otherPoint._x);
        this._y = new Coordinate(otherPoint._y);
        this._z = new Coordinate(otherPoint._z);
    }

    public Point3D add(Vector v) {
        Coordinate newX = new Coordinate(this._x._coordinate+v._head._x._coordinate);  //Add the coordinates of the other vector's
        Coordinate newY = new Coordinate(this._y._coordinate+v._head._y._coordinate);  //head to this point's and create a new point
        Coordinate newZ = new Coordinate(this._z._coordinate+v._head._z._coordinate);  //from the sum.
        return new Point3D(newX,newY,newZ);
    }

    public Vector subtract(Point3D other){
        if(this.equals(other)){
            throw new IllegalArgumentException("Cannot subtract point from itself");
        }
        else
            {
            Coordinate newX = new Coordinate(this._x._coordinate - other._x._coordinate);  //Subtract other point's coordinates from
            Coordinate newY = new Coordinate(this._y._coordinate - other._y._coordinate);  //this one's and create a new vector
            Coordinate newZ = new Coordinate(this._z._coordinate - other._z._coordinate);  //from the product coordinates.
            return new Vector(new Point3D(newX, newY, newZ));
        }
    }

    public double distance(Point3D other) {
        return Math.sqrt(Math.pow(this._x._coordinate+other._x._coordinate,2)+             //Calculate the distance between 2 points
                         Math.pow(this._y._coordinate+other._y._coordinate,2)+             //by combining the power of 2 of the sum of their
                         Math.pow(this._z._coordinate+other._z._coordinate,2));            //coordinates and then squaring it.
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
        return (this._x.equals(((Point3D)otherPoint)._x)&&this._y.equals(((Point3D)otherPoint)._y)&&this._z.equals(((Point3D)otherPoint)._z));
    }

    @Override
    public String toString() {
        return "("+ _x + "," + _y + "," + _z + ")";
    }
}
