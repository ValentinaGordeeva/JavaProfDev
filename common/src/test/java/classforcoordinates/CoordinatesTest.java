package classforcoordinates;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoordinatesTest {

    @Test
    void testToString() {
        String item = "[42.47788551372969,43.266325763217,2353,4],0";
        Coordinates coordinates = new Coordinates();
        coordinates.setIthem(item);
        String expectedString = "Coordinates{" + item + "}";
        String actualString = coordinates.toString();
        assertEquals(expectedString, actualString);
    }
}