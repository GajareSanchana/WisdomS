import java.util.Arrays;

public class LeadersInArray {

    public static int[] findLeaders(int[] arr) {
        int n = arr.length;
        int[] temp = new int[n];    // to store leaders temporarily
        int count = 0;              // count of leaders found

        int maxFromRight = arr[n - 1];
        temp[count++] = maxFromRight;       // last element is always a leader

        // Traverse from right to left
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= maxFromRight) {
                maxFromRight = arr[i];
                temp[count++] = maxFromRight;
            }
        }

        // Now temp[] has leaders in reverse order, so store them in correct order
        int[] leaders = new int[count];
        int index = 0;
        for (int i = count - 1; i >= 0; i--) {
            leaders[index++] = temp[i];
        }

        return leaders;
    }

    public static void main(String[] args) {
        int[] arr = {16, 17, 4, 3, 5, 2};
        int[] leaders = findLeaders(arr);
        System.out.println("Input : " + Arrays.toString(arr));
        System.out.println("Leaders: " + Arrays.toString(leaders));
    }
}
