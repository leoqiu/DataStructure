package LeetCode;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 10/16/13
 *
 * http://oj.leetcode.com/problems/regular-expression-matching/
 *
 * solution:
 *          http://blog.csdn.net/hopeztm/article/details/7992253
 */


public class RegularExpressionMatching {


    public boolean isMatch(String s, String p) {


        char[] chars = s.toCharArray();
        int n = chars.length;
        int i = 0;

        char[] charp = p.toCharArray();
        int m = chars.length;
        int j = 0;

        while (i < n-1 && j < m-1) {

            if (chars[i] == charp[j]) {
                i++;
                j++;
            }

            if (chars[i] == '.' && charp[j] != '*') {
                i++;
                j++;
            }

            if (chars[j] == '.' && charp[i] != '*') {
                i++;
                j++;
            }

            if (chars[i] == '*' && chars[i-1] == charp[j]) {

                while(chars[i-1] == charp[j])
                    j++;

                i++;
            }

            if (chars[i] == '*' && chars[i-1] != charp[j] && chars[i+1] == charp[j]) {

                j++;
            }


        }

        return false;
    }


    public boolean isMatch2(String s, String p) {

        s = s+'\0';
        p = p+'\0';

        char[] ss = s.toCharArray();
        int n = ss.length;
        char[] pp = p.toCharArray();
        int m = pp.length;

        for (int i = 0; i < ss.length; i++) {
            if(ss[i] == '\0')
            System.out.println(99);
        }

        return isMatch3 (ss, 0, n, pp, 0, m) ;

    }

    public boolean isMatch3 (char[] s, int indexS, int n, char[] p, int indexP, int m) {

        //
        if (s[indexS] == '\0')
            return indexP == '\0';

        if (p[indexP+1] != '*') {
            if (s[indexS] == p[indexP] || p[indexP] == '.' && indexS != n) {
                return  isMatch3(s, indexS+1, n, p, indexP+1, m);
            }else
                return false;
        } else {

            while (s[indexS] == p[indexP] || p[indexP] == '.' && indexS != n ) {

                if (isMatch3(s, indexS, n, p, indexP+2, m)) {
                    return true;
                }

                indexS++;
            }

            return isMatch3(s, indexS, n, p, indexP+2, m);

        }
    }



    public static void main (String[] args) {

        RegularExpressionMatching s = new RegularExpressionMatching();
        System.out.println(s.isMatch2("aab", "aa."));

    }

}


















