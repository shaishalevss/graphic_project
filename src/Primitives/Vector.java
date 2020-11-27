package Primitives;

public class Vector {
    protected Point3D _head;

    //constructors
    public Vector(Point3D head) {
        this._head = new Point3D(head);
    }

    public Vector() {
        this._head = new Point3D();
    }

    public Vector(double newX, double newY, double newZ) {
        this._head= new Point3D(newX, newY, newZ);
    }

    public Vector(Vector otherVector) {
        this._head = otherVector.getHead();
    }

    //getters
    public Point3D getHead() {
        return new Point3D(this._head);
    }

    //setters
    public void setHead(Point3D _head) {
        this._head = _head;
    }

    //equal method override
    @Override
    public boolean equals(Object otherVector) {
        return this._head.equals(((Vector)otherVector)._head);
    }


    //calculate the length of the vector
    public double length(){
        return Math.abs(Math.sqrt(Math.pow(_head._x._coordinate,2)+Math.pow(_head._y._coordinate,2)+Math.pow(_head._z._coordinate,2)));
    }

    //normalize the vector
    public Vector normalize(){

        Coordinate newX = new Coordinate(_head._x._coordinate/length());
        Coordinate newY = new Coordinate(_head._y._coordinate/length());
        Coordinate newZ = new Coordinate(_head._z._coordinate/length());

        return new Vector(new Point3D(newX,newY,newZ));
    }

    //vector addition
    public Vector add(Vector other){
        if (this._head._x._coordinate==other._head._x._coordinate*-1&&
                this._head._y._coordinate==other._head._y._coordinate*-1&&
                this._head._z._coordinate==other._head._z._coordinate*-1) {
            throw new IllegalArgumentException("Cannot subtract mirrored vectors");
        }

        double newX = this._head._x._coordinate+other._head._x._coordinate;
        double newY = this._head._y._coordinate+other._head._y._coordinate;
        double newZ = this._head._z._coordinate+other._head._z._coordinate;


        return new Vector(newX,newY,newZ);
    }

    //vector subtraction
    public Vector subtract(Vector other){
        if(this.equals(other)){
            throw new IllegalArgumentException("Cannot subtract equal vectors");
        }
        return new Vector(
                this.getHead()._x._coordinate-other._head._x._coordinate,
                this.getHead()._y._coordinate-other._head._y._coordinate,
                this.getHead()._z._coordinate-other._head._z._coordinate);
    }

    //multiply vector with scalar
    public Vector scale(double scalar){
        if (scalar==0){
            throw new IllegalArgumentException("Cannot multiply vector by 0");
        }

        Coordinate newX = new Coordinate(_head._x._coordinate*scalar);
        Coordinate newY = new Coordinate(_head._y._coordinate*scalar);
        Coordinate newZ = new Coordinate(_head._z._coordinate*scalar);

        return new Vector(new Point3D(newX,newY,newZ));
    }

    //multiply vector with vector
    public Vector crossProduct(Vector other){
        Coordinate newX = new Coordinate((_head._y._coordinate*other._head._z._coordinate)-(_head._z._coordinate*other._head._y._coordinate));
        Coordinate newY = new Coordinate((_head._z._coordinate*other._head._x._coordinate)-(_head._x._coordinate*other._head._z._coordinate));
        Coordinate newZ = new Coordinate((_head._x._coordinate*other._head._y._coordinate)-(_head._y._coordinate*other._head._x._coordinate));

        Vector newVector = new Vector(new Point3D(newX,newY,newZ));

        if (newVector._head._x._coordinate==0&&
                newVector._head._y._coordinate==0&&
                newVector._head._z._coordinate==0){
            throw new IllegalArgumentException("Cannot cross parallel vectors");
        }
        return newVector;
    }

    //scalar multiply
    public double dotProduct(Vector other){
        return (_head._x._coordinate*other._head._x._coordinate)+
                (_head._y._coordinate*other._head._y._coordinate)+
                (_head._z._coordinate*other._head._z._coordinate);

    }



    //ToString
    @Override
    public String toString() {
        return ""+ this._head;
    }
}
