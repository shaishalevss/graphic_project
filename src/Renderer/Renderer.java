package Renderer;

import Geometries.GeoPoint;
import Geometries.Geometry;
import Geometries.Triangle;
import Primitives.Point3D;
import Primitives.Ray;
import Scene.Scene;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Renderer {
    protected Scene _scene;
    protected ImageWriter _imageWriter;

    public Renderer(Scene scene,ImageWriter imageWriter) {
        this._scene = scene;
        this._imageWriter = imageWriter;
    }

    public Renderer() {
        this._scene = null;
        this._imageWriter = null;
    }

    public Renderer(Renderer otherRenderer) {
        this._scene = otherRenderer.getScene();
        this._imageWriter = otherRenderer.getImageWriter();
    }

    //getters
    public Scene getScene() {
        return new Scene(_scene);
    }

    public ImageWriter getImageWriter() {
        return new ImageWriter(this._scene.getName(),_imageWriter.getWidth(),_imageWriter.getHeight(),_imageWriter.getNx(),_imageWriter.getNy());
    }

    //setters
    public void setScene(Scene otherScene) {
        this._scene = otherScene;
    }

    public void set_imageWriter(ImageWriter otherImageWriter) {
        this._imageWriter = otherImageWriter;
    }

    public void renderImage() {
        for(int i = 0 ; i<_imageWriter.getHeight() ; i++){
            for(int j = 0 ; j<_imageWriter.getWidth() ; j++){
                Ray ray = _scene.getCamera().constructRayThroughPixel(_imageWriter.getNx(), _imageWriter.getNy(), j, i, _scene.getScreenDistance() , _imageWriter.getWidth(),_imageWriter.getHeight());
                List<GeoPoint> intersectionPoints = getSceneRayIntersections(ray);
                if(intersectionPoints.isEmpty()){
                    _imageWriter.writePixel(j,i,_scene.getBackgroundColor());
                } else {
                    GeoPoint closestPoint = getClosestPoint(intersectionPoints);
                    _imageWriter.writePixel(j,i, calcColor(closestPoint));
                }
            }
        }
        _imageWriter.writeToImage();
    }

    private List<GeoPoint> getSceneRayIntersections(Ray ray) {
        List<GeoPoint> intersectionPoints = new ArrayList<GeoPoint>();
        for(Geometry geometry: _scene.getGeometries()){
            List<GeoPoint>geometryIntersectionPoints = geometry.findIntersections(ray);
            if(!(geometryIntersectionPoints == null)) {
                intersectionPoints.addAll(geometryIntersectionPoints);
            }
        }
        return intersectionPoints;
    }

    private GeoPoint getClosestPoint(List<GeoPoint> intersectionPoints) {
        double distance = Double.MAX_VALUE;
        Point3D p0 = _scene.getCamera().getProjectionCenter();
        GeoPoint minDistancePoint = null;
        for(GeoPoint point: intersectionPoints){
            if(p0.distance(point.getPoint())<distance){
                minDistancePoint = new GeoPoint(point.getGeometry(),point.getPoint());
                distance = p0.distance(point.getPoint());
            }
        }
        return minDistancePoint;
    }

    private Color calcColor(GeoPoint gp) {
        return ((Geometry)gp.getGeometry()).getEmission();
    }

}
