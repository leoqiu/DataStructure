package LeetCode;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 9/24/13
 *
 *
 * http://www.cnblogs.com/caijinlong/archive/2013/05/01/3053165.html
 */
public class BuyNSellStock {

    public static int maxProfit1(int[] prices) {

        int maxP = Integer.MIN_VALUE;
        int n = prices.length;

        int curMinIndex = 0;

        if(n ==0)
            return 0;

        for (int i = 0; i < n; i++) {

            if (prices[i] < prices[curMinIndex])
                curMinIndex = i;

            int curP = prices[i] - prices[curMinIndex];
            if (curP > maxP)
                maxP = curP;


        }

        return maxP;
    }

    public static int maxProfit2 (int[] prices) {

                 int p = 0;
                 for (int i = 1; i < prices.length; i++)
                   {
                        int delta = prices[i] - prices[i-1];
                         if (delta > 0)
                                p += delta;

                     }
                 return p;

    }


    public static int maxProfit3 (int[] prices) {


        int maxP1 = 0;
        int n = prices.length;

        int curMin1 = 0;
        int finalMin1 = 0;
        int finalMax1 = 0;

        if(n <= 1)
            return 0;

        for (int i = 0; i < n; i++) {

            if(prices[i] < prices[curMin1])
                curMin1 = i;

            int curP = prices[i] - prices[curMin1];
            if(curP > maxP1) {
                finalMin1 = curMin1;
                finalMax1 = i;
                maxP1 = curP;
            }

        }



        return maxP1;

    }



    public static void main (String[] args) {

        //int[] prices = {2,3,4,3,3,5,6,44,678,23,455,3,2,68,3};
        //System.out.print(maxProfit1(prices));
        int[] prices = {1,2,3,4,8,6,7};
        System.out.print(maxProfit2(prices));

        //int[] prices = {6,1,3,2,4,7};
        //System.out.print(maxProfit3(prices));

    }

}
































