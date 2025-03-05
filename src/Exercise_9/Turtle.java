package Exercise_9;

import edu.princeton.cs.introcs.*;

public class Turtle {
    protected double x, y;
    protected double angle;

    public Turtle(double x, double y, double a) {
        StdDraw.setXscale(-10.1,10.1);
        StdDraw.setYscale(-10.1,10.1);
        this.x = x;
        this.y = y;
        this.angle = a;
    }

    private void debug(){
        // Draw the gridlines
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        for (int i = -10; i <= 10; i++) {
            // Vertical gridlines
            StdDraw.line(i, -10, i, 10);
            // Horizontal gridlines
            StdDraw.line(-10, i, 10, i);
        }
        // Draw the axes
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.line(-10, 0, 10, 0); // X-axis
        StdDraw.line(0, -10, 0, 10); // Y-axis
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setAngle(double a) {
        this.angle = a;
    }

    public void turnLeft(double delta) {
        this.angle = (this.angle + delta) % 360;
        if (this.angle < 0) {
            this.angle += 360;
        }
    }

    public void goForward(double step) {
        StdDraw.setPenColor(StdDraw.BLACK);
        double oldX = x;
        double oldY = y;
        x += step * Math.cos(Math.toRadians(angle));
        y += step * Math.sin(Math.toRadians(angle));
        StdDraw.line(oldX, oldY, x, y);
    }

    private void drawArrowhead(){
        StdDraw.setPenColor(StdDraw.BLUE);

        double arrowLength = 0.5; // Length of the arrowhead
        double arrowAngle = 35;   // Angle of the arrowhead in degrees

        // Left side of arrowhead
        double x1 = x - arrowLength * Math.cos(Math.toRadians(angle + arrowAngle));
        double y1 = y - arrowLength * Math.sin(Math.toRadians(angle + arrowAngle));

        // Right side of arrowhead
        double x2 = x - arrowLength * Math.cos(Math.toRadians(angle - arrowAngle));
        double y2 = y - arrowLength * Math.sin(Math.toRadians(angle - arrowAngle));

        // Draw the arrowhead
        StdDraw.line(x, y, x1, y1);
        StdDraw.line(x, y, x2, y2);
    }
}