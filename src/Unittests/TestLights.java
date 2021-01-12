package Unittests;

import java.awt.Color;

import org.junit.jupiter.api.Test;

import Elements.*;
import Geometries.*;
import Primitives.*;
import Renderer.*;
import Scene.Scene;

class TestLights {

    private Scene scene;
    private Geometry sphere;

    void sphereTests()
    {
        scene = new Scene("Test scene");
        scene.setCamera(new Camera(new Point3D(0, 0, -200), new Vector(0, 0, 1), new Vector(0, -1, 0)));
        scene.setScreenDistance(200); //
        scene.setBackground(Color.BLACK);
        scene.setAmbientLight(new AmbientLight(Color.WHITE,0.15));

        sphere = new Sphere(new Point3D(0, 0, 500),500,Color.BLUE);
        sphere.setMaterial(new Material(1,1,100));
        scene.addGeometry(sphere);

    }

    /**
     * Produce a picture of a sphere lighted by a Ambient Light only
     */
    @Test
    public void sphereAmbient() {
        sphereTests();
        ImageWriter imageWriter = new ImageWriter("sphereAmbient", 500, 500, 500, 500);

        Renderer render = new Renderer(scene, imageWriter);
        render.renderImage();
    }

    /**
     * Produce a picture of a sphere lighted by a directional light
     */
    @Test
    public void sphereDirectional() {
        sphereTests();

        scene.addLight(new DirectionalLight(new Color(255, 100, 100), new Vector(3,-1,2)));

        ImageWriter imageWriter = new ImageWriter("sphereDirectional", 500, 500, 500, 500);

        Renderer render = new Renderer(imageWriter, scene);
        render.renderImage();
    }

    /**
     * Produce a picture of a sphere lighted by a point light
     */
    @Test
    public void spherePoint() {
        sphereTests();

        scene.addLight(new PointLight(new Color(255, 100, 100), new Point3D(-200, 200, -250),  1, 0.00001, 0.000005));

        ImageWriter imageWriter = new ImageWriter("spherePoint", 500, 500, 500, 500);

        Renderer render = new Renderer(scene, imageWriter);
        render.renderImage();
    }
    /**
     * Produce a picture of a sphere lighted by a spot light
     */
    @Test
    public void sphereSpot() {
        sphereTests();

        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, 200, -250),new Vector(3,-1,2),  1, 0.00001, 0.000005));

        ImageWriter imageWriter = new ImageWriter("sphereSpot", 500, 500, 500, 500);

        Renderer render = new Renderer(scene, imageWriter);
        render.renderImage();
    }
}

