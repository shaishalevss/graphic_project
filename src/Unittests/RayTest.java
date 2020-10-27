package Unittests;

import Geometries.Cylinder;
import Primitives.Coordinate;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RayTest {


    @Test
    void emptyRay(){
        Point3D point0 = new Point3D();
        Ray emptyRay = new Ray();
        assertEquals(point0, emptyRay.getDirection().getHead());
        assertEquals(point0, emptyRay.get00P());
    }

    @Test
    void setRay(){
        Ray ray = new Ray((new Vector(new Point3D(new Coordinate(8),new Coordinate(6), new Coordinate(7)))));
        System.out.println(ray);
        ray.setDirection(new Vector(new Point3D(new Coordinate(7),new Coordinate(8), new Coordinate(9))));
        System.out.println(ray);
    }

    @Test
    void equalRay(){
        Ray ray = new Ray((new Vector(new Point3D(new Coordinate(8),new Coordinate(6), new Coordinate(7)))));
        Ray ray2 = new Ray((new Vector(new Point3D(new Coordinate(7),new Coordinate(8), new Coordinate(9)))));
        assertEquals(false, ray.equals(ray2));
        ray.setDirection(new Vector(new Point3D(new Coordinate(7),new Coordinate(8), new Coordinate(9))));
        assertEquals(true, ray.equals(ray2));
    }



}