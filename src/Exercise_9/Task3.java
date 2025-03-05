package Exercise_9;

public class Task3 {
    public static void main(String[] args) {
        MutantTurtle mutantTurtle = new MutantTurtle(0,0,85);
        for (int i = 0; i < 51; i++) {
            double randNum = Math.random();
            mutantTurtle.randomWalk(1.7);
            if (randNum < 0.1) {
                mutantTurtle.push();
            }
            else if (randNum > 0.1 && randNum < 0.2) {
                mutantTurtle.pop();
            }
        }
    }
}
