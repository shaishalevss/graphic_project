package Scene;
import Geometries.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Scene {
    protected String name;
    protected List<Geometry> _geometries;

    //constructors
    public Scene(List<Geometry> _geometries) {
        this._geometries = _geometries;
    }

    public Scene() {
        this._geometries = null;
    }

    public Scene(Scene otherScene) {
        this._geometries = otherScene.getGeometries();
    }

    //setters
    public void setGeometries(List<Geometry> _geometries) {
        this._geometries = _geometries;
    }


    public void setName(String name) {
        this.name = name;
    }

    //getters
    public List<Geometry> getGeometries() {
        List<Geometry> newList = new ArrayList<Geometry>();
        newList.addAll(_geometries);
        return newList;
    }

    public String getName() {
        return name;
    }

    public void addGeometry(Geometry newGeometry) {
        _geometries.add(newGeometry);
    }

    //equals method
    @Override
    public boolean equals(Object otherScene) {
        return this._geometries.equals(((Scene)otherScene).getGeometries())&&this.name.equals(((Scene) otherScene).getName());
    }

    @Override
    public String toString() {
        return "" + _geometries;
    }
}
