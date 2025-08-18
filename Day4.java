import java.util.Arrays;

public class MergeSortedArraysSimple {
    public static void merge(int[] arr1, int[] arr2, int m, int n) {
        // Traverse arr1[] and arr2[]
        for (int i = 0; i < m; i++) {
            if (arr1[i] > arr2[0]) {
                // Swap
                int temp = arr1[i];
                arr1[i] = arr2[0];
                arr2[0] = temp;

                // After swapping, sort arr2 again (to maintain order)
                int first = arr2[0];
                int k;
                for (k = 1; k < n && arr2[k] < first; k++) {
                    arr2[k - 1] = arr2[k];
                }
                arr2[k - 1] = first;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 5, 9, 10, 15, 20};
        int[] arr2 = {2, 3, 8, 13};

        merge(arr1, arr2, arr1.length, arr2.length);

        System.out.println("arr1 = " + Arrays.toString(arr1));
        System.out.println("arr2 = " + Arrays.toString(arr2));
    }
}
