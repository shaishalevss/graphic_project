package Unittests;

import Geometries.Triangle;
import Primitives.Coordinate;
import Primitives.Point3D;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    @Test
    void emptyTriangle(){
        Triangle triangle0 = new Triangle();
        Point3D point0 = new Point3D();
        assertEquals(point0, triangle0.getP1());
        assertEquals(point0, triangle0.getP2());
        assertEquals(point0, triangle0.getP3());
    }

    @Test
    void setTriangle(){
        Triangle triangle = new Triangle(new Point3D(new Coordinate(1),new Coordinate(1), new Coordinate(1)),
                new Point3D(new Coordinate(2),new Coordinate(2), new Coordinate(2)),
                new Point3D(new Coordinate(3),new Coordinate(3), new Coordinate(3)));
        Triangle triangle0 = new Triangle();
        assertEquals(false, triangle.equals(triangle0));
        triangle.setP1(new Point3D(new Coordinate(0),new Coordinate(0), new Coordinate(0)));
        triangle.setP2(new Point3D(new Coordinate(0),new Coordinate(0), new Coordinate(0)));
        triangle.setP3(new Point3D(new Coordinate(0),new Coordinate(0), new Coordinate(0)));
        assertEquals(true, triangle.equals(triangle0));
    }
}