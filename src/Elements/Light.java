package Elements;

import Primitives.Point3D;
import Primitives.Vector;

import java.awt.*;

public abstract class Light {
    protected Color _intensity;

    public abstract Color getIntensity(Point3D point);

    public abstract Vector getL(Point3D points);
}
