package com.company.Primitives;

public class Coordinate {
    double coordinate;

    public Coordinate(double coordinate) {
        this.coordinate = coordinate;
    }

    public Coordinate() {
        this.coordinate = 0.0;
    }

    public double getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(double coordinate) {
        this.coordinate = coordinate;
    }

//    @Override
//    public boolean equals(Object other) {
//        return (this.coordinate ==((Coordinate)other).getCoordinate());
//    }

    @Override
    public String toString() {
        return "Coordinate is " + coordinate;
    }
}
