import java.util.Arrays;

public class DuplicateChecks {
    public static int findDuplicate(int[] nums) {
        Arrays.sort(nums); 
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return nums[i]; 
            }
        }
        return -1; 
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 4, 2, 2};
        System.out.println("Duplicate: " + findDuplicate(nums1)); // 2

        int[] nums2 = {3, 1, 3, 4, 2};
        System.out.println("Duplicate: " + findDuplicate(nums2)); // 3

        int[] nums3 = {1, 1};
        System.out.println("Duplicate: " + findDuplicate(nums3)); // 1

        int[] nums4 = {1, 4, 4, 2, 3};
        System.out.println("Duplicate: " + findDuplicate(nums4)); // 4
    }
}
