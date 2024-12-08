package Exercise_2;

import java.util.ArrayList;
import java.util.Arrays;

public class Task4 {
    static String Greeting(String name) {
        return "Hello " + name + "! How are you?";
    }

    public static void main(String[] args) {
        int a = 3;
        int b = 5;
        String c = "5";
        System.out.println(a+b+c);
        System.out.println(c+b+a);

        String greeting = Greeting((args.length > 0 && args[0] != null) ? args[0] : "Willi");
        System.out.println(greeting);

        Vector vec = new Vector(new ArrayList<>(Arrays.asList(1.5, 3.6, 2.9, 6.7, 8.8)));
        System.out.println(vec.Length());
    }
}

class Vector {
    private final ArrayList<Double> coordinates;

    public Vector(ArrayList<Double> coordinates) {
        this.coordinates = coordinates;
    }

    public Double Length() {
        double length = 0;
        for (Double coordinate : coordinates) {
            length += Math.pow(coordinate, 2);
        }
        return Math.sqrt(length);
    }
}