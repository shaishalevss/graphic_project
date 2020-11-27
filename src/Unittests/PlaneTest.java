package Unittests;

import Geometries.Plane;
import Primitives.Coordinate;
import Primitives.Point3D;
import Primitives.Vector;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlaneTest {

    @Test
    void emptyPlane(){
        Plane plane = new Plane();
        assertEquals(0.0, plane.getN().getHead().getX()._coordinate());
        assertEquals(0.0, plane.getN().getHead().getY()._coordinate());
        assertEquals(0.0, plane.getN().getHead().getZ()._coordinate());
        assertEquals(0.0, plane.getQ().getX()._coordinate());
        assertEquals(0.0, plane.getQ().getY()._coordinate());
        assertEquals(0.0, plane.getQ().getZ()._coordinate());
    }

    @Test
    void setPlane(){
        Plane plane = new Plane();
        plane.setN(new Vector(new Point3D(new Coordinate(1.0),new Coordinate(2.0),new Coordinate(3.0))));
        plane.setQ(new Point3D(new Coordinate(1.0),new Coordinate(2.0),new Coordinate(3.0)));
        assertEquals(2.0,plane.getN().getHead().getY()._coordinate());
        assertEquals(3.0,plane.getQ().getZ()._coordinate());
    }

    @Test
    void equalsMethod(){
        Plane plane1 = new Plane(new Point3D(new Coordinate(1.0),new Coordinate(2.0),new Coordinate(3.0)),new Vector(new Point3D(new Coordinate(1.0),new Coordinate(2.0),new Coordinate(3.0))));
        Plane plane2 = new Plane(new Point3D(new Coordinate(1.0),new Coordinate(2.0),new Coordinate(3.0)),new Vector(new Point3D(new Coordinate(1.0),new Coordinate(2.0),new Coordinate(3.0))));
        assertEquals(true, plane1.equals(plane2));
    }
}