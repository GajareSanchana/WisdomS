class Solution5 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int left = 0, maxLen = 0;

        // To store the last index of each character
        int[] lastIndex = new int[128]; // ASCII size
        for (int i = 0; i < 128; i++) {
            lastIndex[i] = -1; // initialize
        }

        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);

            // If character is already in window, move left
            if (lastIndex[c] >= left) {
                left = lastIndex[c] + 1;
            }

            // Update last seen index of character
            lastIndex[c] = right;

            // Update max length
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    // Main method to test
    public static void main(String[] args) {
        Solution5 sol = new Solution5();

        String[] testCases = {"abcabcbb", "bbbbb", "pwwkew", "abcdefgh", "a"};
        for (String s : testCases) {
            int result = sol.lengthOfLongestSubstring(s);
            System.out.println("Input: " + s + " -> Longest Substring Length = " + result);
        }
    }
}
