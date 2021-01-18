package Elements;

import Primitives.Point3D;
import Primitives.Vector;

import java.awt.*;

public class SpotLight extends PointLight {
    protected Color _intensity;
    protected Point3D _position;
    protected Vector _direction;
    protected double _kc;
    protected double _kl;
    protected double _kq;


    public SpotLight() {
        _intensity = Color.BLACK;
        _position = new Point3D();
        _direction = new Vector();
        this._kc = 0;
        this._kl = 0;
        this._kq = 0;
    }

    public SpotLight(SpotLight otherLight) {
        _intensity = otherLight._intensity;
        _position = otherLight._position;
        _direction = otherLight._direction;
        this._kc = otherLight._kc;
        this._kl = otherLight._kl;
        this._kq = otherLight._kq;
    }

    public SpotLight(Color intensity, Point3D position, Vector direction, double kc, double kl, double kq) {
        _intensity = intensity;
        _position = position;
        _direction = direction;
        this._kc = kc;
        this._kl = kl;
        this._kq = kq;
    }


    @Override
    public Color getIntensity(Point3D point) {
        Vector l = getL(point);
        l = l.normalize();
        double distance = _position.distance(point);
        double denominator = _kc + _kl * distance + _kq * distance * distance;
        double red = (_intensity.getRed() * Math.max(0, _direction.normalize().dotProduct(l)))/denominator;
        double green = (_intensity.getGreen() * Math.max(0, _direction.normalize().dotProduct(l)))/denominator;
        double blue = (_intensity.getBlue() * Math.max(0, _direction.normalize().dotProduct(l)))/denominator;
        System.out.println(red+" "+green+" "+blue);
        if(red>255)
            red=255;
        if(blue>255)
            blue=255;
        if(green>255)
            green=255;

        return new Color((int) red, (int) green, (int) blue);
    }

    @Override
    public Vector getL(Point3D point) {
        return point.subtract(_position);
    }

    public Point3D getPosition() {
        return new Point3D(_position);
    }

    public Vector getDirection() {
        return new Vector(_direction);
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

    public void setDirection(Vector direction) {
        this._direction = direction.normalize();
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
        return "" + this._intensity + " " + this._position + " " + this._direction + " " + this._kc + " " + this._kl + " " + this._kq;
    }

    public boolean equals(Object otherLight) {
        return this._intensity.equals(((SpotLight) otherLight)._intensity) &&
                this._position.equals(((SpotLight) otherLight)._position) &&
                this._direction.equals(((SpotLight) otherLight)._direction) &&
                this._kc == ((SpotLight) otherLight)._kc &&
                this._kl == ((SpotLight) otherLight)._kl &&
                this._kq == ((SpotLight) otherLight)._kq;
    }
}
