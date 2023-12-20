import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class tests {

    @Test
    public void divisionTest() {
        SolutionPolish dividePolish = new SolutionPolish("10 / 2");
        try {
            assertEquals("division short test", 5, dividePolish.evalData());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void multiplicationTest() {
        SolutionPolish dividePolish = new SolutionPolish("10 * 5");
        try {
            assertEquals("multiplication short test", 50, dividePolish.evalData());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void AdditionnTest() {
        SolutionPolish Add = new SolutionPolish("10 + 5");
        try {
            assertEquals("Addition short test", 15, Add.evalData());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void subtrationTest() {
        SolutionPolish sub = new SolutionPolish("10 - 5");
        try {
            assertEquals("subtraction short test", 5, sub.evalData());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    /* making a test for an edge case with a bunch of spaces */
    public void EdgeTest() {
        SolutionPolish edge = new SolutionPolish("6 10 *    5     -");
        try {
            assertEquals("Edge test", 55, edge.evalData());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    /* making a test for a long problem */
    public void LongTest() {
        SolutionPolish Long = new SolutionPolish("3 20 (6 10 *) -  *");
        try {
            assertEquals("Edge test", -120, Long.evalData());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
