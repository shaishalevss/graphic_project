package Unittests;

import Geometries.Geometry;
import Geometries.Plane;
import Geometries.Triangle;
import Primitives.Coordinate;
import Primitives.Point3D;
import Primitives.Vector;
import Scene.Scene;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;


import static org.junit.jupiter.api.Assertions.*;

class SceneTest {
    @Test
    void emptyVector() {
        Scene scene = new Scene();
        assertEquals("Unknown", scene.getName());
        assertTrue(scene.getGeometries().isEmpty());
    }

    @Test
    void setSceneAndAddGeometry() {
        ArrayList<Geometry> sceneList = new ArrayList<>();
        sceneList.add(new Plane(new Point3D(new Coordinate(1.0),new Coordinate(2.0),new Coordinate(3.0)),new Vector(new Point3D(new Coordinate(1.0),new Coordinate(2.0),new Coordinate(3.0)))));
        sceneList.add(new Plane(new Point3D(new Coordinate(5.0),new Coordinate(7.0),new Coordinate(8.0)),new Vector(new Point3D(new Coordinate(11.0),new Coordinate(52.0),new Coordinate(23.0)))));

        Scene scene = new Scene();
        scene.setGeometries(sceneList);
        scene.setName("Shai");
        assertEquals("Shai", scene.getName());
        assertEquals(1.0, ((Plane)scene.getGeometries().get(0)).getQ().getX().getCoordinate());

        scene.addGeometry(new Triangle(new Point3D(new Coordinate(1),new Coordinate(1), new Coordinate(1)),
                new Point3D(new Coordinate(2),new Coordinate(2), new Coordinate(2)),
                new Point3D(new Coordinate(3),new Coordinate(3), new Coordinate(3))));
        assertEquals(1,((Triangle)scene.getGeometries().get(2)).getP1().getX().getCoordinate());
    }

    @Test
    void equalsMethod() {
        ArrayList<Geometry> sceneList1 = new ArrayList<>();
        sceneList1.add(new Plane(new Point3D(new Coordinate(1.0),new Coordinate(2.0),new Coordinate(3.0)),new Vector(new Point3D(new Coordinate(1.0),new Coordinate(2.0),new Coordinate(3.0)))));
        sceneList1.add(new Plane(new Point3D(new Coordinate(5.0),new Coordinate(7.0),new Coordinate(8.0)),new Vector(new Point3D(new Coordinate(11.0),new Coordinate(52.0),new Coordinate(23.0)))));

        Scene scene1 = new Scene();
        scene1.setGeometries(sceneList1);

        ArrayList<Geometry> sceneList2 = new ArrayList<>();
        sceneList2.add(new Plane(new Point3D(new Coordinate(1.0),new Coordinate(2.0),new Coordinate(3.0)),new Vector(new Point3D(new Coordinate(1.0),new Coordinate(2.0),new Coordinate(3.0)))));
        sceneList2.add(new Plane(new Point3D(new Coordinate(5.0),new Coordinate(7.0),new Coordinate(8.0)),new Vector(new Point3D(new Coordinate(11.0),new Coordinate(52.0),new Coordinate(23.0)))));

        Scene scene2 = new Scene();
        scene2.setGeometries(sceneList2);
        assertTrue(scene1.equals(scene2));
    }
    }