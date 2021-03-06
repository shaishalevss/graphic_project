package Scene;

import Elements.AmbientLight;
import Elements.Camera;
import Elements.Light;
import Geometries.*;
import Primitives.Point3D;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Scene {
    protected String _name;
    protected double _screenDistance;
    protected Color _background;
    protected Camera _camera;
    protected AmbientLight _ambientLight;
    protected ArrayList<Light> _lights;
    protected ArrayList<Geometry> _geometries;

    //constructors
    public Scene(String name, Double distance, Color backgroundColor, Camera camera, ArrayList<Light> lights, ArrayList<Geometry> geometries) {
        this._name = name;
        this._screenDistance = distance;
        this._background = backgroundColor;
        this._camera = camera;
        this._lights = lights;
        this._geometries = geometries;
    }

    public Scene(String name) {
        this._name = name;
        this._screenDistance = 0;
        this._background = Color.black;
        this._camera = new Camera();
        this._lights = new ArrayList<Light>();
        this._geometries = new ArrayList<Geometry>();
    }

    public Scene() {
        this._name = "Unknown";
        this._screenDistance = 0;
        this._background = Color.black;
        this._camera = new Camera();
        this._lights = new ArrayList<Light>();
        this._geometries = new ArrayList<Geometry>();
    }

    public Scene(Scene otherScene) {
        this._name = otherScene.getName();
        this._screenDistance = otherScene._screenDistance;
        this._background = otherScene.getBackgroundColor();
        this._camera = otherScene.getCamera();
        this._lights = otherScene.getLights();
        this._geometries = otherScene.getGeometries();
    }

    //getters

    public String getName() {
        return _name;
    }

    public double getScreenDistance() {
        return this._screenDistance;
    }

    public Color getBackgroundColor() {
        return new Color(_background.getRed(), _background.getGreen(), _background.getBlue());
    }

    public Camera getCamera() {
        return new Camera(_camera);
    }

    public AmbientLight getAmbience() {
        return new AmbientLight(_ambientLight);
    }

    public ArrayList<Light> getLights() {
        return _lights;
    }

    public ArrayList<Geometry> getGeometries() {
        ArrayList<Geometry> newList = new ArrayList<>();
        newList.addAll(_geometries);
        return newList;
    }


    //setters
    public void setName(String name) {
        this._name = name;
    }

    public void setScreenDistance(double distance) {
        this._screenDistance = distance;
    }

    public void setBackground(int r, int g, int b) {
        this._background = new Color(r, g, b);
    }

    public void setBackground(Color newColor) {
        this._background = newColor;
    }

    public void setCamera(Camera otherCamera) {
        this._camera = otherCamera;
    }

    public void setAmbientLight(AmbientLight ambience) {
        this._ambientLight = ambience;
    }

    public void setLights(ArrayList<Light> otherLights) {
        this._lights = otherLights;
    }

    public void setGeometries(ArrayList<Geometry> otherGeometries) {
        this._geometries = otherGeometries;
    }


    public void addLight(Light newLight) {
        _lights.add(newLight);
    }

    public void addGeometry(Geometry newGeometry) {
        _geometries.add(newGeometry);
    }


    //equals method
    @Override
    public boolean equals(Object otherScene) {
        return this._geometries.equals(((Scene) otherScene)._geometries) &&
                this._screenDistance == ((Scene) otherScene)._screenDistance &&
                this._background.equals(((Scene) otherScene)._background) &&
                this._name.equals(((Scene) otherScene)._name);
    }

    @Override
    public String toString() {
        return _name + " " + _screenDistance + " " + _background + " " + _geometries;
    }
}
