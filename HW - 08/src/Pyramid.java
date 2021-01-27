/**
 * Homework 8 -- Pyramid Class
 *
 * This is the Pyramid class of homework 8
 *
 * @author Junaid Javed, javedj@purdue.edu
 * @version October 21, 2019
 *
 */
public class Pyramid implements ThreeDimensionalShape {

    private String name;
    private double length;
    private double height;

    public Pyramid(double length, double height) throws UnexpectedSideLengthException {
        name = "Pyramid";
        if (length < 0.0 || height < 0.0) {
            throw new UnexpectedSideLengthException();
        } else {
            this.length = length;
            this.height = height;
        }
    }

    public double getSideLength() {
        return length;
    }

    private double getHeight() {
        return height;
    }

    public double calculateVolume() {
        return (length * length * height) / 3.0;
    }

    public double calculateSurfaceArea() {
        return length * (length + Math.sqrt(Math.pow(length, 2.0) + (4 * Math.pow(height, 2.0))));
    }

    public String getName() {
        return name;
    }

    public int getNumSides() {
        return 4;
    }

    public double calculatePerimeter() {
        return (4 * (Math.pow(height, 2.0) + (Math.pow(length, 2.0) / 4.0))) + (4 * length);
    }

    public boolean equals(Object o) {
        Pyramid pyramid = (Pyramid) (o);
        return (length == pyramid.getSideLength() &&
                height == pyramid.getHeight() &&
                name.equals(pyramid.getName()));
    }

    public String toString() {
        return (String.format("Pyramid[%.2f, %.2f, %.2f, %.2f, %.2f]",
                length, height, calculatePerimeter(),
                calculateVolume(), calculateSurfaceArea()));
    }
}
