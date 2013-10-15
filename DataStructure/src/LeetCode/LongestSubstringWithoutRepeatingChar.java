package LeetCode;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: leo
 * Date: 10/14/15
 *
 * http://oj.leetcode.com/problems/longest-substring-without-repeating-characters/
 */

public class LongestSubstringWithoutRepeatingChar {


    public int lengthOfLongestSubstring(String s) {

        char[] chars = s.toCharArray();
        int n = chars.length;
        int maxCount = 0;
        int startIndex = 0;
        HashMap<Character, Integer> hash = new HashMap<Character, Integer>();

        for (int i = 0; i < n; i++) {

            if (hash.containsKey(chars[i])) {

                maxCount = Math.max(maxCount, i - startIndex);
                startIndex = getStartIndex(chars, chars[i], startIndex, n);
                hash.clear();
                i = startIndex-1;
                continue;

            }

            hash.put(chars[i], 0);

        }

        maxCount = Math.max(maxCount, n - startIndex);

        return maxCount;
    }

    private int getStartIndex (char[] chars, char c, int starIndex, int n) {

        for (int i = starIndex; i < n; i++ ) {
            if (chars[i] == c) {
                return i+1;
            }
        }

        return 0;
    }



    public static void main (String[] args) {

        LongestSubstringWithoutRepeatingChar s = new LongestSubstringWithoutRepeatingChar();

        //12
        String str = "qopubjguxhxdipfzwswybgfylqvjzhar";
        System.out.println(s.lengthOfLongestSubstring(str));


    }


}
















