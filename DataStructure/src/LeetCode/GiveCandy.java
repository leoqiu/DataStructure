package LeetCode;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: leo
 * Date: 10/11/13
 * Time: 1:11 AM
 * To change this template use File | Settings | File Templates.
 */
public class GiveCandy {




    public static int candy(int[] ratings) {

        int minCandies = 0;
        int n = ratings.length;

        //
        int[] candies = new int[n];

        for (int i = 0 ; i < n; i++) {

            candies[i] = 1;

            int curIndex = i;
            //going through the elements on current index's left
            while (curIndex > 0) {

                if(ratings[curIndex] > ratings[curIndex - 1])
                    candies[curIndex - 1] = candies[curIndex] - 1;
                else if (ratings[curIndex] < ratings[curIndex - 1])
                    candies[curIndex - 1] = candies[curIndex] + 1;
                else
                    candies[curIndex - 1] = candies[curIndex];

                curIndex--;

            }

            curIndex = i;

            while (curIndex < n - 1) {

                if(ratings[curIndex] > ratings[curIndex + 1])
                    candies[curIndex + 1] = candies[curIndex] - 1;
                else if (ratings[curIndex] < ratings[curIndex + 1])
                    candies[curIndex + 1] = candies[curIndex] + 1;
                else
                    candies[curIndex + 1] = candies[curIndex];

                curIndex++;

            }

            Arrays.sort(candies);

            int diff = 1 - candies[0];
            int curCandies = 0;
            for (int j = 0; j < n; j++)
                 curCandies = curCandies + candies[j];

            curCandies = curCandies + diff * n;

            if (minCandies == 0)
                minCandies = curCandies;
            else
                minCandies = Math.min(minCandies, curCandies);

        }

        return minCandies;
    }


    public static int candy2(int[] ratings) {

        int n = ratings.length;
        int[] candies = new int[n];
        int minCandy = 0;

        for (int i = 0; i < n ; i++) {

            if (i == 0)
                candies[i] = 1;
            else {

                if (ratings[i] < ratings[i-1])
                    candies[i] = candies[i-1] - 1;
                else if (ratings[i] > ratings[i-1])
                    candies[i] = candies[i-1] + 1;
                else
                    candies[i] = candies[i-1];

            }

        }

        Arrays.sort(candies);

        for (int i = 0; i < n; i++)
            minCandy = minCandy + candies[i];

        minCandy = minCandy + (1 - candies[0]) * n;


        return minCandy;
    }


    /*

        2  3  4  1  3  4  7  10  23  5  7
        -2 -1 0 -1 0 (1) 2  3   4  3  4

        -2 -1 -1 0 0 1 2 3 3 4 4

        1   2  2 3 3 4 5 6 6 7 7

     */


    public static void main (String[] args) {

        int[] ratings = {2, 3, 4, 1, 3, 4, 7, 10, 23, 5, 7};

        System.out.println(candy2(ratings));

    }



}








