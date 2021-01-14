package Primitives;

import Geometries.GeoPoint;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

//import Geometries.Intersectable.GeoPoint;

/**
 * Util class is used for some internal utilities, e.g. controlling accuracy
 *
 * @author Dan
 */
public abstract class Util {
    // It is binary, equivalent to ~1/1,000,000,000,000 in decimal (12 digits)
    private static final int ACCURACY = -40;

    // double store format (bit level): seee eeee eeee (1.)mmmm � mmmm
    // 1 bit sign, 11 bits exponent, 53 bits (52 stored) normalized mantissa
    // the number is m+2^e where 1<=m<2
    // NB: exponent is stored "normalized" (i.e. always positive by adding 1023)
    private static int getExp(double num) {
        // 1. doubleToRawLongBits: "convert" the stored number to set of bits
        // 2. Shift all 52 bits to the right (removing mantissa)
        // 3. Zero the sign of number bit by mask 0x7FF
        // 4. "De-normalize" the exponent by subtracting 1023
        return (int) ((Double.doubleToRawLongBits(num) >> 52) & 0x7FFL) - 1023;
    }

    /**
     * Checks whether the number is [almost] zero
     *
     * @param number
     * @return true if the number is zero or almost zero, false otherwise
     */
    public static boolean isZero(double number) {
        return getExp(number) < ACCURACY;
    }

    /**
     * Aligns the number to zero if it is almost zero
     *
     * @param number
     * @return 0.0 if the number is very close to zero, the number itself otherwise
     */
    public static double alignZero(double number) {
        return getExp(number) < ACCURACY ? 0.0 : number;
    }

    public static Color addColor(Color colorA, Color colorB) {
        int r = colorA.getRed() + colorB.getRed();
        int g = colorA.getGreen() + colorB.getGreen();
        int b = colorA.getBlue() + colorB.getBlue();
        if (r > 255)
            r = 255;
        if (g > 255)
            g = 255;
        if (b > 255)
            b = 255;
        return new Color(r, g, b);
    }

    public static Color vecToColor(Vector vec) {
        double red = vec.getHead().getX().getCoordinate();
        double green = vec.getHead().getY().getCoordinate();
        double blue = vec.getHead().getZ().getCoordinate();

        if (red < 0)
            red = 0;
        else if (red > 255)
            red = 255;
        if (green < 0)
            green = 0;
        else if (green > 255)
            green = 255;
        if (blue < 0)
            blue = 0;
        else if (blue > 255)
            blue = 255;

        return new Color((int) red, (int) green, (int) blue);
    }

    public static Vector colorToVec(Color color) {
        return new Vector(color.getRed(),color.getGreen(),color.getBlue());
    }

    public static List<Point3D> listOf(Point3D... vertices) {
        List<Point3D> lst = new ArrayList<Point3D>();
        for (int i = 0; i < vertices.length; i++)
            lst.add(vertices[i]);
        return lst;
    }

    public static List<GeoPoint> listOf(GeoPoint... vertices) {
        List<GeoPoint> lst = new ArrayList<GeoPoint>();
        for (int i = 0; i < vertices.length; i++)
            lst.add(vertices[i]);
        return lst;
    }
}