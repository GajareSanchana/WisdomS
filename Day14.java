public class Solution4 {

    private static long countAtMostKDistinct(String s, int k) {
        int n = s.length();
        int left = 0;
        long count = 0;
        int[] freq = new int[26];
        int distinct = 0;

        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);

            if (freq[c - 'a'] == 0) {
                distinct++;
            }
            freq[c - 'a']++;

            // shrink until valid
            while (distinct > k) {
                char leftChar = s.charAt(left);
                freq[leftChar - 'a']--;
                if (freq[leftChar - 'a'] == 0) {
                    distinct--;
                }
                left++;
            }

            // add only after ensuring window is valid
            count += (right - left + 1);
        }

        return count;
    }

    public static long countExactlyKDistinct(String s, int k) {
        if (k > s.length()) return 0;
        return countAtMostKDistinct(s, k) - countAtMostKDistinct(s, k - 1);
    }

    public static void main(String[] args) {
        System.out.println(countExactlyKDistinct("pqpqs", 2));       // 7
        System.out.println(countExactlyKDistinct("aabacbebebe", 3)); // 10 ✅
        System.out.println(countExactlyKDistinct("a", 1));           // 1
        System.out.println(countExactlyKDistinct("abc", 3));         // 1
        System.out.println(countExactlyKDistinct("abc", 2));         // 2
    }
}
