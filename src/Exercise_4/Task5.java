package Exercise_4;

import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task5 {
    public static void main(String[] args) {
        int n = 0;
        try {
            n = (args.length > 0 && args[0] != null) ? Integer.parseInt(args[0]) : 7;
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid integer!");
            System.exit(0);
        }

        int []numbers = genArray(n);
        System.out.println(Arrays.toString(numbers));

        int biggest = findBiggest(numbers);
        System.out.println("The biggest number is: " + biggest);

        List<Integer> occur = findOccur(biggest, numbers);
        System.out.println("The number is found at the following indexes: " + occur);

        int []numbers2 = numbers.clone();
        gnomeSort(numbers2);
        System.out.println(Arrays.toString(numbers2));

    }

    public static int[] genArray(int n) {
        Random random = new Random();
        return random.ints(n, 1, 50).toArray();
    }

    public static int findBiggest(int [] array) {
        int biggest = array[0];
        for (int x = 1; x < array.length; x++){
            if (biggest < array[x])
                biggest = array[x];
        }
        return biggest;
    }

    public static List<Integer> findOccur(int n, int[] array) {
        List<Integer> index = new ArrayList<>();
        for (int x = 0; x < array.length; x++){
            if (n == array[x])
                index.add(x);
        }
        return index;
    }

    public static void gnomeSort(int[] array) {
        int index = 0;
        while (index < array.length) {
            if (index == 0 || array[index - 1] <= array[index]) {
                index++;
            } else {
                int temp = array[index];
                array[index] = array[index - 1];
                array[index - 1] = temp;
                index--;
            }
        }
    }
}
