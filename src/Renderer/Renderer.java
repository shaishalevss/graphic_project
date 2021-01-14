package Renderer;

import Elements.Light;
import Geometries.GeoPoint;
import Geometries.Geometry;
import Geometries.Triangle;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;
import Scene.Scene;
import Primitives.Util;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Renderer {
    protected Scene _scene;
    protected ImageWriter _imageWriter;

    public Renderer(Scene scene, ImageWriter imageWriter) {
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
        return new ImageWriter(this._scene.getName(), _imageWriter.getWidth(), _imageWriter.getHeight(), _imageWriter.getNx(), _imageWriter.getNy());
    }

    //setters
    public void setScene(Scene otherScene) {
        this._scene = otherScene;
    }

    public void set_imageWriter(ImageWriter otherImageWriter) {
        this._imageWriter = otherImageWriter;
    }

    public void renderImage() {
        for (int i = 0; i < _imageWriter.getHeight(); i++) {
            for (int j = 0; j < _imageWriter.getWidth(); j++) {
                Ray ray = _scene.getCamera().constructRayThroughPixel(_imageWriter.getNx(), _imageWriter.getNy(), j, i, _scene.getScreenDistance(), _imageWriter.getWidth(), _imageWriter.getHeight());
                List<GeoPoint> intersectionPoints = getSceneRayIntersections(ray);
                if (intersectionPoints.isEmpty()) {
                    _imageWriter.writePixel(j, i, _scene.getBackgroundColor());
                } else {
                    GeoPoint closestPoint = getClosestPoint(intersectionPoints);
                    _imageWriter.writePixel(j, i, calcColor(closestPoint));
                }
            }
        }
        _imageWriter.writeToImage();
    }

    private List<GeoPoint> getSceneRayIntersections(Ray ray) {
        List<GeoPoint> intersectionPoints = new ArrayList<GeoPoint>();
        for (Geometry geometry : _scene.getGeometries()) {
            List<GeoPoint> geometryIntersectionPoints = geometry.findIntersections(ray);
            if (!(geometryIntersectionPoints == null)) {
                intersectionPoints.addAll(geometryIntersectionPoints);
            }
        }
        return intersectionPoints;
    }

    private GeoPoint getClosestPoint(List<GeoPoint> intersectionPoints) {
        double distance = Double.MAX_VALUE;
        Point3D p0 = _scene.getCamera().getProjectionCenter();
        GeoPoint minDistancePoint = null;
        for (GeoPoint point : intersectionPoints) {
            if (p0.distance(point.getPoint()) < distance) {
                minDistancePoint = new GeoPoint(point.getGeometry(), point.getPoint());
                distance = p0.distance(point.getPoint());
            }
        }
        return minDistancePoint;
    }

    public Color calcDiffusiveComp(double kd, Vector normal, Vector l, Color intensity) {
        l = l.scale(-1);
        Vector color = new Vector(intensity.getRed(), intensity.getGreen(), intensity.getBlue());
        color = color.scale(kd*normal.dotProduct(l));
        return Util.vecToColor(color);




//        l = l.scale(-1);
//        double red = kd * intensity.getRed() * normal.dotProduct(l);
//        double green = kd * intensity.getGreen() * normal.dotProduct(l);
//        double blue = kd * intensity.getBlue() * normal.dotProduct(l);
////        Vector b = new Vector(intensity.getRed(),intensity.getGreen(),intensity.getBlue());
////        b=b.scale(kd* normal.dotProduct(l));
////        System.out.println(b);
//        if (red < 0)
//            red = 0;
//        else if (red > 255)
//            red = 255;
//        if (green < 0)
//            green = 0;
//        else if (green > 255)
//            green = 255;
//        if (blue < 0)
//            blue = 0;
//        else if (blue > 255)
//            blue = 255;
////        System.out.println(red+" "+green+" "+blue);
//
//        return new Color((int) red, (int) green, (int) blue);
    }

    public Color calcSpecularComp(double ks, Vector cameraVector, Vector normal, Vector l, double shininess, Color intensity) {
        l = l.scale(-1);
        Vector color = new Vector(intensity.getRed(), intensity.getGreen(), intensity.getBlue());

        Vector r = l.subtract(normal.scale(l.dotProduct(normal)));

        if (Math.pow(cameraVector.dotProduct(r),shininess) == 0)
            return Color.BLACK;

        color = color.scale(ks * Math.pow(cameraVector.dotProduct(r),shininess));

        return Util.vecToColor(color);












////        System.out.println(normal.length());
////        System.out.println(cameraVector.length());
////        normal = normal.normalize();
////        cameraVector = cameraVector.normalize();
//
////        l = l.scale(-1);
////        l = l.normalize();
////        cameraVector = cameraVector.scale(-1);
////        System.out.println(cameraVector.length()+normal.length()+l.length());
////        Vector r;
////        if ((l.dotProduct(normal))==0)
////            r = l;
////        else
////        Vector  r = l.subtract(normal.scale(-2 * (l.dotProduct(normal))));
////        System.out.println(cameraVector.dotProduct(r));
//        Vector r = l.subtract(normal.scale(2 * l.dotProduct(normal)));
//        double red = ks * (Math.pow(cameraVector.dotProduct(r), shininess)) * intensity.getRed();
//        double green = ks * (Math.pow(cameraVector.dotProduct(r), shininess)) * intensity.getGreen();
//        double blue = ks * (Math.pow(cameraVector.dotProduct(r), shininess)) * intensity.getBlue();
////        System.out.println(red+" "+green+" "+blue);
//
//
//        if (red < 0)
//            red = 0;
//        else if (red > 255)
//            red = 255;
//        if (green < 0)
//            green = 0;
//        else if (green > 255)
//            green = 255;
//        if (blue < 0)
//            blue = 0;
//        else if (blue > 255)
//            blue = 255;
//
//        return new Color((int) red, (int) green, (int) blue);
    }

    private Color calcColor(GeoPoint gp) {
        Color ambientLight = _scene.getAmbience().getIntensity(new Point3D());
        Color emissionLight = gp.getGeometry().getEmission();
        Color diffuseLight = Color.BLACK;
        Color specularLight = Color.BLACK;
//        double diffuseR = 0;
//        double diffuseG = 0;
//        double diffuseB = 0;
//        double specularR = 0;
//        double specularG = 0;
//        double specularB = 0;
        for (Light light : _scene.getLights()) {
            Color diffuse = calcDiffusiveComp(gp.getGeometry().getMaterial().getKd(),
                    gp.getGeometry().getNormal(gp.getPoint()).normalize(),
                    light.getL(gp.getPoint()).normalize(),
                    light.getIntensity(gp.getPoint()));
            diffuseLight = Util.addColor(diffuseLight, diffuse);
//            System.out.println(diffuse);

            Color specular = calcSpecularComp(gp.getGeometry().getMaterial().getKs(),
                    new Vector(_scene.getCamera().getProjectionCenter().subtract(gp.getPoint())).normalize(),
                    gp.getGeometry().getNormal(gp.getPoint()).normalize(),
                    light.getL(gp.getPoint()).normalize(),
                    gp.getGeometry().getMaterial().getShininess(),
                    light.getIntensity(gp.getPoint()));
            specularLight = Util.addColor(specularLight, specular);
//            specularR += specular.getRed();
//            specularG += specular.getGreen();
//            specularB += specular.getBlue();
//            System.out.println(specular);
        }
//        int finalR = (int) (ambientLight.getRed() + emissionLight.getRed() + diffuseR + specularR);
//        int finalG = (int) (ambientLight.getGreen() + emissionLight.getGreen() + diffuseG + specularG);
//        int finalB = (int) (ambientLight.getBlue() + emissionLight.getBlue() + diffuseB + specularB);
//        if (finalR<0)
//            finalR=0;
//        else if(finalR>255)
//            finalR=255;
//        if (finalG<0)
//            finalG=0;
//        else if(finalG>255)
//            finalG=255;
//        if (finalB<0)
//            finalB=0;
//        else if(finalB>255)
//            finalB=255;
        Color finalColor = Color.BLACK;
        finalColor = Util.addColor(finalColor, ambientLight);
        finalColor = Util.addColor(finalColor, emissionLight);
        finalColor = Util.addColor(finalColor, diffuseLight);
        finalColor = Util.addColor(finalColor, specularLight);
        finalColor = Util.vecToColor(Util.colorToVec(finalColor).scale(0.5));


//        System.out.println(finalR+" "+finalG+" "+finalB);

        return finalColor;
//        return new Color(finalR,finalG,finalB);

//        return ((Geometry) gp.getGeometry()).getEmission();
    }

}
