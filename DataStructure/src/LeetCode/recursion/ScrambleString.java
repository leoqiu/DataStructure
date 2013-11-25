package LeetCode.recursion;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 11/14/13
 *
 *
 *
 */


public class ScrambleString {



    public boolean isScramble(String s1, String s2) {

        int len = s1.length();

        if(s1 == null || s2 == null)
            return false;

        if( (s1 == null && s2 == null))
            return true;

        if(len == 1)
            return s1.equals(s2);

        if(len == 2)
            return (s1.charAt(0) == s2.charAt(0) && s1.charAt(1) == s2.charAt(1)) ||
                    (s1.charAt(0) == s2.charAt(1) && s1.charAt(1) == s2.charAt(0));

        for (int i = 0; i < len-1; i++) {
            if(isScrambleForPartition(s1, s2, i, len)){
                return true;
            }
        }

        return false;
    }

    private boolean isScrambleForPartition(String s1, String s2, int i, int len) {

        HashMap<Character, Integer> hash1 = new HashMap<Character, Integer>();
        HashMap<Character, Integer> hash2 = new HashMap<Character, Integer>();
        HashMap<Character, Integer> hash11 = new HashMap<Character, Integer>();
        HashMap<Character, Integer> hash22 = new HashMap<Character, Integer>();

        for (int m = 0; m <=i; m++) {
            char curKey = s1.charAt(m);
            if(hash1.containsKey(curKey))
                hash1.put(curKey, hash1.get(curKey)+1);
            else
                hash1.put(curKey, 1);
        }

        for (int m = 0; m <=i; m++) {
            char curKey = s2.charAt(m);
            if(hash2.containsKey(curKey))
                hash2.put(curKey, hash2.get(curKey)+1);
            else
                hash2.put(curKey, 1);
        }

        for (int m = i+1; m < len; m++) {
            char curKey = s1.charAt(m);
            if(hash11.containsKey(curKey))
                hash11.put(curKey, hash11.get(curKey)+1);
            else
                hash11.put(curKey, 1);
        }

        for (int m = i+1; m < len; m++) {
            char curKey = s2.charAt(m);
            if(hash22.containsKey(curKey))
                hash22.put(curKey, hash22.get(curKey)+1);
            else
                hash22.put(curKey, 1);
        }

        //return hash1.equals(hash2) && hash11.equals(hash22);

        HashMap<Character, Integer> hash3 = new HashMap<Character, Integer>();
        HashMap<Character, Integer> hash4 = new HashMap<Character, Integer>();
        HashMap<Character, Integer> hash33 = new HashMap<Character, Integer>();
        HashMap<Character, Integer> hash44 = new HashMap<Character, Integer>();

        for (int m = 0; m <=i ; m++) {
            char curKey = s1.charAt(m);
            if(hash3.containsKey(curKey))
                hash3.put(curKey, hash3.get(curKey)+1);
            else
                hash3.put(curKey, 1);
        }

        for (int m = i+1; m < len; m++) {
            char curKey = s1.charAt(m);
            if(hash33.containsKey(curKey))
                hash33.put(curKey, hash33.get(curKey)+1);
            else
                hash33.put(curKey, 1);
        }

        for (int m = 0; m < len-1-i; m++) {
            char curKey = s2.charAt(m);
            if(hash4.containsKey(curKey))
                hash4.put(curKey, hash4.get(curKey)+1);
            else
                hash4.put(curKey, 1);
        }

        for (int m = len-1-i; m < len; m++) {
            char curKey = s2.charAt(m);
            if(hash44.containsKey(curKey))
                hash44.put(curKey, hash44.get(curKey)+1);
            else
                hash44.put(curKey, 1);
        }


        return (hash1.equals(hash2) && hash11.equals(hash22)) || (hash3.equals(hash44) && hash4.equals(hash33) ) ;
    }


    public static void main (String[] args) {

        //corner case, partition till s1[len-2]
//        String s1 = "abcd";
//        String s2 = "bdac";

        //
//        String s1 = "a";
//        String s2 = "a";

//        String s1 = "ab";
//        String s2 = "ba";

//        String s1 = "abb";
//        String s2 = "bba";

          String s1 = "abcdd";
          String s2 = "dbdac";

        ScrambleString s = new ScrambleString();
        System.out.print(s.isScramble(s1, s2));
    }

}























