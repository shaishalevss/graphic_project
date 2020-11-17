package Elements;

import Primitives.Point3D;
import Primitives.Vector;

public class Camera {
    protected Point3D _projectionCenter;
    protected Vector _vUp;
    protected Vector _vRight;
    protected Vector _vToward;

    public Camera() {
        this._projectionCenter = new Point3D();
        this._vUp = new Vector();
        this._vRight = new Vector();
        this._vToward = new Vector();
    }

    public Camera(Vector vUp, Vector vRight) {
        this._projectionCenter = new Point3D();
        this._vUp = new Vector(vUp);
        this._vRight = new Vector(vRight);
        this._vToward = new Vector(vUp.crossProduct(vRight));
    }
}
