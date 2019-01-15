/**
 * TestPlanet
 */
public class TestPlanet {
    public static void main(String[] args) {
        checkCalcForceExertedBy();
    }

    /**
     * Checks whether or not two Doubles are equal and prints the result.
     *
     * @param expected Expected double
     * @param actual   Double received
     * @param label    Label for the 'test' case
     * @param eps      Tolerance for the double comparison.
     */
    private static void checkEquals(double actual, double expected, String label, double eps) {
        if (Math.abs(expected - actual) <= eps * Math.max(expected, actual)) {
            System.out.println("PASS: " + label + ": Expected " + expected + " and you gave " + actual);
        } else {
            System.out.println("FAIL: " + label + ": Expected " + expected + " and you gave " + actual);
        }
    }

    /**
     * Checks the Planet class to make sure calcForceExertedBy works.
     */
    private static void checkCalcForceExertedBy() {
        System.out.println("Checking the Planet class...");

        Planet p1 = new Planet(1.0, 0, 3.0, 4.0, 10, "jupiter.gif");
        Planet p2 = new Planet(5.0, -3.0, 3.0, 4.0, 50, "jupiter.gif");

        checkEquals(p1.calcForceExertedBy(p2), 1.334E-9, "calcForceExertedBy()", 0.01);
    }

}