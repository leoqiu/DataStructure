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

        int n = prices.length;
        if (n == 0)
            return 0;

        int[] historyProfits = new int[n];
        int[] futureProfits = new int[n];

        int lowPrice = prices[0];
        int highPrice = prices[n-1];
        int maxProfit = 0;

        //forward
        for (int i = 0; i < n; i++) {
            lowPrice = Math.min(lowPrice, prices[i]);

            if (i > 0) {
                historyProfits[i] = Math.max(historyProfits[i-1], prices[i] - lowPrice);
            }
        }

        //backward
        for (int i = n - 1; i >= 0; i--) {
            highPrice = Math.max(highPrice, prices[i]);

            if(i < n - 1) {
                int curProfit = highPrice - prices[i];
                futureProfits[i] = Math.max(futureProfits[i+1], curProfit);
            }

            maxProfit = Math.max(maxProfit, futureProfits[i] + historyProfits[i]);
        }

        printArr(historyProfits);
        printArr(futureProfits);


        return maxProfit;
    }

    private static void maxProfitMTransactions (int[] prices, int numTransactions) {

        int n = prices.length;
        int[] profits = new int[n - 1];

        for (int i = 0; i < n - 1; i++) {

            int curProfit = prices[i+1] - prices[i];
            profits[i] = curProfit;
        }

        printArr(profits);



    }


    private static void printArr (int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    public static void main (String[] args) {

        //int[] prices = {2,3,4,3,3,5,6,44,678,23,455,3,2,68,3};
        //System.out.print(maxProfit1(prices));
        //int[] prices = {1,2,3,4,8,6,7};
        //System.out.print(maxProfit2(prices));

        //int[] prices = {6,1,3,2,4,7};
        //System.out.print(maxProfit3(prices));

        int[] prices = {3,12,43,4,5,1,1,2,2,32,3,4,35,4,54,6,56,4,56,4,2,34,24,6};
        //System.out.print(maxProfit3(prices));

        maxProfitMTransactions(prices, 3);
    }

}
































