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

    @Override
    public Color getIntensity(Point3D point){
        return new Color(intensity.getRed(),intensity.getGreen(),intensity.getBlue());
    }

    @Override
    public Vector getL(Point3D point){
        return new Vector(_direction);

}
