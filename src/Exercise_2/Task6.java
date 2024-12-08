package Exercise_2;

public class Task6 {
    public static void main(String[] args) {
        Bridge bridge = new Bridge(4.5, 45.5);

        System.out.println("Amount of pillars: " + bridge.getPillars());
        System.out.println("Volume of the bridge: " + bridge.Volume() + "m^3");
        System.out.println("Concrete needed: " + bridge.getConcreteAmount() + "t");
        System.out.println("Area of the bridge: " + bridge.Area() + "m^2");
        System.out.println("Paint needed (in liters): " + bridge.getPaintAmount() + "l");
    }
}

class Bridge {
    private final double height;
    private final double length;
    private final int pillars;

    public Bridge(double height, double length) {
        this.height = height;
        this.length = length;
        this.pillars = (int) length / 5 + 2;
    }

    public double getConcreteAmount() {
        return this.Volume() * 2.5 / 1000;
    }

    public double getPaintAmount() {
        return this.Area() * 0.1;
    }

    public double Volume() {
        double volume = 0;

        volume += this.pillars * this.height * 3 * 0.5;
        volume += this.length * 3 * 0.25;

        return volume;
    }

    public double Area() {
        double area = 0;
        area += this.length * 0.25 * 2; // Sides
        area += this.length * 3 - this.pillars * 3 * 0.5; // Underside - connecting area of pillars
        area += 7 * this.height * this.pillars; // Pillars ( this.pillars * (0.5 * this.height * 2 + 3 * this.height * 2) )

        return area;
    }

    public double getLength() {
        return length;
    }

    public double getHeight() {
        return height;
    }

    public int getPillars() {
        return pillars;
    }
}
