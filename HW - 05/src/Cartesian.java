public class Cartesian extends Polar{
    private double x;
    private double y;

    public static void main(String[] args) {

    }

    public Cartesian() {
        x = 0.0;
        y = 0.0;
    }

    public Cartesian(double x, double y) {
        x = this.x;
        y = this.y;

    }


    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getDistance(Cartesian cartesian){
        return Math.sqrt(Math.pow(cartesian.getX() - x, 2.0) + Math.pow(cartesian.getY() - y, 2.0));
    }

    public Polar toPolar() {
        double r = Math.sqrt(Math.pow(x, 2.0) + Math.pow(y, 2.0));
        double theta = Math.atan2(y, x);
        return new Polar(r, theta);
    }

    public String toString() {
        System.out.println(String.format("%.6g%n", x) + ", " + String.format("%.6g%n", y));
    }
}