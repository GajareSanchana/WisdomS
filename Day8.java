public class ReverseWords {
    public static String reverseWords(String s) {
        // Step 1: Trim leading and trailing spaces
        s = s.trim();

        StringBuilder word = new StringBuilder();
        java.util.List<String> words = new java.util.ArrayList<>();

        // Step 2: Traverse each character
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c != ' ') {
                // build current word
                word.append(c);
            } else {
                // word ends when space is found
                if (word.length() > 0) {
                    words.add(word.toString());
                    word.setLength(0); // reset for next word
                }
            }
        }

        // Add last word if exists
        if (word.length() > 0) {
            words.add(word.toString());
        }

        // Step 3: Reverse words manually
        StringBuilder result = new StringBuilder();
        for (int i = words.size() - 1; i >= 0; i--) {
            result.append(words.get(i));
            if (i > 0) result.append(" ");
        }

        return result.toString();
    }  
    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));      // "blue is sky the"
        System.out.println(reverseWords("  hello world  "));      // "world hello"
        System.out.println(reverseWords("a good   example"));     // "example good a"
        System.out.println(reverseWords("    "));                 // ""
        System.out.println(reverseWords("word"));                 // "word"
    }
}
