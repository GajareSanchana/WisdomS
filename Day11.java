import java.util.*;

public class Solution2 {
    public List<String> permuteUnique(String s) {
        List<String> result = new ArrayList<>();
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        result.add(new String(chars));

        while (nextPermutation(chars)) {
            result.add(new String(chars));
        }
        return result;
    }

    private boolean nextPermutation(char[] arr) {
        int n = arr.length;
        int i = n - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) i--;
        if (i < 0) return false;
        int j = n - 1;
        while (arr[j] <= arr[i]) j--;
        swap(arr, i, j);
        reverse(arr, i + 1, n - 1);
        return true;
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void reverse(char[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start++, end--);
        }
    }

    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        System.out.println(sol.permuteUnique("abc"));
        System.out.println(sol.permuteUnique("aab"));
        System.out.println(sol.permuteUnique("aaa"));
        System.out.println(sol.permuteUnique("a"));
        System.out.println(sol.permuteUnique("abcd"));
    }
}
