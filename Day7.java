public class TrappingRainWater {

    // Function to calculate trapped rain water
    public static int trappedRainWater(int[] height) {
        int n = height.length;
        if (n < 3) return 0; // less than 3 bars → no water can be trapped

        int left = 0, right = n - 1;
        int leftMax = 0, rightMax = 0;
        int trappedWater = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    trappedWater += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    trappedWater += rightMax - height[right];
                }
                right--;
            }
        }
        return trappedWater;
    }

    public static void main(String[] args) {
        int[] height1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trappedRainWater(height1)); // 6

        int[] height2 = {4, 2, 0, 3, 2, 5};
        System.out.println(trappedRainWater(height2)); // 9

        int[] height3 = {1, 1, 1};
        System.out.println(trappedRainWater(height3)); // 0

        int[] height4 = {5};
        System.out.println(trappedRainWater(height4)); // 0

        int[] height5 = {2, 0, 2};
        System.out.println(trappedRainWater(height5)); // 2

        int[] height6 = {0,0,0,0};
        System.out.println(trappedRainWater(height6)); // 0

        int[] height7 = {1,2,3,4,5};
        System.out.println(trappedRainWater(height7)); // 0
    }
}
