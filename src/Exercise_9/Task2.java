package Exercise_9;

public class Task2 {
    public static void main(String[] args) {
        multiWalk(20,1.5);
    }

    public static void multiWalk(int walks, double step) {
        DrunkenTurtle drunkenTurtle = new DrunkenTurtle(randomCoord(), randomCoord(), randomAngle());
        for (int i = 0; i <= walks; i++) {
            drunkenTurtle.setX(randomCoord());
            drunkenTurtle.setY(randomCoord());
            drunkenTurtle.setAngle(randomAngle());
            drunkenTurtle.goForward(step);
        }
    }

    private static double randomCoord() {
        return Math.random() * 10;
    }

    private static double randomAngle() {
        return Math.random() * 360;
    }
}

