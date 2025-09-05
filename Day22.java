import java.util.*;

public class FirstElementKTimes {
    public static int firstElementKTimes(int[] arr, int k) {
        Map<Integer, Integer> freq = new HashMap<>();

        // Step 1: Count frequencies
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Step 2: Traverse again in order
        for (int num : arr) {
            if (freq.get(num) == k) {
                return num;
            }
        }

        return -1; // If no element found
    }

    public static void main(String[] args) {
        // Test cases
        int[] arr1 = {3, 1, 4, 4, 5, 2, 6, 1, 4};
        System.out.println(firstElementKTimes(arr1, 2)); // Output: 1

        int[] arr2 = {2, 3, 4, 2, 2, 5, 5};
        System.out.println(firstElementKTimes(arr2, 2)); // Output: 5

        int[] arr3 = {1, 1, 1, 1};
        System.out.println(firstElementKTimes(arr3, 1)); // Output: -1

        int[] arr4 = {10};
        System.out.println(firstElementKTimes(arr4, 1)); // Output: 10

        int[] arr5 = {6, 6, 6, 6, 7, 7, 8, 8, 8};
        System.out.println(firstElementKTimes(arr5, 3)); // Output: 8
    }
}
