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




    public static void main (String[] args) {

        Hack1 hack = new Hack1();
        //System.out.print(hack.sherlockAndBeast(11));
        System.out.print(hack.helpMike(667, 8));

    }

}
























