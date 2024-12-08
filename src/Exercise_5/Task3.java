package Exercise_5;

public class Task3 {
    public static void main(String[] args) {
        int n = 0;
        try {
            n = (args.length > 0 && args[0] != null) ? Integer.parseInt(args[0]) : 15;
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid integer!");
            System.exit(0);
        }

        int fibK = calcFibo(n);
        System.out.println("The Fibonacci-number corresponding to " + n + " is " + fibK + ".");
    }

    public static int calcFibo(int k) {
        if (k == 0)
            return 0;
        if (k == 1)
            return 1;
        return calcFibo(k-1) + calcFibo(k-2);
    }
}
