package Stack;

import java.util.Scanner;
import java.util.Stack;

public class PostfixEvaluator {
    public static void main(String[] args) {
        Scanner expressionScanner = new Scanner("1 2 3 * + 10 -");
        // create a new stack
        Stack<Double> values = new Stack<Double>();
        double leftOperand, rightOperand, result;
        while (expressionScanner.hasNext()) {
            String token = expressionScanner.next();
            switch (token) {
                case "+":
                    rightOperand = values.pop();
                    leftOperand = values.pop();
                    result = leftOperand + rightOperand;
                    values.push(result);
                    break;
                case "-":
                    rightOperand = values.pop();
                    leftOperand = values.pop();
                    result = leftOperand - rightOperand;
                    values.push(result);
                    break;
                case "*":
                    rightOperand = values.pop();
                    leftOperand = values.pop();
                    result = leftOperand * rightOperand;
                    values.push(result);
                    break;
                case "/":
                    rightOperand = values.pop();
                    leftOperand = values.pop();
                    result = leftOperand / rightOperand;
                    values.push(result);
                    break;
                default:
                    // numerical value
                    values.push(Double.valueOf(token));
            }
        }
        System.out.println(values.pop());
    }
}
