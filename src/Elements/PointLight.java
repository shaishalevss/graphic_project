package Elements;

import Primitives.Point3D;
import Primitives.Vector;

import java.awt.*;

public class PointLight extends Light {
    protected Color _intensity;
    protected Point3D _position;
    protected double _kc;
    protected double _kl;
    protected double _kq;

    public PointLight() {
        this._intensity = Color.BLACK;
        this._position = new Point3D();
        this._kc = 0;
        this._kl = 0;
        this._kq = 0;
    }

    public PointLight(PointLight otherLight) {
        this._intensity = otherLight.getIntensity(new Point3D());
        this._position = otherLight.getPosition();
        this._kc = otherLight._kc;
        this._kl = otherLight._kl;
        this._kq = otherLight._kq;
    }

    public PointLight(Color intensity, Point3D position, double kc, double kl, double kq) {
        this._intensity = intensity;
        this._position = position;
        this._kc = kc;
        this._kl = kl;
        this._kq = kq;
    }


    @Override
    public Color getIntensity(Point3D point) {
        double distance = _position.distance(point);
        double denominator = _kc + _kl * distance + _kq * distance * distance;
        return new Color((int)(_intensity.getRed()/denominator), (int)(_intensity.getGreen()/denominator), (int)(_intensity.getBlue()/denominator));
    }

    @Override
    public Vector getL(Point3D point) {
        return point.subtract(_position);
    }

    public Point3D getPosition() {
        return new Point3D(this._position);
    }

    public double getKc() {
        return this._kc;
    }

    public double getKl() {
        return this._kl;
    }

    public double getKq() {
        return this._kq;
    }


    public void setIntensity(Color intensity) {
        this._intensity = intensity;
    }

    public void setPosition(Point3D position) {
        this._position = position;
    }

    public void setKc(double kc) {
        this._kc = kc;
    }

    public void setKl(double kl) {
        this._kl = kl;
    }

    public void setKq(double kq) {
        this._kq = kq;
    }

    public String toString() {
        return "" + this._intensity + " " + this._position + " " + this._kc + " " + this._kl + " " + this._kq;
    }

    public boolean equals(Object otherLight) {
        return this._position.equals(((PointLight) otherLight)._position) &&
                this._intensity.equals(((PointLight) otherLight)._intensity) &&
                this._kc == ((PointLight) otherLight)._kc &&
                this._kl == ((PointLight) otherLight)._kl &&
                this._kq == ((PointLight) otherLight)._kq;
    }
}
