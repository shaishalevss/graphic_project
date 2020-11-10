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
        return new Vector();
    }

    //vector subtraction
    public Vector subtract(){
        return new Vector();
    }

    //multiply vector with scalar
    public Vector scale(double scalar){
        return new Vector(
                new Point3D(
                        new Coordinate(
                                _head.getX().getCoordinate()*scalar),
                        new Coordinate(
                        _head.getY().getCoordinate()*scalar),
                        new Coordinate(
                        _head.getZ().getCoordinate())
                )
        );
    }

    //multiply vector with vector
    public Vector crossProduct(Vector other){
        return new Vector(
                new Point3D(
                        new Coordinate(
                                (_head.getY().getCoordinate()*other._head.getZ().getCoordinate())-(_head.getZ().getCoordinate()*other._head.getY().getCoordinate())),
                        new Coordinate(
                                (_head.getZ().getCoordinate()*other._head.getX().getCoordinate())-(_head.getX().getCoordinate()*other._head.getZ().getCoordinate())),
                        new Coordinate(
                                (_head.getX().getCoordinate()*other._head.getY().getCoordinate())-(_head.getY().getCoordinate()*other._head.getX().getCoordinate()))
                )
        );
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
