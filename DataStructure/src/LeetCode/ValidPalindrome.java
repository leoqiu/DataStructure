package LeetCode;

/**
 * Created with IntelliJ IDEA.
 * User: leo
 * Date: 9/19/13
 *
 *
 * http://oj.leetcode.com/problems/valid-palindrome/
 *
 */
public class ValidPalindrome {



    private char covertToLowerCase(int ascii) {

        if (ascii == 65)
            return 'a';
        else if (ascii == 66)
            return 'b';
        else if (ascii == 67)
            return 'c';
        else if (ascii == 68)
            return 'd';
        else if (ascii == 69)
            return 'e';
        else if (ascii == 70)
            return 'f';
        else if (ascii == 71)
            return 'g';
        else if (ascii == 72)
            return 'h';
        else if (ascii == 73)
            return 'i';
        else if (ascii == 74)
            return 'j';
        else if (ascii == 75)
            return 'k';
        else if (ascii == 76)
            return 'l';
        else if (ascii == 77)
            return 'm';
        else if (ascii == 78)
            return 'n';
        else if (ascii == 79)
            return 'o';
        else if (ascii == 80)
            return 'p';
        else if (ascii == 81)
            return 'q';
        else if (ascii == 82)
            return 'r';
        else if (ascii == 83)
            return 's';
        else if (ascii == 84)
            return 't';
        else if (ascii == 85)
            return 'u';
        else if (ascii == 86)
            return 'v';
        else if (ascii == 87)
            return 'w';
        else if (ascii == 88)
            return 'x';
        else if (ascii == 89)
            return 'y';
        else
            return 'z';

    }

    private boolean isNumeric (char c) {

        if (c == '0')
            return true;
        else if (c == '1')
            return true;
        else if (c == '2')
            return true;
        else if (c == '3')
            return true;
        else if (c == '4')
            return true;
        else if (c == '5')
            return true;
        else if (c == '6')
            return true;
        else if (c == '7')
            return true;
        else if (c == '8')
            return true;
        else if (c == '9')
            return true;
        else
            return false;

    }

    public boolean isPalindrome(String s) {

        if (s == null)
            return true;

        boolean isPalindromic = true;
        char[] chars = s.toCharArray();
        int n = chars.length;
        StringBuilder sb = new StringBuilder("");

        //O(n)
        for (int i = 0; i < n; i++) {

            int ascii = (int)chars[i];
            if ( ascii >= 65 && ascii <= 90 ) {
                sb.append(covertToLowerCase(ascii));
            }

            if ( ascii >= 97 && ascii <= 122 )
                sb.append(chars[i]);

            if (isNumeric(chars[i]))
                sb.append(chars[i]);

        }

        //
        char[] chars1 = sb.toString().toCharArray();
        int m = chars1.length;
        int low = 0;
        int high = m - 1;

        while (low <= high) {

            if (chars1[low] == chars1[high]) {
                low++;
                high--;
            } else {
                isPalindromic = false;
                break;
            }

        }

        return isPalindromic;
    }



    public static void main (String[] args) {

        String str = "A man, a plan, a canal: Panama";
        ValidPalindrome vp = new ValidPalindrome();

        System.out.print(vp.isPalindrome(str));


    }






}
