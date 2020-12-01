package Primitives;

public class Coordinate {
    protected double _coordinate;

    //constructors
    public Coordinate(double coordinate) {
        this._coordinate = coordinate;
    }

    public Coordinate() {
        this._coordinate = 0.0;
    }

    public Coordinate(Coordinate otherCoordinate) {
        this._coordinate = otherCoordinate._coordinate;
    }

    //getters
    public double getCoordinate() {
        return _coordinate;
    }

    //setters
    public void setCoordinate(double _coordinate) {
        this._coordinate = _coordinate;
    }

    @Override
    public boolean equals(Object other) {
        return Util.isZero(_coordinate - ((Coordinate)other)._coordinate);
    }

    @Override
    public String toString() {
        return ""+_coordinate;
    }
}
