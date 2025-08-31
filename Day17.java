import java.util.*;

public class PrimeFactorization {
    
    public static List<Integer> primeFactorization(long N) {
        List<Integer> factors = new ArrayList<>();
        
        // Step 1: Handle factor 2
        while (N % 2 == 0) {
            factors.add(2);
            N /= 2;
        }
        
        // Step 2: Check odd factors from 3 to √N
        for (long i = 3; i * i <= N; i += 2) {
            while (N % i == 0) {
                factors.add((int) i);
                N /= i;
            }
        }
        
        // Step 3: If N is still > 1, it is a prime factor
        if (N > 1) {
            factors.add((int) N);
        }
        
        return factors;
    }
    
    public static void main(String[] args) {
        // Test Cases
        System.out.println(primeFactorization(18));      // [2, 3, 3]
        System.out.println(primeFactorization(30));      // [2, 3, 5]
        System.out.println(primeFactorization(49));      // [7, 7]
        System.out.println(primeFactorization(19));      // [19]
        System.out.println(primeFactorization(64));      // [2, 2, 2, 2, 2, 2]
        System.out.println(primeFactorization(123456));  // [2, 2, 2, 2, 2, 3, 643]
    }
}
