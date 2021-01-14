package Geometries;
import Primitives.Material;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;
import java.awt.Color;

import java.util.List;

public abstract class Geometry {
    protected Color _emission;
    protected Material _material;

    public abstract List<GeoPoint> findIntersections(Ray ray);
    public abstract Vector getNormal(Point3D point);
    public abstract Color getEmission();
    public abstract Material getMaterial();
    public abstract void setMaterial(Material material);
}
