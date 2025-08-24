import java.util.*;

public class Solution1 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        List<String> keys = new ArrayList<>(); // stores sorted versions for matching

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);

            // check if this key already exists in our keys list
            int index = keys.indexOf(sorted);

            if (index != -1) {
                // already a group exists, add to that group
                result.get(index).add(s);
            } else {
                // new group
                List<String> newGroup = new ArrayList<>();
                newGroup.add(s);
                result.add(newGroup);
                keys.add(sorted);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution1 sol = new Solution1();

        String[] strs1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(sol.groupAnagrams(strs1));

        String[] strs2 = {""};
        System.out.println(sol.groupAnagrams(strs2));

        String[] strs3 = {"a"};
        System.out.println(sol.groupAnagrams(strs3));

        String[] strs4 = {"abc", "bca", "cab", "xyz", "zyx", "yxz"};
        System.out.println(sol.groupAnagrams(strs4));

        String[] strs5 = {"abc", "def", "ghi"};
        System.out.println(sol.groupAnagrams(strs5));
    }
}
