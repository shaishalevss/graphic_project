package Elements;

import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

import java.awt.*;
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
    public Camera(Vector vToward, Vector vUp) {
        this._projectionCenter = new Point3D();
        this._vToward = new Vector(vToward);
        this._vUp = new Vector(vUp);
        this._vRight = new Vector(vToward.crossProduct(vUp));
    }

    public Camera(Point3D projectionCenter, Vector vToward, Vector vUp) {
        this._projectionCenter = projectionCenter;
        this._vToward = new Vector(vToward);
        this._vUp = new Vector(vUp);
        this._vRight = new Vector(vToward.crossProduct(vUp));
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


    public Ray constructRayThroughPixel(int nX, int nY, int j, int i, double screenDistance, double screenWidth, double screenHeight) {
        Point3D pIJ = this._projectionCenter.add(this._vToward.scale(screenDistance));  //Center point of the plane
        double rX = screenWidth/nX;                                                     //Calculating the size
        double rY = screenHeight/nY;                                                    //of the pixels on the plane

        double yI = rY*(i-((double)(nY-1)/2));                                          //Movement on the y axis
        double xJ = rX*(j-((double)(nX-1)/2));                                          //Movement on the x axis

        if (xJ != 0)                                                                    //If there is movement on the x
            pIJ = pIJ.add(_vRight.scale(xJ));                                           //axis then move
        if (yI != 0)                                                                    //If there is movement on the y
            pIJ = pIJ.add(_vUp.scale(-yI));                                             //axis then move

        Vector vIJ = new Vector(pIJ.subtract(_projectionCenter));                       //cast a vector from camera to desired pixel

        return new Ray(new Point3D(_projectionCenter),vIJ.normalize());
    }

    @Override
    public String toString() {
        return "" + _projectionCenter + " " + _vUp + " " + _vRight + " " + _vToward;
    }

    @Override
    public boolean equals(Object otherCamera) {
        return this._projectionCenter.equals(((Camera)otherCamera)._projectionCenter)&&
                this._vToward.equals(((Camera)otherCamera)._vToward)&&
                this._vUp.equals(((Camera)otherCamera)._vUp)&&
                this._vRight.equals(((Camera)otherCamera)._vRight);
    }
}
