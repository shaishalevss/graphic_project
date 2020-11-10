package Primitives;

public class Vector {
    protected Point3D _head;

    //constructors
    public Vector(Point3D head) {
        this._head = head;
    }

    public Vector() {
        this._head = new Point3D();
    }

    public Vector(double newX, double newY, double newZ) {
        Point3D newPoint = new Point3D();
        newPoint.setX(new Coordinate(newX));
        newPoint.setY(new Coordinate(newY));
        newPoint.setZ(new Coordinate(newZ));
        this._head=newPoint;
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
        return this._head.equals(((Vector)otherVector).getHead());
    }


    //calculate the length of the vector
    public double length(){
        return Math.abs(Math.sqrt(Math.pow(_head.getX().getCoordinate(),2)+Math.pow(_head.getY().getCoordinate(),2)+Math.pow(_head.getZ().getCoordinate(),2)));
    }

    //normalize the vector
    public Vector normalize(){
        return new Vector(new Point3D(new Coordinate(
                _head.getX().getCoordinate()/length()),new Coordinate(_head.getY().getCoordinate()/length()),new Coordinate(_head.getZ().getCoordinate()/length()))
        );
    }

    //vector addition
    public Vector add(Vector other){
        if (this.getHead().getX().getCoordinate()==other.getHead().getX().getCoordinate()*-1&&
                this.getHead().getY().getCoordinate()==other.getHead().getY().getCoordinate()*-1&&
                this.getHead().getZ().getCoordinate()==other.getHead().getZ().getCoordinate()*-1) {
            throw new IllegalArgumentException("Cannot subtract mirroredx vectors");
        }
        return new Vector(
                this.getHead().getX().getCoordinate()+other.getHead().getX().getCoordinate(),
                this.getHead().getY().getCoordinate()+other.getHead().getY().getCoordinate(),
        this.getHead().getZ().getCoordinate()+other.getHead().getZ().getCoordinate());
    }

    //vector subtraction
    public Vector subtract(Vector other){
        if(this.equals(other)){
            throw new IllegalArgumentException("Cannot subtract equal vectors");
        }
        return new Vector(
                this.getHead().getX().getCoordinate()-other.getHead().getX().getCoordinate(),
                this.getHead().getY().getCoordinate()-other.getHead().getY().getCoordinate(),
                this.getHead().getZ().getCoordinate()-other.getHead().getZ().getCoordinate());
    }

    //multiply vector with scalar
    public Vector scale(double scalar){
        if (scalar==0){
            throw new IllegalArgumentException("Cannot multiply vector by 0");
        }
        return new Vector(
                new Point3D(
                        new Coordinate(
                                _head.getX().getCoordinate()*scalar),
                        new Coordinate(
                        _head.getY().getCoordinate()*scalar),
                        new Coordinate(
                        _head.getZ().getCoordinate()*scalar)
                )
        );
    }

    //multiply vector with vector
    public Vector crossProduct(Vector other){
        Vector newVector = new Vector(new Point3D(
                new Coordinate(
                        (_head.getY().getCoordinate()*other._head.getZ().getCoordinate())-(_head.getZ().getCoordinate()*other._head.getY().getCoordinate())),
                new Coordinate(
                        (_head.getZ().getCoordinate()*other._head.getX().getCoordinate())-(_head.getX().getCoordinate()*other._head.getZ().getCoordinate())),
                new Coordinate(
                        (_head.getX().getCoordinate()*other._head.getY().getCoordinate())-(_head.getY().getCoordinate()*other._head.getX().getCoordinate()))
        ));
        if (newVector.getHead().getX().getCoordinate()==0&&
                newVector.getHead().getY().getCoordinate()==0&&
                newVector.getHead().getZ().getCoordinate()==0){
            throw new IllegalArgumentException("Cannot cross parallel vectors");
        }
        return newVector;
    }

    //scalar multiply
    public double dotProduct(Vector other){
        return (_head.getX().getCoordinate()*other._head.getX().getCoordinate())+(_head.getY().getCoordinate()*other._head.getY().getCoordinate())+(_head.getZ().getCoordinate()*other._head.getZ().getCoordinate());

    }



    //ToString
    @Override
    public String toString() {
        return ""+ this.getHead();
    }
}
