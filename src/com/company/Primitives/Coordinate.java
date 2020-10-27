package com.company.Primitives;

public class Coordinate {
    protected double _coordinate;

    //constructors
    public Coordinate(double coordinate) {
        this._coordinate = coordinate;
    }

    public Coordinate() {
        this._coordinate = 0.0;
    }

    //getters
    public double getCoordinate() {
        return _coordinate;
    }

    //setters
    public void setCoordinate(double coordinate) {
        this._coordinate = coordinate;
    }

//    @Override
//    public boolean equals(Object other) {
//        return (this.coordinate ==((Coordinate)other).getCoordinate());
//    }


    //ToString
    @Override
    public String toString() {
        return "Coordinate is " + _coordinate;
    }
}
