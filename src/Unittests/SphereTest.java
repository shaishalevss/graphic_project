package Unittests;

import Geometries.Cylinder;
import Geometries.Sphere;
import Primitives.Coordinate;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SphereTest {

    @Test
    void emptySphere(){
        Sphere sphere0 = new Sphere();
        Point3D point0 = new Point3D();
        assertEquals(0.0, sphere0.getRadius());
        assertEquals(point0, sphere0.getCenter());
    }

    @Test
    void setSphere(){
        Sphere sphere = new Sphere(new Point3D(new Coordinate(3),new Coordinate(5), new Coordinate(7)),3);
        assertEquals(new Point3D(new Coordinate(3),new Coordinate(5), new Coordinate(7)), sphere.getCenter());
        assertEquals(3,sphere.getRadius());
    }

    @Test
    void equalSphere(){
        Sphere sphere = new Sphere(new Point3D(new Coordinate(3),new Coordinate(5), new Coordinate(7)),3);
        Sphere sphere2 = new Sphere(new Point3D(new Coordinate(7),new Coordinate(8), new Coordinate(9)),6);
        assertEquals(false, sphere.equals(sphere2));
        sphere2.setCenter(new Point3D(new Coordinate(3),new Coordinate(5), new Coordinate(7)));
        sphere2.setRadius(3);
        assertEquals(true, sphere.equals(sphere2));

    }
}