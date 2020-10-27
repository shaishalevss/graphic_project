package Unittests;

import Geometries.Cylinder;
import Primitives.Coordinate;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CylinderTest {


    @Test
    void emptyCylinder(){
        Cylinder cylinder = new Cylinder();
        Ray emptyRay = new Ray();
        assertEquals(emptyRay, cylinder.getAxis());
        assertEquals(0.0, cylinder.getHeight());
        assertEquals(0.0, cylinder.getRadius());
    }

    @Test
    void setCylinder(){
        Ray ray = new Ray((new Vector(new Point3D(new Coordinate(1.2),new Coordinate(5.2), new Coordinate(4.7)))));
        Cylinder cylinder = new Cylinder(5,ray,9);
        System.out.println(cylinder);
        ray.setDirection(new Vector(new Point3D(new Coordinate(0),new Coordinate(42), new Coordinate(12))));
        cylinder.setAxis(ray);
        cylinder.setHeight(5);
        cylinder.setRadius(3);
        System.out.println(cylinder);
    }

    @Test
    void equalCylinder(){
        Ray ray = new Ray((new Vector(new Point3D(new Coordinate(1.2),new Coordinate(5.2), new Coordinate(4.7)))));
        Cylinder cylinder = new Cylinder(5,ray,9);
        Cylinder cylinder2 = new Cylinder(5,ray,9);
        assertEquals(true, cylinder.equals(cylinder2));
    }
}