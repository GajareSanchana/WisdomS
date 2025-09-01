import java.util.Scanner;

public class DivisorCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();  // N can be large, so use long
        sc.close();

        System.out.println(countDivisors(N));
    }

    public static int countDivisors(long n) {
        int count = 0;
        for (long i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                if (i == n / i) {
                    count++; // perfect square divisor
                } else {
                    count += 2; // both i and n/i
                }
            }
        }
        return count;
    }
}
