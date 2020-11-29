package exercise9;

import java.lang.Math.*;

public class Ellipse {
  private Point startPoint;
    private double semiaxisA;
    private double semiaxisB;

    public Ellipse() {
        startPoint = new Point(0, 0);
        semiaxisA = 1;
        semiaxisB = 1;
    }

    public Ellipse(Point startPoint, double semiaxisA, double semiaxisB) {
        this.startPoint = new Point(startPoint);
        this.semiaxisA = semiaxisA;
        this.semiaxisB = semiaxisB;
    }

    public Ellipse(Ellipse otherEllipse) {
        startPoint = new Point(otherEllipse.startPoint);
        semiaxisA = otherEllipse.semiaxisA;
        semiaxisB = otherEllipse.semiaxisB;
    }

    public boolean isValid() {
        return semiaxisA > 0 && semiaxisB > 0;
    }

    public void initialize() {
        do {
            System.out.println("Start point: ");
            startPoint.initialize();
            System.out.print("Enter A: ");
            semiaxisA = Utils.INPUT.nextDouble();
            System.out.print("Enter B: ");
            semiaxisB = Utils.INPUT.nextDouble();
        } while (!isValid());
    }

    public double calculatePerimeter() {
        return Math.PI * (3*(semiaxisA + semiaxisB)-Math.sqrt(((3*semiaxisA)+ semiaxisB)*(semiaxisA + (3*semiaxisB))));
    }

    public double calculateArea() {
        return Math.PI * semiaxisA * semiaxisB;
    }

    public String getType() {
        return (semiaxisA == semiaxisB) ? "Cycle" : "Ellipse";
    }

    public String toString() {
        return String.format("%s-[%s, %s], %s, P=%s, A=%s", startPoint, semiaxisA, semiaxisB, getType(), calculatePerimeter(), calculateArea());
    }

    public boolean equal(Ellipse otherEllipse) {
        boolean sameSemiaxisA = Utils.equals(semiaxisA, otherEllipse.semiaxisA);
        boolean sameSemiaxisB = Utils.equals(semiaxisB, otherEllipse.semiaxisB);
        boolean sameSemiaxisAReversed = Utils.equals(semiaxisA, otherEllipse.semiaxisB);
        boolean sameSemiaxisBReversed = Utils.equals(semiaxisB, otherEllipse.semiaxisA);

        return (sameSemiaxisA && sameSemiaxisB) || (sameSemiaxisAReversed && sameSemiaxisBReversed);
    }
}
