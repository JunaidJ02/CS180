/**
 * Homework 8 -- Sphere Class
 *
 * This is the Sphere class of homework 8
 *
 * @author Junaid Javed, javedj@purdue.edu
 * @version October 21, 2019
 *
 */
public class Sphere implements ThreeDimensionalShape {

    private String name;
    private double radius;
    private double thickness;

    Sphere(double radius, double thickness) throws UnexpectedSideLengthException {
        if (radius < 0.0 || thickness < 0.0) {
            throw new UnexpectedSideLengthException();
        } else {
            if (thickness == 0.0) name = "Sphere";
            if (thickness > 0.0) name = "Ball";
            this.radius = radius;
            this.thickness = thickness;
        }
    }

    public double getSideLength() {
        return 0;
    }

    public double calculateVolume() {
        return (((4.0 / 3.0) * Math.PI) * Math.pow(radius, 3));
    }

    public double calculateSurfaceArea() {
        return 4 * Math.PI * Math.pow(radius, 2);
    }

    public String getName() {
        return name;
    }

    public int getNumSides() {
        return 0;
    }

    public double calculatePerimeter() {
        return 0;
    }

    public double getRadius() {
        return radius;
    }

    public double getThickness() {
        return thickness;
    }

    public boolean equals(Object o) {
        Sphere sphere = (Sphere) (o);
        return (this.radius == sphere.radius &&
                this.thickness == sphere.thickness &&
                this.name.equals(sphere.name));
    }

    public String toString() {
        return (String.format("Sphere[%.2f, %.2f, %s, %.2f, %.2f]",
                getRadius(), getThickness(), getName(),
                calculateVolume(), calculateSurfaceArea()));
    }
}
