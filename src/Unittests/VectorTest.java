package Unittests;

import Primitives.Coordinate;
import Primitives.Point3D;
import Primitives.Vector;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VectorTest {
    @Test
    void emptyVector(){
        Vector vec = new Vector();
        assertEquals(0.0, vec.getHead().getX().getCoordinate());
        assertEquals(0.0, vec.getHead().getY().getCoordinate());
        assertEquals(0.0, vec.getHead().getZ().getCoordinate());
    }

    @Test
    void setVector(){
        Vector vec = new Vector();
        vec.setHead(new Point3D(new Coordinate(2.0),new Coordinate(2.0),new Coordinate(2.0)));
        assertEquals(2.0, vec.getHead().getX().getCoordinate());
    }

    @Test
    void equalsMethod(){
        Vector vec1 = new Vector(new Point3D(new Coordinate(2.0),new Coordinate(2.0),new Coordinate(2.0)));
        Vector vec2 = new Vector(new Point3D(new Coordinate(4.0),new Coordinate(2.0),new Coordinate(1.0)));
        assertEquals(false, vec1.equals(vec2));
    }
}