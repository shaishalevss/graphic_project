package Geometries;
import Primitives.Point3D;

public class Triangle extends AbstractGeometry{
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
        this._p1 = otherTriangle.get_p1();
        this._p2 = otherTriangle.get_p2();
        this._p3 = otherTriangle.get_p3();
    }


    //getters
    public Point3D get_p1() {
        return _p1;
    }

    public Point3D get_p2() {
        return _p2;
    }

    public Point3D get_p3() {
        return _p3;
    }

    //setters
    public void set_p1(Point3D _p1) {
        this._p1 = _p1;
    }

    public void set_p2(Point3D _p2) {
        this._p2 = _p2;
    }

    public void set_p3(Point3D _p3) {
        this._p3 = _p3;
    }


    //equals override
    @Override
    public boolean equals(Object otherTriangle) {
        return (this._p1==((Triangle)otherTriangle).get_p1()&&this._p2==((Triangle)otherTriangle).get_p2()&&this._p3==((Triangle)otherTriangle).get_p3());
    }


}
