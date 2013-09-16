package Hack;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 9/13/13
 * Time: 2:15 PM
 *
 *
 * https://www.hackerrank.com/contests/sep13/challenges
 */



public class Hack1 {


    /**
     *
     * Sherlock and The Beast
     *
     * https://www.hackerrank.com/contests/sep13/challenges/sherlock-and-the-beast
     *
     */
    public String sherlockAndBeast (int n) {

        String str = "";
        String NON = "-1";

        // mode 3
        int resOfMode3 = n / 3;
        int leftOfMode3 = n % 3;

        //mode 5
        int resOfMode5 = n / 5;
        int leftOfMode5 = n % 5;

        //n < 3, return -1
        if (resOfMode3 == 0 || n == 4)
            return NON;
        else if (leftOfMode3 == 0 && resOfMode3 >= 1) {

            for (int i = 0; i < resOfMode3 * 3; i++)
                str = str + "5";
            return str;
        }else if (leftOfMode3 == 2 && resOfMode3 >=1) {


            for (int i = 0; i < 2+3; i++)
                str = str + "3";
            for (int i = 0; i < (resOfMode3 -1) * 3; i++)
                str = str + "5";

            return str;
        } else if (leftOfMode3 == 1 && resOfMode3 >= 3) {

            for (int i = 0; i < 3*3 + 1; i++)
                str = str + "3";
            for (int i = 0; i < (resOfMode3 -3) * 3; i++)
                str = str + "5";

            return str;
        } else if (leftOfMode5 == 0 && resOfMode5 >= 1){

            for (int i = 0; i < resOfMode5 * 5; i++)
                str = str + "3";
            return str;
        } else if (leftOfMode5 == 4 && resOfMode5 >= 1) {
            for (int i = 0; i < 4+5; i++)
                str = str + "5";
            for (int i = 0; i < (resOfMode5 -1) * 5 ; i++)
                str = str + "3";

            return str;
        }else if (leftOfMode5 == 3 && resOfMode5 >= 3) {
            for (int i = 0; i < 3+ 3*5; i++)
                str = str + "5";
            for (int i = 0; i < (resOfMode5 - 3) * 5 ; i++)
                str = str + "3";

            return str;
        } else if (leftOfMode5 == 2 && resOfMode5 >= 2) {
            for (int i = 0; i < 2+ 2*5; i++)
                str = str + "5";
            for (int i = 0; i < (resOfMode5 - 2) * 5 ; i++)
                str = str + "3";

            return str;
        } else if  (leftOfMode5 == 1 && resOfMode5 >= 1) {
            for (int i = 0; i < 1+ 1*5; i++)
                str = str + "5";
            for (int i = 0; i < (resOfMode5 - 1) * 5 ; i++)
                str = str + "3";

            return str;
        }
        return NON;
    }


    /**
     *  Help Mike
     *
     *  https://www.hackerrank.com/contests/sep13/challenges/help-mike
     *
     *
     *  Hi, I am new to hackerrank.com and could really love to learn the codes from
     *  other hackers, can someone tell me where I can find the released answers and
     *  some explanations after the contest is over. I can only find other ppl's
     *  codes but without any explanations on the Leaderboard. Thx
     *
     *  Where to find the released answers and some explanations to the answers after the contest is over
     */
    public int helpMike (int n, int k) {

        int[] array = new int[n];
        int pairCount = 0;

        for (int i = 0; i < array.length; i++)
            array[i] = i + 1;

        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                if ( (array[i] + array[j]) % k == 0)
                    pairCount++;
            }
        }

        return pairCount;
    }


    /**
     * #3. Sherlock Puzzle
     *
     *
     * https://www.hackerrank.com/contests/sep13/challenges/sherlock-puzzle
     */
    private boolean isMatch (int start, int end, char[] chars) {

        boolean isMatch = false;
        int zeroCount = 0;
        int oneCount = 0;

        for (int i = start; i <= end; i++) {

            if (chars[i] == '0')
                zeroCount++;
            if (chars[i] == '1')
                oneCount++;

        }

        if (2*zeroCount <= 3*oneCount)
            isMatch = true;

        return isMatch;
    }

    private int longestMatch (char[] chars, int n) {

        int curLen = 0;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {

                curLen = j - i + 1;

                if (isMatch(i, j, chars) && curLen > maxLen) {
                       maxLen = curLen;
                }

            }
        }

        return maxLen;

    }


    public int sherlockPuzzle (String s, int k) {

        int len = 0;
        char[] chars = s.toCharArray();
        int n = chars.length;

        if (isMatch(0, n-1, chars))
            return n*k;
        else if (isMatch(1, n-1, chars) && isMatch(0, n-2, chars))
            return n*2;
        else
            return longestMatch(chars, n);

    }


    /**
     * Chocolate Game
     *
     *  https://www.hackerrank.com/contests/sep13/challenges/chocolate-game
     */
    private boolean isLarWin (int[] array, int start, int end) {

        int sum = 0;

        for (int i = start; i <= end; i++) {
            sum = sum + array[i];
        }

        if(sum%2 == 1)
            return true;
        else
            return false;

    }


    public int chocolateGame (int n, int[] array) {

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {

                if(isLarWin(array, i, j))
                    count++;

            }
        }

        return count;
    }


    /**
     * Grid Lines
     *
     * https://www.hackerrank.com/contests/sep13/challenges/grid-lines
     */
    public int gridLines (int height, int width, int lineLen) {

        int count = 0;

        if (height < lineLen - 1 && width < lineLen - 1)
            return count;
        else if (height < lineLen - 1 && width >= lineLen - 1)
            return height + 1;
        else if (height >= lineLen - 1 && width < lineLen - 1)
            return  width + 1;
        else if (height == lineLen - 1 && width == lineLen - 1) {
            return 8;

        } else {
            int a = height - (lineLen - 1);
            int b = width - (lineLen - 1);
            return a*b*8;
        }
    }




















    public static void main (String[] args) {

        Hack1 hack = new Hack1();
        //System.out.print(hack.sherlockAndBeast(11));
        //System.out.print(hack.helpMike(100000 , 99));
        //System.out.print(hack.sherlockPuzzle("011100010110101010101001100101010010" , 20));
        //int[] arr = {1, 1, 2, 2, 3};
        //System.out.print(hack.chocolateGame(5 , arr));
        System.out.print(hack.gridLines(22, 200 , 17));

    }

}
























