package GeeksforGeeksAlgorithms.Strings;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 9/4/13
 *
 */
class CharObj {
    char c;
    int index;

    public CharObj (char c, int index) {
        this.c = c;
        this.index = index;
    }

    @Override
    public boolean equals(Object obj) {

        CharObj o = (CharObj) obj;

        if (this.c == ((CharObj) obj).c && this.index == ((CharObj) obj).index)
            return true;
        else
            return false;

    }
}

public class LongestPalindromicSubsequence {

    /*
    http://www.geeksforgeeks.org/dynamic-programming-set-12-longest-palindromic-subsequence/


    Given a sequence, find the length of the longest palindromic subsequence in it. For example, if the given sequence is “BBABCBCAB”,
    then the output should be 7 as “BABCBAB” is the longest palindromic subseuqnce in it. “BBBBB” and “BBCBB” are also palindromic
    subsequences of the given sequence, but not the longest ones.

    BABCBAB => BBBBB, BBCBB
     */
    public static void main (String[] args) {

        String str = "GEEKSFORGEEKS";
        char[] charArr = str.toCharArray();
        LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();

        LinkedList<CharObj> list = new LinkedList<CharObj>();
        System.out.print(lps.LongestPalindromicSubsequenceR(charArr, 0, charArr.length - 1, list));
//        Collections.sort(list, new Comparator<CharObj>() {
//            @Override
//            public int compare(CharObj o1, CharObj o2) {
//
//                if (o1.index < o2.index)
//                    return -1;
//                else if (o1.index == o2.index)
//                    return 0;
//                else
//                    return 1;
//            }
//        });

//        for (int i = 0; i < list.size(); i++) {
//            System.out.print(list.get(i).c);
//        }

    }


    //recursive version
    public int LongestPalindromicSubsequenceR (char[] charArr, int low, int high, LinkedList<CharObj> list) {


        if(charArr == null)
            return 0;
        else if (high-low + 1 == 1)
            return 1;
//        else if (high-low + 1 == 2 && charArr[low] != charArr[high])        //this case will return 1 and will be taken care by
//            return 0;                                                         //return Math.max(LongestPalindromicSubsequenceR(charArr, low+1, high), LongestPalindromicSubsequenceR(charArr, low, high-1));
        else if (high-low + 1 == 2 && charArr[low] == charArr[high])
            return 2;
        else {
            if (charArr[low] == charArr[high]) {

//                CharObj o1 = new CharObj(charArr[low], low);
//                CharObj o2 = new CharObj(charArr[high], high);
//
//                if(!list.contains(o1))
//                    list.add(o1);
//
//                if(!list.contains(o2))
//                    list.add(o2);
                return LongestPalindromicSubsequenceR(charArr, low+1, high-1, list) + 2;
            }
            else
                return Math.max(LongestPalindromicSubsequenceR(charArr, low+1, high, list), LongestPalindromicSubsequenceR(charArr, low, high-1, list));
        }

    }






}
