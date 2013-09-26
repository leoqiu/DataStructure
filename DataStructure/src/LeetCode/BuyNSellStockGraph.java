package LeetCode;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 9/26/13
 */


public class BuyNSellStockGraph {










    private ArrayList<Transaction> getPossibleTransactions (int[] prices) {

        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        int n = prices.length;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j > i ; j--) {
                if (prices[j] > prices[i]) {
                    transactions.add(new Transaction(i, j, prices[j] - prices[i]));
                }
            }

        }

        System.out.println();

        return transactions;
    }





    public static void main (String[] args) {

        int[] prices = {3,12,43,4,5,1,1,2,2,32,3,4,35,4,654,6,56,4,56,4,2,34,24,6};
        BuyNSellStockGraph bsg = new BuyNSellStockGraph();
        bsg.getPossibleTransactions(prices);
    }




    class Transaction {

        int buyDay;
        int sellDay;
        int profit;

        Transaction (int buyDay, int sellDay, int profit) {
            this.buyDay = buyDay;
            this.sellDay = sellDay;
            this.profit = profit;
        }

    }

}


