package Primitives;

import java.awt.*;
import java.util.Objects;

public class Vector {
    protected Point3D _head;

    public Vector(Point3D head) {
        this._head = head;
    }

    public Vector() {
        this._head = new Point3D();
    }

    public Vector(Vector otherVector) {
        this._head = otherVector.get_head();
    }

    public Point3D get_head() {
        return new Point3D(this._head);
    }

    public void set_head(Point3D _head) {
        this._head = _head;
    }

    @Override
    public boolean equals(Object otherVector) {
        return this._head==((Vector)otherVector).get_head();
    }

    @Override
    public String toString() {
        return ""+ this.get_head();
    }
}
