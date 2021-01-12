package Elements;

import Primitives.Point3D;
import Primitives.Vector;

import java.awt.*;

public class DirectionalLight extends Light {
    protected Color _intensity;
    protected Vector _direction;


    public DirectionalLight() {
        this._intensity = Color.BLACK;
        this._direction = new Vector();
    }

    public DirectionalLight(DirectionalLight otherLight) {
        this._intensity = otherLight.getIntensity(new Point3D());
        this._direction = otherLight.getL(new Point3D());
    }

    public DirectionalLight(Color intensity, Vector direction) {
        this._intensity = intensity;
        this._direction = direction;
    }


    @Override
    public Color getIntensity(Point3D point) {
        return new Color(_intensity.getRed(), _intensity.getGreen(), _intensity.getBlue());
    }

    @Override
    public Vector getL(Point3D point) {
        return new Vector(_direction);
    }


    public void setIntensity(Color intensity) {
        this._intensity = intensity;
    }

    public void setDirection(Vector direction) {
        this._direction = direction;
    }

    public String toString() {
        return "" + _intensity + " " + _direction;
    }

    public boolean equals(Object otherLight) {
        return this._direction.equals(((DirectionalLight) otherLight)._direction) &&
                this.intensity.equals(((DirectionalLight) otherLight)._intensity);
    }
}
