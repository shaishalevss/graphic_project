package Elements;

import Primitives.Point3D;
import Primitives.Vector;

import java.util.Objects;

public class Camera {
    protected Point3D _projectionCenter;
    protected Vector _vUp;
    protected Vector _vRight;
    protected Vector _vToward;

    //Default Constructor.
    public Camera() {
        this._projectionCenter = new Point3D();
        this._vUp = new Vector();
        this._vRight = new Vector();
        this._vToward = new Vector();
    }

    //Basic Constructor
    public Camera(Vector vUp, Vector vRight) {
        this._projectionCenter = new Point3D();
        this._vUp = new Vector(vUp);
        this._vRight = new Vector(vRight);
        this._vToward = vUp.crossProduct(vRight);
    }

    //Copy Constructor
    public Camera(Camera otherCamera) {
        this._projectionCenter = otherCamera.getProjectionCenter();
        this._vUp = otherCamera.getVUp();
        this._vRight = otherCamera.getVRight();
        this._vToward = otherCamera.getVToward();
    }

    //Getters
    public Point3D getProjectionCenter() {
        return new Point3D(this._projectionCenter);
    }

    public Vector getVUp() {
        return new Vector(this._vUp);
    }

    public Vector getVRight() {
        return new Vector(this._vRight);
    }

    public Vector getVToward() {
        return new Vector(this._vToward);
    }

    //Setters
    public void setProjectionCenter(Point3D newCenter) {
        this._projectionCenter = new Point3D(newCenter);
    }

    public void setVUp(Vector newVUp) {
        this._vUp = new Vector(newVUp);
    }

    public void setVRight(Vector newVRight) {
        this._vRight = new Vector(newVRight);
    }

    public void setVToward(Vector newVToward) {
        this._vToward = new Vector(newVToward);
    }

    @Override
    public String toString() {
        return "" + _projectionCenter + _vUp + _vRight + _vToward;
    }

    @Override
    public boolean equals(Object otherCamera) {
        return (this._projectionCenter.equals(((Camera)otherCamera)._projectionCenter)&&
                this._vUp.equals(((Camera)otherCamera)._vUp)&&
                this._vRight.equals(((Camera)otherCamera)._vRight)&&
                this._vToward.equals(((Camera)otherCamera)._vToward));
    }
}
