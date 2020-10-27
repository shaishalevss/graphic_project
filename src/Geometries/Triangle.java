package Geometries;
import Primitives.Point3D;

public class Triangle extends Geometry {
    protected Point3D _p1;
    protected Point3D _p2;
    protected Point3D _p3;

    //constructors
    public Triangle(Point3D _p1, Point3D _p2, Point3D _p3) {
        this._p1 = _p1;
        this._p2 = _p2;
        this._p3 = _p3;
    }

    public Triangle(){
        this._p1 = new Point3D();
        this._p2 = new Point3D();
        this._p3 = new Point3D();
    }

    public Triangle(Triangle otherTriangle){
        this._p1 = otherTriangle.getP1();
        this._p2 = otherTriangle.getP2();
        this._p3 = otherTriangle.getP3();
    }


    //getters
    public Point3D getP1() {
        return new Point3D(_p1);
    }

    public Point3D getP2() {
        return new Point3D(_p2);
    }

    public Point3D getP3() {
        return new Point3D(_p3);
    }

    //setters
    public void setP1(Point3D _p1) {
        this._p1 = _p1;
    }

    public void setP2(Point3D _p2) {
        this._p2 = _p2;
    }

    public void setP3(Point3D _p3) {
        this._p3 = _p3;
    }


    //equals override
    @Override
    public boolean equals(Object otherTriangle) {
        return (this._p1.equals(((Triangle)otherTriangle).getP1())&&this._p2.equals(((Triangle)otherTriangle).getP2())&&this._p3.equals(((Triangle)otherTriangle).getP3()));
    }

    @Override
    public String toString() {
        return getP1() + " " + getP2() + " " + getP3();
    }
}
