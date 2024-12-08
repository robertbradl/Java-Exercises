package Exercise_5;

import java.util.Random;

public class Task4 {
    public static void main(String[] args) {
        CellularAutomaton automaton = new CellularAutomaton(10, 10, 0.5);

        // Initialize and iterate the automaton
        automaton.initializeAndIterate();

        // Display the field
        automaton.displayField();

        // Calculate and display entropy
        double entropy = automaton.calculateEntropy();
        System.out.println("Entropy: " + entropy);
    }
}

class CellularAutomaton {
    private final boolean[][] C;
    private final double p;
    private final Random random = new Random();

    // Task a,b:
    public CellularAutomaton(int m, int n, double p) {
        this.C = new boolean[m][n];
        this.p = p;
    }

    // Task c: Randomly initialize i-th row of the field with true/false values
    public void randomInitializeRow(int i) {
        for (int j = 0; j < C[i].length; j++) {
            C[i][j] = random.nextBoolean();
        }
    }

    // Task d: Initialize the i-th row of the field with true/false values based on probability p
    public void initializeRow(int i) {
        for (int j = 0; j < C[i].length; j++) {
            C[i][j] = random.nextDouble() < p;
        }
    }

    // Task d: Initialize the entire field with true/false values based on probability p
    public void initializeField() {
        for (int i = 0; i < C.length; i++) {
            initializeRow(i);
        }
    }

    // Task e: Display the field as text
    public void displayField() {
        for (boolean[] row : C) {
            for (boolean cell : row) {
                System.out.print(cell ? "1 " : "0 ");
            }
            System.out.println();
        }
    }

    // Task f: Update the i-th row based on the function f and the previous row
    public void updateRow(int i) {
        int n = C[i].length;
        for (int k = 0; k < n; k++) {
            boolean left = C[i - 1][(n + k - 1) % n];
            boolean center = C[i - 1][k];
            boolean right = C[i - 1][(k + 1) % n];
            C[i][k] = f(left, center, right);  // Applying rule function f
        }
    }

    // Task g: The number of possible functions f for 3 boolean inputs
    // There are 2^(2^3) = 256 possible functions.

    // Task h: Initialize the 0-th row randomly, and the rest iteratively using function f
    public void initializeAndIterate() {
        initializeRow(0);  // Initialize 0-th row randomly
        for (int i = 1; i < C.length; i++) {
            updateRow(i);  // Iteratively fill each row
        }
    }

    // Task 9: Define an "interesting" function f (example: XOR-like behavior)
    private boolean f(boolean left, boolean center, boolean right) {
        return left ^ (center || right);
    }

    // Task 10: Calculate entropy H(p) of the field
    public double calculateEntropy() {
        int trueCount = 0, totalCount = 0;
        for (boolean[] row : C) {
            for (boolean cell : row) {
                if (cell) trueCount++;
                totalCount++;
            }
        }
        double p1 = (double) trueCount / totalCount;
        double p0 = 1 - p1;
        return -(p0 * log2(p0) + p1 * log2(p1));
    }

    // Helper function for logarithm base 2
    private double log2(double value) {
        return value == 0 ? 0 : Math.log(value) / Math.log(2);
    }
}