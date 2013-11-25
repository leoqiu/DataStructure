package LeetCode.string;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 11/16/13
 *
 * http://oj.leetcode.com/problems/interleaving-string/
 *
 */


public class InterleavingString {


    public boolean isInterleave(String s1, String s2, String s3) {

        if(s1.length() + s2.length() != s3.length())
            return false;

        isInterleave2(s1, s2, s3, 0,0,0);

        return isIn;
    }

    static boolean isIn = false;
    static int count = 0;
    public void isInterleave2(String s1, String s2, String s3, int i1, int i2, int i3) {


        if(i3 == s3.length()) {
            isIn = true;
            count++;
            return;
        }

        if( (i1 < s1.length() && s1.charAt(i1) == s3.charAt(i3)) && ( (i2 < s2.length() && s2.charAt(i2) != s3.charAt(i3)) || i2 == s2.length() ) )
            isInterleave2(s1, s2, s3, i1+1, i2, i3+1);

        if(( i2 < s2.length() && s2.charAt(i2) == s3.charAt(i3)) && (( i1 < s1.length() && s1.charAt(i1) != s3.charAt(i3)) || i1 == s1.length()) )
            isInterleave2(s1, s2, s3, i1, i2+1, i3+1);

        if( (i1 < s1.length() && s1.charAt(i1) == s3.charAt(i3) ) && ( i2 < s2.length() && s2.charAt(i2) == s3.charAt(i3))) {
            isInterleave2(s1, s2, s3, i1+1, i2, i3+1);
            isInterleave2(s1, s2, s3, i1, i2+1, i3+1);
        }
    }

    public boolean isInterleave3(String s1, String s2, String s3, int i1, int i2, int i3) {

        if(i3 == s3.length()) {
            count++;
            return true;
        }

        if( (i1 < s1.length() && s1.charAt(i1) == s3.charAt(i3)) && ( (i2 < s2.length() && s2.charAt(i2) != s3.charAt(i3)) || i2 == s2.length() ) )
            if(isInterleave3(s1, s2, s3, i1+1, i2, i3+1))
                return true;

        if(( i2 < s2.length() && s2.charAt(i2) == s3.charAt(i3)) && (( i1 < s1.length() && s1.charAt(i1) != s3.charAt(i3)) || i1 == s1.length()) )
            if(isInterleave3(s1, s2, s3, i1, i2+1, i3+1))
                return true;

        if( (i1 < s1.length() && s1.charAt(i1) == s3.charAt(i3) ) && ( i2 < s2.length() && s2.charAt(i2) == s3.charAt(i3))) {
            if(isInterleave3(s1, s2, s3, i1+1, i2, i3+1) || isInterleave3(s1, s2, s3, i1, i2+1, i3+1))
                return true;

        }

        return false;
    }



    public static void main (String[] args) {

//        String s1 = "abbbbbbcabbacaacccababaabcccabcacbcaabbbacccaaaaaababbbacbb";
//        String s2 = "ccaacabbacaccacababbbbabbcacccacccccaabaababacbbacabbbbabc";
//        String s3 = "cacbabbacbbbabcbaacbbaccacaacaacccabababbbababcccbabcabbaccabcccacccaabbcbcaccccaaaaabaaaaababbbbacbbabacbbacabbbbabc";

//        String s1 = "aabcc";
//        String s2 = "dbbca";
//        String s3 = "aadbbcbcac";

        String s1 = "bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa";
        String s2 = "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab";
        String s3 = "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab";

        InterleavingString s = new InterleavingString();
//        s.isInterleave(s1,s2,s3);
//        System.out.println(isIn);
//        System.out.print(count);

        //System.out.print(s.isInterleave3(s1,s2,s3,0,0,0));
        s.isInterleave2(s1,s2,s3,0,0,0);
        System.out.print(count);

    }

}
































































