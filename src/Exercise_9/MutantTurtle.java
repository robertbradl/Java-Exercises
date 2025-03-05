package Exercise_9;

import java.util.Stack;

public class MutantTurtle extends DrunkenTurtle{
    Stack<TurtleState> history = new Stack<>();
    public MutantTurtle(double x, double y, double a) {
        super(x, y, a);
    }

    public void push(){
        this.history.push(new TurtleState(this.x, this.y, this.angle));
    }

    public void pop(){
        if (!this.history.isEmpty()){
            setTurtle(this.history.pop());
        }
    }

    private void setTurtle(TurtleState state){
        this.x = state.x();
        this.y = state.y();
        this.angle = state.angle();
    }
}

