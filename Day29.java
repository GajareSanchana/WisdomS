import java.util.*;

public class FibonacciOptimized {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(fibonacci(n));
    }

    // Space-optimized DP approach
    public static java.math.BigInteger fibonacci(int n) {
        if (n == 0) return java.math.BigInteger.ZERO;
        if (n == 1) return java.math.BigInteger.ONE;

        java.math.BigInteger prev2 = java.math.BigInteger.ZERO; // F(0)
        java.math.BigInteger prev1 = java.math.BigInteger.ONE;  // F(1)
        java.math.BigInteger current = java.math.BigInteger.ZERO;

        for (int i = 2; i <= n; i++) {
            current = prev1.add(prev2);  // F(n) = F(n-1) + F(n-2)
            prev2 = prev1;  // shift forward
            prev1 = current;
        }

        return current;
    }
}
