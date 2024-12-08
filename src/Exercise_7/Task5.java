package Exercise_7;

public class Task5 {
    public static void main(String[] args) {
        IntPair p1 = new IntPair(1, 2);
        IntPair p2 = p1.swap();

        IntPairPair pp1 = new IntPairPair(p1, p2);
        IntPairPair pp2 = pp1.swap();

        System.out.println("Pair 1: " + p1 + "; Pair 2: " + p2);
        System.out.println("PairPair 1: " + pp1 + "; PairPair 2: " + pp2);
    }
}

record IntPairPair(IntPair first, IntPair second){
    public IntPairPair swap(){
        return new IntPairPair(second, first);
    }

    @Override
    public String toString() {
        return "[" + first + ", " + second + "]";
    }
}