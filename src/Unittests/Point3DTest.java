package Unittests;

import Primitives.Coordinate;
import Primitives.Point3D;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Point3DTest {

    @Test
    void emptyPoint3D(){
        Point3D point = new Point3D();
        assertEquals(0.0, point.getX()._coordinate());
        assertEquals(0.0, point.getY()._coordinate());
        assertEquals(0.0, point.getZ()._coordinate());
    }

    @Test
    void setPoint3D(){
        Point3D point = new Point3D();
        point.setX(new Coordinate(2.0));
        point.setY(new Coordinate(5.0));
        point.setZ(new Coordinate(3.0));
        assertEquals(2.0,point.getX()._coordinate());
        assertEquals(5.0,point.getY()._coordinate());
        assertEquals(3.0,point.getZ()._coordinate());
    }

    @Test
    void equalsMethod(){
        Point3D point1 = new Point3D(new Coordinate(2.0),new Coordinate(6.0),new Coordinate(8.0));
        Point3D point2 = new Point3D(new Coordinate(2.0),new Coordinate(6.0),new Coordinate(8.0));
        assertEquals(true, point1.equals(point2));
     }
    }