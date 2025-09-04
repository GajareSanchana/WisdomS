import java.util.Stack;

public class ReverseStack {

    // Recursive function to reverse stack
    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        // Pop the top element
        int top = stack.pop();

        // Reverse the remaining stack
        reverse(stack);

        // Insert current element at bottom (inline logic)
        insertAtBottom(stack, top);
    }

    // Helper to insert an element at the bottom
    private static void insertAtBottom(Stack<Integer> stack, int x) {
        if (stack.isEmpty()) {
            stack.push(x);
            return;
        }
        int temp = stack.pop();
        insertAtBottom(stack, x);
        stack.push(temp);
    }

    // Main driver
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        System.out.println("Original Stack: " + stack);

        reverse(stack);

        System.out.println("Reversed Stack: " + stack);
    }
}
