package Geometries;
import Primitives.Material;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;
import java.awt.Color;

import java.util.List;

public class Cylinder extends Geometry {
    protected double _radius;
    protected Ray _axis;
    protected double _height;
    protected Color _emission;
    protected Material _material;

    //constructors
    public Cylinder(double _radius, Ray _axis, double _height) {
        this._radius = _radius;
        this._axis = _axis;
        this._height = _height;
        this._emission = Color.black;
    }

    public Cylinder(double _radius, Ray _axis, double _height, Color emission) {
        this._radius = _radius;
        this._axis = _axis;
        this._height = _height;
        this._emission = emission;
    }

    public Cylinder(){
        this._radius = 0.0;
        this._axis = new Ray();
        this._height = 0.0;
        this._emission = Color.black;
    }

    public Cylinder(Cylinder otherCylinder){
        this._radius = otherCylinder._radius;
        this._axis = otherCylinder._axis;
        this._height = otherCylinder._height;
        this._emission = otherCylinder.getEmission();
    }

    //getters
    public double getRadius() {
        return _radius;
    }

    public Ray getAxis() {
        return new Ray(_axis);
    }

    public double getHeight() {
        return _height;
    }

    public Color getEmission() {
        return new Color(_emission.getRed(),_emission.getGreen(), _emission.getBlue());
    }

    public Material getMaterial() {
        return new Material(this._material.getKd(), this._material.getKs(), this._material.getShininess());
    }


    //setters
    public void setRadius(double radius) {
        this._radius = radius;
    }

    public void setAxis(Ray axis) {
        this._axis = axis;
    }

    public void setHeight(double height) {
        this._height = height;
    }

    public void setEmission(Color newEmission){
        this._emission = newEmission;
    }

    public void setEmission(int r, int g, int b){
        this._emission = new Color(r,g,b);
    }

    public void setMaterial(Material newMaterial) {
        this._material = newMaterial;
    }


    //edit
    public List<GeoPoint> findIntersections(Ray ray){
        return null;
    }
    public Vector getNormal(Point3D point){
        return null;
    }

    //equals method
    @Override
    public boolean equals(Object otherCylinder) {
        return (this._radius==((Cylinder)otherCylinder)._radius&&
                this._axis.equals(((Cylinder)otherCylinder)._axis)&&
                this._height==((Cylinder)otherCylinder)._height&&
                this._emission==((Cylinder)otherCylinder)._emission);
    }

    @Override
    public String toString() {
        return _radius + " " + _axis + " " + _height + " " + _emission;
    }
}
