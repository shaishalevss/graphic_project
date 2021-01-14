package Geometries;

import Primitives.Material;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Triangle extends Geometry {
    protected Point3D _p1;
    protected Point3D _p2;
    protected Point3D _p3;
    protected Color _emission;
    protected Material _material;

    //constructors
    public Triangle(Point3D _p1, Point3D _p2, Point3D _p3) {
        this._p1 = _p1;
        this._p2 = _p2;
        this._p3 = _p3;
        this._emission = Color.black;
        this._material = new Material();
    }

    public Triangle(Point3D _p1, Point3D _p2, Point3D _p3, Color emission) {
        this._p1 = _p1;
        this._p2 = _p2;
        this._p3 = _p3;
        this._emission = emission;
        this._material = new Material();
    }

    public Triangle(Point3D _p1, Point3D _p2, Point3D _p3, Color emission, Material material) {
        this._p1 = _p1;
        this._p2 = _p2;
        this._p3 = _p3;
        this._emission = emission;
        this._material = material;
    }

    public Triangle() {
        this._p1 = new Point3D();
        this._p2 = new Point3D();
        this._p3 = new Point3D();
        this._emission = Color.black;
        this._material = new Material();
    }

    public Triangle(Triangle otherTriangle) {
        this._p1 = otherTriangle.getP1();
        this._p2 = otherTriangle.getP2();
        this._p3 = otherTriangle.getP3();
        this._emission = otherTriangle.getEmission();
        this._material = otherTriangle.getMaterial();
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

    public Color getEmission() {
        return new Color(_emission.getRed(), _emission.getGreen(), _emission.getBlue());
    }

    public Material getMaterial() {
        return new Material(this._material.getKd(), this._material.getKs(), this._material.getShininess());
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

    public void setEmission(Color newEmission) {
        this._emission = newEmission;
    }

    public void setEmission(int r, int g, int b) {
        this._emission = new Color(r, g, b);
    }

    public void setMaterial(Material newMaterial) {
        this._material = newMaterial;
    }


    //edit
    public List<GeoPoint> findIntersections(Ray ray) {
        List<GeoPoint> pointList = new ArrayList<>();                            //Declaring list and camera ray
        Vector cameraVector = ray.getDirection().normalize();                    //variables.
        Point3D cameraOrigin = ray.get00P();
        if (getNormal(new Point3D()).dotProduct(cameraVector) == 0)                 //If triangle normal and camera
            return null;                                                         //vector are perpendicular return null.

        //Declaring the three vectors from the triangle vertices to the camera.
        Vector v1 = _p1.subtract(cameraOrigin);
        Vector v2 = _p2.subtract(cameraOrigin);
        Vector v3 = _p3.subtract(cameraOrigin);
        Vector n1 = v1.crossProduct(v2).normalize();
        Vector n2 = v2.crossProduct(v3).normalize();
        Vector n3 = v3.crossProduct(v1).normalize();

        //If ray hits outside triangle return null.
        if (!(cameraVector.dotProduct(n1) > 0
                && cameraVector.dotProduct(n2) > 0
                && cameraVector.dotProduct(n3) > 0
                || cameraVector.dotProduct(n1) < 0
                && cameraVector.dotProduct(n2) < 0
                && cameraVector.dotProduct(n3) < 0))
            return null;


        //Get the distance between the camera and the triangle.
        double t = ((getNormal(new Point3D()).dotProduct(_p1.subtract(cameraOrigin)))
                / getNormal(new Point3D()).dotProduct(cameraVector));

        if (t <= 0)                                                               //if vector is facing away return null.
            return null;

        //Return the intersection point of the ray with the triangle.
        pointList.add(new GeoPoint(this, cameraOrigin.add(cameraVector.scale(t))));
        return pointList;
    }

    public Vector getNormal(Point3D point) {
        Vector a = new Vector(_p2.subtract(_p1));
        Vector b = new Vector(_p3.subtract(_p1));
        return new Vector((a.crossProduct(b)).normalize());
    }

    //equals override
    @Override
    public boolean equals(Object otherTriangle) {
        return (this._p1.equals(((Triangle) otherTriangle)._p1) &&
                this._p2.equals(((Triangle) otherTriangle)._p2) &&
                this._p3.equals(((Triangle) otherTriangle)._p3) &&
                this._emission == ((Triangle) otherTriangle)._emission);
    }

    @Override
    public String toString() {
        return _p1 + " " + _p2 + " " + _p3 + " " + _emission;
    }
}
