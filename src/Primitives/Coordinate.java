package Primitives;

public class Coordinate {
    protected double _coordinate;

    public Coordinate(double coordinate) {
        this._coordinate = coordinate;
    }

    public Coordinate() {
        this._coordinate = 0.0;
    }

    public Coordinate(Coordinate otherCoordinate) {
        this._coordinate = otherCoordinate.getCoordinate();
    }

    public double getCoordinate() {
        return _coordinate;
    }

    public void setCoordinate(double _coordinate) {
        this._coordinate = _coordinate;
    }

    @Override
    public boolean equals(Object other) {
        return (this._coordinate ==((Coordinate)other).getCoordinate());
    }

    @Override
    public String toString() {
        return ""+_coordinate;
    }
}
