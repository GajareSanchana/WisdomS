import java.util.*;

public class MissingNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array (n): ");
        int n = sc.nextInt();

        // create array of size n-1 (since one number is missing)
        int arr[] = new int[n - 1];
        System.out.println("Enter " + (n - 1) + " elements:");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        long expectedSum = (long) n * (n + 1) / 2; // sum of 1 to n
        long actualSum = 0;
        for (int i = 0; i < arr.length; i++) {
            actualSum += arr[i];
        }

        long missingNumber = expectedSum - actualSum;
        System.out.println("Missing number is: " + missingNumber);
    }
}
