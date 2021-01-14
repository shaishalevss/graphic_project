package Elements;

import Primitives.Point3D;
import Primitives.Vector;

import java.awt.*;

public class AmbientLight extends Light {
    protected Color _intensity;
    protected double kA = 0.1;



    public AmbientLight(Color color, double kA) {
        this._intensity = color;
        this.kA = kA;
    }
    public AmbientLight() {
        this._intensity = Color.BLACK;
    }

    public AmbientLight(AmbientLight otherLight) {
        this._intensity = new Color(otherLight._intensity.getRed(),otherLight._intensity.getGreen(),otherLight._intensity.getBlue());
        this.kA = otherLight.kA;
    }


    @Override
    public Color getIntensity(Point3D point) {
        return new Color((int)(_intensity.getRed()*kA), (int)(_intensity.getGreen()*kA), (int)(_intensity.getBlue()*kA));
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
                this._intensity.equals(((AmbientLight) otherAmbience)._intensity);
    }
}
