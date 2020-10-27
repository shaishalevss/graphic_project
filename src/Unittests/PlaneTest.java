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
        assertEquals(0.0, plane.getN().getHead().getX().getCoordinate());
        assertEquals(0.0, plane.getN().getHead().getY().getCoordinate());
        assertEquals(0.0, plane.getN().getHead().getZ().getCoordinate());
        assertEquals(0.0, plane.getQ().getX().getCoordinate());
        assertEquals(0.0, plane.getQ().getY().getCoordinate());
        assertEquals(0.0, plane.getQ().getZ().getCoordinate());
    }

    @Test
    void setPlane(){
        Plane plane = new Plane();
        plane.setN(new Vector(new Point3D(new Coordinate(1.0),new Coordinate(2.0),new Coordinate(3.0))));
        plane.setQ(new Point3D(new Coordinate(1.0),new Coordinate(2.0),new Coordinate(3.0)));
        assertEquals(2.0,plane.getN().getHead().getY().getCoordinate());
        assertEquals(3.0,plane.getQ().getZ().getCoordinate());
    }

    @Test
    void equalsMethod(){
        Plane plane1 = new Plane(new Point3D(new Coordinate(1.0),new Coordinate(2.0),new Coordinate(3.0)),new Vector(new Point3D(new Coordinate(1.0),new Coordinate(2.0),new Coordinate(3.0))));
        Plane plane2 = new Plane(new Point3D(new Coordinate(1.0),new Coordinate(2.0),new Coordinate(3.0)),new Vector(new Point3D(new Coordinate(1.0),new Coordinate(2.0),new Coordinate(3.0))));
        assertEquals(true, plane1.equals(plane2));
    }
}