package LeetCode;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 10/16/13
 *
 * http://oj.leetcode.com/problems/longest-common-prefix/
 */


public class LongestCommonPrefix {


    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0)
            return "";

        HashMap<Character, Integer> hash = new HashMap<Character, Integer>();

        int maxPrefixLen = Integer.MAX_VALUE;
        int shortestStrIndex = 0;
        for (int i = 0; i < strs.length; i++) {
            if(strs[i].length() < maxPrefixLen) {
                maxPrefixLen = strs[i].length();
                shortestStrIndex = i;
            }
        }

        int curIndex = 0;

        while (true) {

            if(curIndex == maxPrefixLen )
                return strs[shortestStrIndex];

            for (int i = 0; i < strs.length; i++) {

                char c = strs[i].charAt(curIndex);
                hash.put(c, 0);
            }

            if(hash.size() != 1) {
                break;
            } else {
                hash.clear();
                curIndex++;
            }

        }

        return strs[0].substring(0, curIndex);
    }


    public static void main(String[] args) {

//        String[] strs = {
//                "aaabc",
//                "aaabcxdfa",
//                "aaab",
//                "aaabcsww",
//                "aaabczzz",
//                "aaabcqqq",
//        };

        String[] strs = {};

        LongestCommonPrefix s = new LongestCommonPrefix();
        System.out.println(s.longestCommonPrefix(strs));

    }

}

















