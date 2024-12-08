package Exercise_7;

public class Task4 {
    public static void main(String[] args) {
        IntPair p1 = new IntPair(1, 2);
        IntPair p2 = p1.swap();

        System.out.println(p1);
        System.out.println(p2);
    }
}

record IntPair(int first, int second) {
    public IntPair swap() {
        return new IntPair(second, first);
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}