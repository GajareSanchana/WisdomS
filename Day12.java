public class Solution3 {
    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 != 0) return false;  // odd length can't be valid

        char[] arr = new char[n]; // manual stack
        int top = -1;

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                arr[++top] = c; // push
            } else {
                if (top == -1) return false; // nothing to match
                char open = arr[top--]; // pop

                if ((c == ')' && open != '(') ||
                    (c == '}' && open != '{') ||
                    (c == ']' && open != '[')) {
                    return false; // mismatch
                }
            }
        }
        return top == -1; // valid only if all matched
    }

    // Testing
    public static void main(String[] args) {
        Solution3 sol = new Solution3();
        System.out.println(sol.isValid("()"));      // true
        System.out.println(sol.isValid("([)]"));    // false
        System.out.println(sol.isValid("[{()}]"));  // true
        System.out.println(sol.isValid(""));        // true
        System.out.println(sol.isValid("{[}"));     // false
    }
}
