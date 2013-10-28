package LeetCode;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: leo
 * Date: 10/27/13
 *
 *
 * http://liangyifanleetcode.blogspot.com/2013/05/divide-two-integers.html
 *
 */
public class DivideTwoInteger {


    public long divide(long dividend, long divisor) {

        long res = 0;

        int forward = 0;
        int backward;

        long dividendB = Math.abs(dividend);
        long divisorB = Math.abs(divisor);

        if(divisor == 1) {
            return dividend;
        } if ( (dividendB == divisorB) && ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) )
            return -1;
        else if ( (dividendB == divisorB) && ((dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0)))
            return 1;
        else if(dividendB < divisorB)
            return 0;
        else if (divisor == 2)
            return dividend >> 1;
        else {

            long curNum = divisorB;

            //forward subtraction
             while (true) {

                 dividendB = dividendB - curNum;

                 if (dividendB < 0)
                     break;

                 if (forward == 0)
                     res = res + 1;
                 else {
                     long tmp =  2 << (forward-1);
                     res = res + tmp;
                 }

                 forward++;
                 curNum = divisorB << forward;


             }

            dividendB = dividendB + curNum;
            //find backward
            backward = forward-1;
            curNum = divisorB << backward;

            //backward subtraction
            while (true) {

                dividendB = dividendB - curNum;

                if (dividendB < 0) {

                    dividendB = dividendB + curNum;
                } else {

                    if (backward == 0)
                        res = res + 1;
                    else {
                        long tmp =  2 << (backward-1);
                        res = res + tmp;
                    }
                }


                if (dividendB < divisorB)
                    break;

                backward--;
                curNum = divisorB << backward;

            }

        }


        if (dividend == 0)
            return 0;
        else if ( (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0) ) {
            res = -res;
        }

        return (int)res;

    }




    public static void main(String[] args) {

        DivideTwoInteger s = new DivideTwoInteger();
//      System.out.println(s.divide(2147483647, 3));   //715827882
      System.out.println(s.divide(-2147483648, -3));
        //System.out.println(s.divide(2001, 2));
        //System.out.println(1010369383 - 2147483648);
//
//        int i = 2;
//        int j = i<<0;
//        int k = 2<<27;
  //      System.out.println(Math.pow(2, 28) + " == " + k);


    }



}






















