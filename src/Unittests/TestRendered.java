package Unittests;


import java.awt.Color;

import org.junit.jupiter.api.Test;

import Elements.Camera;
import Geometries.Sphere;
import Geometries.Triangle;
import Primitives.Point3D;
import Primitives.Vector;
import Renderer.ImageWriter;
import Renderer.Renderer;
import Scene.Scene;

class TestRenderer {

    @Test
    public void basicRenderTwoColorTest() {

        Scene scene = new Scene("Test scene");
        scene.setCamera(new Camera(new Point3D(), new Vector(0, 0, 1), new Vector(0, -1, 0)));
        scene.setScreenDistance(100) ;
        scene.setBackground(new Color(0,0,0));;

        scene.addGeometry(new Sphere( new Point3D(0, 0, 100),50,new Color(255,0,0)));

        scene.addGeometry(new Triangle(new Point3D(100, 0, 100), new Point3D(0, 100, 100), new Point3D(100, 100, 100),new Color(255,255,0)));
        scene.addGeometry(new Triangle(new Point3D(100, 0, 100), new Point3D(0, -100, 100), new Point3D(100, -100, 100),new Color(0,255,0)));
        scene.addGeometry(new Triangle(new Point3D(-100, 0, 100), new Point3D(0, 100, 100), new Point3D(-100, 100, 100),new Color(0,0,255)));
        scene.addGeometry(new Triangle(new Point3D(-100, 0, 100), new Point3D(0, -100, 100), new Point3D(-100, -100, 100),new Color(0,255,255)));

        ImageWriter imageWriter = new ImageWriter("two color test", 500, 500, 500, 500);
        Renderer render = new Renderer(scene, imageWriter);

        render.renderImage();
    }

    @Test
    public void imageOne() {

        Scene scene = new Scene("Test scene");
        scene.setCamera(new Camera(new Point3D(), new Vector(0, 0, 1), new Vector(0, -1, 0)));
        scene.setScreenDistance(300) ;
        scene.setBackground(new Color(100, 149, 237));

//        scene.addGeometry(new Triangle(new Point3D(100, 0, 100), new Point3D(0, 100, 100), new Point3D(100, 100, 100),new Color(255,255,0)));
//        scene.addGeometry(new Triangle(new Point3D(100, 0, 100), new Point3D(0, -100, 100), new Point3D(100, -100, 100),new Color(0,255,0)));
//        scene.addGeometry(new Triangle(new Point3D(-100, 0, 100), new Point3D(0, 100, 100), new Point3D(-100, 100, 100),new Color(0,0,255)));
//        scene.addGeometry(new Triangle(new Point3D(-100, 0, 100), new Point3D(0, -100, 100), new Point3D(-100, -100, 100),new Color(0,255,255)));


        //LEFT SIDE
        //left side up
        scene.addGeometry(new Sphere( new Point3D(-220, -190, 300),150,new Color(0,255,255)));
        scene.addGeometry(new Sphere( new Point3D(-197, -170, 280),140,new Color(	0,0,139)));

        //hat
        scene.addGeometry(new Sphere( new Point3D(0, -150, 300),150,new Color(0,0,0)));

        //left side down
        scene.addGeometry(new Sphere( new Point3D(-220, 190, 300),150,new Color(	0,255,255)));
        scene.addGeometry(new Sphere( new Point3D(-197, 170, 280),140,new Color(		255,215,0)));



        //RIGHT SIDE

        //right up
        scene.addGeometry(new Sphere( new Point3D(220, 190, 300),150,new Color(	0,255,255)));
        scene.addGeometry(new Sphere( new Point3D(197, 170, 280),140,new Color(	255,127,80)));

        //right down
        scene.addGeometry(new Sphere( new Point3D(220, -190, 300),150,new Color(	0,255,255)));
        scene.addGeometry(new Sphere( new Point3D(197, -170, 280),140,new Color(		0,139,139)));


        //circles
        scene.addGeometry(new Sphere( new Point3D(0, 0, 300),150,new Color(	25,25,112)));
        scene.addGeometry(new Sphere( new Point3D(0, 0, 250),115,new Color(	255,20,147)));
        scene.addGeometry(new Sphere( new Point3D(0, 0, 230),100,new Color(105,105,105)));
        scene.addGeometry(new Sphere( new Point3D(0, 0, 210),85,new Color(	34,139,34)));
        scene.addGeometry(new Sphere( new Point3D(0, 0, 190),70,new Color(	255,105,180)));
        scene.addGeometry(new Sphere( new Point3D(0, 0, 170),55,new Color(128,0,128)));
        scene.addGeometry(new Sphere( new Point3D(0, 0, 150),40,new Color(	0,255,127)));
        scene.addGeometry(new Sphere( new Point3D(0, 0, 130),25,new Color(	255,255,0)));
        scene.addGeometry(new Sphere( new Point3D(0, 0, 110),10,new Color(	220,20,60)));





        ImageWriter imageWriter = new ImageWriter("imageONe", 1920, 1080, 1920, 1080);
        Renderer render = new Renderer(scene, imageWriter);

        render.renderImage();
    }


}