package Scene;
import Geometries.*;

import java.util.ArrayList;
import java.util.List;

public class Scene {
    protected String _name;
    protected ArrayList<Geometry> _geometries;

    //constructors
    public Scene(String _name,ArrayList<Geometry> _geometries) {
        this._name = _name;
        this._geometries = _geometries;
    }

    public Scene() {
        this._name = "Unknown";
        this._geometries = new ArrayList<Geometry>();
    }

    public Scene(Scene otherScene) {
        this._geometries = otherScene.getGeometries();
    }

    //setters
    public void setGeometries(ArrayList<Geometry> _geometries) {
        this._geometries = _geometries;
    }


    public void setName(String name) {
        this._name = name;
    }

    //getters
    public ArrayList<Geometry> getGeometries() {
        ArrayList<Geometry> newList = new ArrayList<Geometry>();
        newList.addAll(_geometries);
        return newList;
    }

    public String getName() {
        return _name;
    }

    public void addGeometry(Geometry newGeometry) {
        _geometries.add(newGeometry);
    }

    //equals method
    @Override
    public boolean equals(Object otherScene) {
        return this._geometries.equals(((Scene)otherScene).getGeometries())&&this._name.equals(((Scene) otherScene).getName());
    }

    @Override
    public String toString() {
        return getName() + " " + _geometries;
    }
}
