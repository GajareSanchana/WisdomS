import java.util.Stack;

public class SortStackRecursionAlt {

    // Function to sort the stack
    public static void sortStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        // Remove the top element
        int top = stack.pop();

        // Recursively sort the remaining stack
        sortStack(stack);

        // Insert the popped element back into the sorted stack
        sortedInsert(stack, top);
    }

    // Recursive function to insert element in correct place
    private static void sortedInsert(Stack<Integer> stack, int value) {
        // If stack empty OR value should be placed at the top
        if (stack.isEmpty() || stack.peek() <= value) {
            stack.push(value);
        } else {
            int temp = stack.pop();
            sortedInsert(stack, value);
            stack.push(temp);
        }
    }

    // Driver Code
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(7);
        stack.push(1);
        stack.push(5);

        System.out.println("Original Stack: " + stack);

        sortStack(stack);

        System.out.println("Sorted Stack: " + stack);
    }
}
