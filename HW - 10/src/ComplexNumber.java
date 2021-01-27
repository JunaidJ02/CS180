import java.text.DecimalFormat;

/**
 * Homework 10 -- ComplexNumber Class
 *
 * This is the ComplexNumber class of homework 10
 *
 * @author Junaid Javed, javedj@purdue.edu
 * @version October 28, 2019
 *
 */
public class ComplexNumber implements Comparable<ComplexNumber> {
    private double re;
    private double im;

    public ComplexNumber() {
        re = 0.0;
        im = 0.0;
    }

    public ComplexNumber(ComplexNumber complexNumber) {
        if (complexNumber == null) throw new IllegalArgumentException();
        this.re = complexNumber.re;
        this.im = complexNumber.im;
    }

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public synchronized double getRe() {
        return re;
    }

    public synchronized double getIm() {
        return im;
    }

    public synchronized void setRe(double re) {
        this.re = re;
    }

    public synchronized void setIm(double im) {
        this.im = im;
    }

    public synchronized ComplexNumber conjugate() {
        return new ComplexNumber(re, -im);
    }

    public synchronized ComplexNumber reciprocal() {
        return new ComplexNumber(re / (Math.pow(re, 2) + Math.pow(im, 2)),
                -(im / (Math.pow(re, 2) + Math.pow(im, 2))));
    }

    public synchronized ComplexNumber add(ComplexNumber complexNumber) {
        if (complexNumber == null) throw new IllegalArgumentException();
        return new ComplexNumber(re + complexNumber.re, (im + complexNumber.im));
    }

    public synchronized ComplexNumber subtract(ComplexNumber complexNumber) {
        if (complexNumber == null) throw new IllegalArgumentException();
        return new ComplexNumber(re - complexNumber.re, (im - complexNumber.im));
    }

    public synchronized ComplexNumber multiply(ComplexNumber complexNumber) {
        if (complexNumber == null) throw new IllegalArgumentException();

        double a = re;
        double b = im;
        double c = complexNumber.re;
        double d = complexNumber.im;

        return new ComplexNumber(a * c - b * d, b * c + a * d);
    }

    public synchronized ComplexNumber divide(ComplexNumber complexNumber) {
        if (complexNumber == null) throw new IllegalArgumentException();

        double a = re;
        double b = im;
        double c = complexNumber.re;
        double d = complexNumber.im;

        return new ComplexNumber((a * c + b * d) / (Math.pow(c, 2) + Math.pow(d, 2)),
                (b * c - a * d) / (Math.pow(c, 2) + Math.pow(d, 2)));
    }

    public synchronized int compareTo(ComplexNumber complexNumber) {
        if (complexNumber == null || re < complexNumber.re) return -1;
        if (re > complexNumber.re) return 1;
        if (re == complexNumber.re) {
            if (im > complexNumber.im) return 1;
            if (im < complexNumber.im) return -1;
        }

        return 0;
    }

    public synchronized boolean equals(Object object) {
        if (object instanceof ComplexNumber) {
            ComplexNumber complexNumber = (ComplexNumber) object;
            return (re == complexNumber.re && im == complexNumber.im);
        }

        return false;
    }

    public synchronized String toString() {
        DecimalFormat df = new DecimalFormat("#0.000000");
        if (im < 0) {
            return df.format(re) + " - " + df.format(-im) + "i";
        }

        return df.format(re) + " + " + df.format(im) + "i";

    }
}
