package Exercise_2;

public class Task5 {
    public static void main(String[] args) {
        Snowflake flake = new Snowflake(4);
        System.out.println(flake.Commands());
    }
}

class Snowflake{
    private final int iterations;

    public Snowflake(int iterations) {
        this.iterations = iterations;
    }

    public String Commands(){
        String start = "FLFRRFLF";
        String end = start;

        for (int i = 1; i < iterations; i++) {
            String current = "";
            for (int j = 0; j < end.length(); j++) {
                if (end.charAt(j) == 'F') {
                    current += start;
                } else {
                    current += current.charAt(j);
                }
            }
            end = current;
        }

        return end;
    }
}