package Primitives;

public class Coordinate {
    private double _coordinate;

    public Coordinate(double coordinate) {
        this._coordinate = coordinate;
    }

    public Coordinate() {
        this._coordinate = 0.0;
    }

    public Coordinate(Coordinate otherCoordinate) {
        this._coordinate = otherCoordinate.get_coordinate();
    }

    public double get_coordinate() {
        return _coordinate;
    }

    public void set_coordinate(double _coordinate) {
        this._coordinate = _coordinate;
    }

    @Override
    public boolean equals(Object other) {
        return (this._coordinate ==((Coordinate)other).get_coordinate());
    }

    @Override
    public String toString() {
        return ""+_coordinate;
    }
}
