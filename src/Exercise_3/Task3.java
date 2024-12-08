package Exercise_3;

import java.util.*;

public class Task3 {

    // Operand priority
    // Defines operator precedence for basic arithmetic operators.
    private static final Map<Character, Integer> precedence = new HashMap<>() {{
        put('+', 1); // Addition has lower precedence
        put('-', 1); // Subtraction has lower precedence
        put('*', 2); // Multiplication has higher precedence
        put('/', 2); // Division has higher precedence
    }};

    // Evaluates the order of operations for the given expression
    public static List<String> evaluateOrder(String expression) {
        List<String> order = new ArrayList<>(); // Stores the steps of evaluation in order
        Stack<Character> operators = new Stack<>(); // Stack to store operators
        Stack<String> operands = new Stack<>(); // Stack to store operands (variables)

        // Remove any whitespace from the expression
        expression = expression.replaceAll("\\s+", "");

        // Process each character in the expression
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            // If character is an operand (variable), push it to the operands stack
            if (Character.isLetter(c)) {
                operands.push(String.valueOf(c));
            }
            // If character is an operator, manage precedence and stack operations
            else if (precedence.containsKey(c)) {
                // While the precedence of the current operator is lower or equal to the precedence of the operator on top of the stack, evaluate the top operation
                while (!operators.isEmpty() && precedence.get(c) <= precedence.get(operators.peek())) {
                    extractSub(order, operators, operands); // Process the top of the stack
                }
                operators.push(c); // Push the current operator to the operators stack
            }
        }

        // Evaluate remaining operations in the stack
        while (!operators.isEmpty()) {
            extractSub(order, operators, operands);
        }

        return order; // Return the list of evaluation steps
    }

    // Extracts and evaluates a subexpression, then updates the order list
    private static void extractSub(List<String> order, Stack<Character> operators, Stack<String> operands) {
        String operand2 = operands.pop(); // Pop the second operand
        String operand1 = operands.pop(); // Pop the first operand
        char operator = operators.pop(); // Pop the operator
        // Form a subexpression in the format "(operand1 operator operand2)"
        String subExpression = "(" + operand1 + " " + operator + " " + operand2 + ")";
        operands.push(subExpression); // Push the subexpression back to the operands stack
        order.add(subExpression); // Add the subexpression to the evaluation order list
    }

    // Main method to test the evaluation order function
    public static void main(String[] args) {
        String expression = "a + b * c"; // Example expression

        List<String> order = evaluateOrder(expression); // Get the evaluation order

        System.out.println("Ausdruck: " + expression);
        System.out.println("Auswertungsreihenfolge:");

        // Print each step in the evaluation order
        for (String step : order) {
            System.out.println(step);
        }
    }
}