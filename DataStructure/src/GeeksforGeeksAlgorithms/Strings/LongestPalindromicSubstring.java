package GeeksforGeeksAlgorithms.Strings;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 9/4/13
 *
 *
 */

public class LongestPalindromicSubstring {



    public static void main (String[] args) {

        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
        lps.longestPalindromicSubstringDP();

    }




    /*
Longest Palindromic Substring | Set 1
October 14, 2012

Given a string, find the longest substring which is palindrome. For example, if the given string is “forgeeksskeegfor”, the output should be “geeksskeeg”.
     */

    /**
     *
     *  1. table[start][end] = false, start < end
     *  2. table[start][end] = true, start == end
     *  3. table[start][end] = true, substring length is 2 && string[start] = string[end]
     *  4. table[start][end] = true, substring length > 3, table[start+1][end-1] = true && string[start] = string[end]
     *  5. table[start][end] = false, ELSE
     *
     */
    public void longestPalindromicSubstringDP () {

        String str = "forgeeksskeegfor";
        char[] charArr =str.toCharArray();
        int n = charArr.length;

        //dp table
        boolean[][] table = new boolean[n][n];

        //
        for (int start = table.length - 1; start >= 0; start--) {
            for (int end = table[start].length - 1; end >= 0; end--) {

                if (start == end)
                    table[start][end] = true;
                else if (start > end)
                    table[start][end] = false;
                else if (end - start == 1) {     //substring length is 2
                    if (charArr[start] == charArr[end])
                        table[start][end] = true;
                    else
                        table[start][end] = false;
                }else if(table[start+1][end-1] == true && charArr[start] == charArr[end])
                    table[start][end] = true;
                else
                    table[start][end] = false;

                System.out.print(table[start][end] + " ");
            }
            System.out.println();
        }

        int maxLen = 0;
        int finalS = -1;
        int finalE = -1;
        for (int start = 0; start < table.length; start++) {
            for (int end = 0; end < table[start].length; end++) {

                if (start <= end && table[start][end] == true) {

                    int curLen = end - start + 1;

                    if(curLen > maxLen) {
                        maxLen = curLen;
                        finalS = start;
                        finalE = end;
                    }
                }
            }
        }

        for (int i = finalS; i <= finalE; i++) {
            System.out.print(charArr[i]);
        }
    }








}








































