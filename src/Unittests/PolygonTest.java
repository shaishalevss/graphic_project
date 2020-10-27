package Unittests;

import Geometries.Polygon;
import Primitives.Coordinate;
import Primitives.Point3D;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PolygonTest {

    @Test
    void emptyPolygon(){
        Polygon polygon = new Polygon();
        assertEquals(true, polygon.getPoints().isEmpty());
    }

    @Test
    void setPolygon(){
        List<Point3D> myPolygonTestList = new ArrayList<Point3D>();
        myPolygonTestList.add(new Point3D(new Coordinate(1.0), new Coordinate(2.0), new Coordinate(3.0)));
        myPolygonTestList.add(new Point3D(new Coordinate(4.0), new Coordinate(5.0), new Coordinate(6.0)));
        myPolygonTestList.add(new Point3D(new Coordinate(7.0), new Coordinate(8.0), new Coordinate(9.0)));

        Polygon polygon = new Polygon();
        polygon.setPoints(myPolygonTestList);
        assertEquals(4.0, polygon.getPoints().get(1).getX().getCoordinate());
    }

    @Test
    void equalsMethod(){
        List<Point3D> myPolygonTestList1 = new ArrayList<Point3D>();
        myPolygonTestList1.add(new Point3D(new Coordinate(1.0), new Coordinate(2.0), new Coordinate(3.0)));
        myPolygonTestList1.add(new Point3D(new Coordinate(4.0), new Coordinate(5.0), new Coordinate(6.0)));
        myPolygonTestList1.add(new Point3D(new Coordinate(7.0), new Coordinate(8.0), new Coordinate(9.0)));

        List<Point3D> myPolygonTestList2 = new ArrayList<Point3D>();
        myPolygonTestList2.add(new Point3D(new Coordinate(1.0), new Coordinate(2.0), new Coordinate(3.0)));
        myPolygonTestList2.add(new Point3D(new Coordinate(4.0), new Coordinate(5.0), new Coordinate(6.0)));
        myPolygonTestList2.add(new Point3D(new Coordinate(7.0), new Coordinate(8.0), new Coordinate(9.0)));

        Polygon polygon1 = new Polygon(myPolygonTestList1);
        Polygon polygon2 = new Polygon(myPolygonTestList2);
        assertEquals(true, polygon1.equals(polygon2));
    }
}