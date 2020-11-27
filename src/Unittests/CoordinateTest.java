package Unittests;
import Primitives.Coordinate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CoordinateTest {

    @Test
    void emptyCoordinate(){
        Coordinate coor = new Coordinate();
        assertEquals(0.0, coor._coordinate());
    }

    @Test
    void setCoordinate(){
        Coordinate coor = new Coordinate();
        coor.setCoordinate(5.0);
        assertEquals(5.0,coor._coordinate());
    }

    @Test
    void equalsMethod(){
        Coordinate coor1 = new Coordinate(2.0);
        Coordinate coor2 = new Coordinate(3.0);
        assertEquals(false, coor1.equals(coor2));
    }
}