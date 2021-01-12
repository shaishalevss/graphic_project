package Elements;

import Primitives.Point3D;
import Primitives.Vector;

import java.awt.*;

public class AmbientLight extends Light {
    protected Color _intensity;
    protected double kA = 0.1;


    public AmbientLight() {
        this._intensity = Color.BLACK;
    }

    public AmbientLight(Color color, double kA) {
        this._intensity = color;
        this.kA = kA;
    }


    @Override
    public Color getIntensity(Point3D point) {
        return new Color(_intensity.getRed(), _intensity.getGreen(), _intensity.getBlue());
    }

    @Override
    public Vector getL(Point3D point) {
        return new Vector();
    }

    public double getKA() {
        return this.kA;
    }


    public void setIntensity(Color intensity) {
        this._intensity = intensity;
    }

    public void setKA(double kA) {
        this.kA = kA;
    }

    public String toString() {
        return "" + _intensity + " " + kA;
    }

    public boolean equals(Object otherAmbience) {
        return this.kA == ((AmbientLight) otherAmbience).kA &&
                this.intensity.equals(((AmbientLight) otherAmbience)._intensity);
    }
}
