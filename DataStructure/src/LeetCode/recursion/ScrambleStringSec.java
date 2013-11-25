package LeetCode.recursion;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 11/14/13
 *
 *
 *http://oj.leetcode.com/problems/scramble-string/
 *
 * solution
 *
 * http://fisherlei.blogspot.com/2013/01/leetcode-scramble-string.html
 *
 */



public class ScrambleStringSec {

    public boolean isScramble(String s1, String s2) {

        int len = s1.length();

        HashMap<Character, Integer> hash1 = new HashMap<Character, Integer>();
        HashMap<Character, Integer> hash2 = new HashMap<Character, Integer>();

        for (int m = 0; m < len; m++) {
            char curKey = s1.charAt(m);
            if(hash1.containsKey(curKey))
                hash1.put(curKey, hash1.get(curKey)+1);
            else
                hash1.put(curKey, 1);
        }

        for (int m = 0; m < len; m++) {
            char curKey = s2.charAt(m);
            if(hash2.containsKey(curKey))
                hash2.put(curKey, hash2.get(curKey)+1);
            else
                hash2.put(curKey, 1);
        }

        if(!hash1.equals(hash2))
            return false;

        if(s1.length() == 1 && s2.length() == 1)
            return true;

        for(int i = 1; i < s1.length(); i++){

            boolean result1 = isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i, s1.length()), s2.substring(i, s2.length()));
           // boolean result2 = isScramble(s1.substring(0, i), s2.substring(s2.length()-i, ))
        }



        return false;
    }



}
