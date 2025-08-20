import java.util.*;

public class ZeroSumSubarrays {
    public static List<int[]> findSubarrays(int[] arr) {
        List<int[]> result = new ArrayList<>();
        int n = arr.length;
        long[] prefix = new long[n];
        prefix[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                long sum;
                if (i == 0) sum = prefix[j];
                else sum = prefix[j] - prefix[i - 1];
                if (sum == 0) result.add(new int[]{i, j});
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, -3, 3, -1, 2};
        printResult(findSubarrays(arr1));
        int[] arr2 = {4, -1, -3, 1, 2, -1};
        printResult(findSubarrays(arr2));
        int[] arr3 = {0, 0, 0};
        printResult(findSubarrays(arr3));
        int[] arr4 = {-3, 1, 2, -3, 4, 0};
        printResult(findSubarrays(arr4));
        int[] arr5 = {1, 2, 3, 4};
        printResult(findSubarrays(arr5));
    }

    private static void printResult(List<int[]> subarrays) {
        List<String> result = new ArrayList<>();
        for (int[] pair : subarrays) {
            result.add("(" + pair[0] + ", " + pair[1] + ")");
        }
        System.out.println(result);
    }
}
