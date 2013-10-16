package LeetCode;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 10/15/13
 *
 *
 *  http://oj.leetcode.com/problems/zigzag-conversion/
 */
public class ZigZagConversion {


    public String convert(String s, int nRows) {

        char[] chars = s.toCharArray();
        int n = chars.length;

        if(n == 0)
            return "";

        if (nRows == 1)
            return s;

        StringBuilder[] sbList = new StringBuilder[nRows];
        for (int i = 0; i < nRows; i++) {
            sbList[i] = new StringBuilder("");
        }

        int curX = 0;
        //int curY = 0;
        int count = 0;
        sbList[curX].append(chars[count]);
        int zigZagCount = 0;
        boolean isZig = true;

        while ( count < n - 1) {

            if (zigZagCount == (nRows-1)) {
                zigZagCount = 0;
                if (isZig)
                    isZig = false;
                else
                    isZig = true;
            }

            if (isZig) {
                curX++;
                count++;
                zigZagCount++;
                sbList[curX].append(chars[count]);
            } else {
                curX--;
                //curY++;
                count++;
                zigZagCount++;
                sbList[curX].append(chars[count]);
            }
        }

        StringBuilder res = sbList[0];
        for (int i = 1; i < nRows; i++) {
            res = res.append(sbList[i]);
        }

        return res.toString();
    }

    public static void main (String[] args) {

        ZigZagConversion s = new ZigZagConversion();
        //String str = "abcdefghijklmnopqrstuvwx";
        String str = "AB";
        System.out.println(s.convert(str, 1));

    }


}
