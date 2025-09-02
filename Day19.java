import java.util.*;

public class PostfixEvaluator {
    public static int evaluatePostfix(String expression) {
        Deque<Integer> stack = new ArrayDeque<>();
        String[] tokens = expression.split(" ");

        for (String token : tokens) {
            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a - b);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    int divisor = stack.pop();
                    int dividend = stack.pop();
                    stack.push(dividend / divisor); // truncates toward zero
                    break;
                default:
                    stack.push(Integer.parseInt(token)); // operand
            }
        }
        return stack.pop();
    }

    // Test
    public static void main(String[] args) {
        System.out.println(evaluatePostfix("2 1 + 3 *"));       // 9
        System.out.println(evaluatePostfix("5 6 +"));           // 11
        System.out.println(evaluatePostfix("-5 6 -"));          // -11
        System.out.println(evaluatePostfix("15 7 1 1 + - / 3 * 2 1 1 + + -")); // 5
        System.out.println(evaluatePostfix("5"));               // 5
    }
}
