import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class StreamAverageTest {

    @Test
    void average() {

        StreamAverage solution = new StreamAverage();
        List<Integer> testIntegers = List.of(9, 8, 7, 6, 5, 4, 3, 2, 1, 0);
        assertEquals(4.5, solution.average(testIntegers));
        assertEquals(0, solution.average(null));
        assertNotEquals(6, solution.average(testIntegers));
        assertNotEquals(1, solution.average(null));

    }

    @Test
    void upperCase() {

        StreamAverage solution = new StreamAverage();
        List<String> testString = List.of("j", "n", "f", "h", "i");

        assertEquals(new Pair("j", "J"), solution.upperCase(testString).get(0));
        assertEquals(new Pair("n", "N"), solution.upperCase(testString).get(1));
        assertEquals(new Pair("f", "F"), solution.upperCase(testString).get(2));
        assertEquals(new Pair("h", "H"), solution.upperCase(testString).get(3));
        assertEquals(new Pair("i", "I"), solution.upperCase(testString).get(4));
        assertNotNull(solution.upperCase(testString));
        assertNull(solution.upperCase(null));

    }

    @Test
    void filter() {

        StreamAverage solution = new StreamAverage();
        List<String> testString = List.of("Red", "hand", "sMart", "hIGh", "orange", "language");

        assertTrue(solution.filter(testString));
        assertFalse(solution.filter(null));

    }
}
