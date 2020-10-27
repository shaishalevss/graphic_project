package Primitives;

public class Vector {
    protected Point3D _head;

    //constructors
    public Vector(Point3D head) {
        this._head = head;
    }

    public Vector() {
        this._head = new Point3D();
    }

    public Vector(Vector otherVector) {
        this._head = otherVector.getHead();
    }

    //getters
    public Point3D getHead() {
        return new Point3D(this._head);
    }

    //setters
    public void setHead(Point3D _head) {
        this._head = _head;
    }

    //equal method override
    @Override
    public boolean equals(Object otherVector) {
        return this._head.equals(((Vector)otherVector).getHead());
    }

    @Override
    public String toString() {
        return ""+ this.getHead();
    }
}
