package Unittests;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;

import Elements.*;
import Geometries.*;
import Primitives.*;
import Renderer.*;
import Scene.Scene;

class testShadow {


    @Test
    public void twoTriangles(){

        Scene scene = new Scene("twoTriangles");
        scene.setBackground(new Color(0, 0, 0));
        scene.setCamera(new Camera( new Point3D(0, 0, 0),new Vector(0.0, 0.0, 1.0),new Vector(0,-1, 0.0)));
        scene.setScreenDistance(100);
        scene.setAmbientLight(new AmbientLight(new Color(255, 255, 255), 0.1));

        Triangle triangle1 = new Triangle(new Point3D(-300, 0, 300),
                new Point3D(300, 0, 300),
                new Point3D(0, -600, 300),
                new Color (0, 0, 100));

        Triangle triangle2 = new Triangle(new Point3D(-100, 100, 150),
                new Point3D(100, 100, 150),
                new Point3D(0, -100, 150),
                new Color (0, 100, 0));

        Material m1=new Material(1,1,20);
        triangle1.setMaterial(m1);
        triangle2.setMaterial(m1);
        scene.addGeometry(triangle1);
        scene.addGeometry(triangle2);

        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(0, 200, 0), new Vector(0,-100,150), 0, 0.000001, 0.0000005));

        ImageWriter imageWriter = new ImageWriter("twoTriangles", 500, 500, 500, 500);

        Renderer render = new Renderer(scene, imageWriter);

        render.renderImage();

    }
    @Test
    public void spotLightTest2(){

        Scene scene = new Scene("spotLightTest2");
        scene.setCamera(new Camera( new Point3D(0, 0, 0),new Vector(0.0, 0.0, 1.0),new Vector(0,-1, 0.0)));
        scene.setScreenDistance(200);
        scene.setAmbientLight(new AmbientLight(new Color(255, 255, 255), 0.1));

        Sphere sphere = new Sphere(new Point3D(0.0, 0.0, 1000),500,new Color(0, 0, 100));
        Material m1=new Material(1,1,20);
        sphere.setMaterial(m1);
        scene.addGeometry(sphere);

        Triangle triangle = new Triangle(new Point3D(-125, 225, 260),
                new Point3D(-225, 125, 260),
                new Point3D(-225, 225, 270),
                new Color (0, 0, 100));

        Material m2=new Material(1,1,4);
        triangle.setMaterial(m2);
        scene.addGeometry(triangle);

//			scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, 200, -150), new Vector(2, 2, -3), 0.1, 0.00001, 0.000005));
        scene.addLight(new PointLight(new Color(255, 100, 100), new Point3D(-200, 200, -100),  0, 0.000001, 0.0000005));

        ImageWriter imageWriter = new ImageWriter("Spot test 2", 500, 500, 500, 500);

        Renderer render = new Renderer(scene, imageWriter);

        render.renderImage();

    }

}
