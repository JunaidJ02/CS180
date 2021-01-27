/**
 * Homework 8 -- Cube Class
 *
 * This is the Cube class of homework 8
 *
 * @author Junaid Javed, javedj@purdue.edu
 * @version October 21, 2019
 *
 */
public class Cube implements ThreeDimensionalShape {

    private String name;
    private double sideLength;

    public Cube(double sideLength) throws UnexpectedSideLengthException {
        name = "Cube";
        if (sideLength < 0.0) {
            throw new UnexpectedSideLengthException();
        } else {
            this.sideLength = sideLength;
        }
    }

    public double getSideLength() {
        return sideLength;
    }

    public double calculateVolume() {
        return Math.pow(sideLength, 3);
    }

    public double calculateSurfaceArea() {
        return 6 * Math.pow(sideLength, 2);
    }

    public String getName() {
        return name;
    }

    public int getNumSides() {
        return 6;
    }

    public double calculatePerimeter() {
        return 12 * sideLength;
    }

    public boolean equals(Object o) {
        Cube cube = (Cube)(o);
        return (sideLength == cube.getSideLength() &&
                name.equals(cube.getName()));
    }

    public String toString() {
        return (String.format("Cube[%.2f, %.2f, %.2f, %.2f]",
                sideLength, calculatePerimeter(),
                calculateVolume(), calculateSurfaceArea()));
    }
}
