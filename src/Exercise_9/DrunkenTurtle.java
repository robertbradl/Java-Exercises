package Exercise_9;

public class DrunkenTurtle extends Turtle {
    public DrunkenTurtle(double x, double y, double a) {
        super(x, y, a);
    }

    private void turnRandom(){
        turnLeft(Math.random()*360);
    }

    public void randomWalk(double l){
        turnRandom();
        goForward(l);
    }
}
