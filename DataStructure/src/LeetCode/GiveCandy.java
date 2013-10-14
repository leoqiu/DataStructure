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

        //case n == 1
        if (n == 1)
            return 1;

        //case n == 2
        if (n == 2) {

            if (ratings[0] == ratings[1])
                return 2;
            else
                return 3;

        }

//        if(isAllEleSame(ratings , n))
//            return n;

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
                    //candies[i] = 1;

            }

        }

        int min = getMin(candies , n);
        int diff = 1 - min;

        for (int i = 0; i < n; i++) {
            candies[i] = candies[i] + diff;
            minCandy += candies[i];
        }


        int current = 0;
        //ascending order forward check
        if (candies[current] > 1) {
            while (current < n - 1) {

                if (candies[current] <= candies[current+1])
                    current++;
                else
                    break;

            }

            for (int i = 0; i < current; i++)
                minCandy = minCandy - 1;
        }


        //descending order forward check
        current = 0;
        if (candies[current] > 2) {

            while (current < n - 1) {

                if(candies[current] >= candies[current+1])
                    current++;
                else
                    break;
            }

            if (candies[current] != 1) {
                for (int i = 0; i <= current; i++)
                    minCandy = minCandy - 1;
            }
        }


        current = n - 1;
        //ascending order backward check
        if (candies[current] > 1) {

            while (current > 0) {

                if (candies[current] <= candies[current - 1])
                    current--;
                else
                    break;
            }

            for (int i = n - 1; i > current; i--)
                minCandy = minCandy - 1;
        }


        //descending order backward check
        current = n - 1;
        if (candies[current] > 2) {

            while (current > 0) {
                if (candies[current] >= candies[current - 1])
                    current--;
                else
                    break;
            }

            if(candies[current] != 1) {
                for (int i = n - 1; i > current; i--)
                    minCandy = minCandy - 1;
            }
        }

        return minCandy;
    }

    private static int candy3 (int[] ratings) {

        int  minCandy = 0;
        int n = ratings.length;
        int[] candies = new int[n];

        //case n == 1
        if (n == 1)
            return 1;

        //case n == 2
        if (n == 2) {
            if (ratings[0] == ratings[1])
                return 2;
            else
                return 3;
        }

        //construct candies array
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



        return minCandy;
    }

    private static int getMinIndex (int ratings[], int n) {
        int min = Integer.MAX_VALUE;
        int minIndex = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++ ) {
            if (ratings[i] < min) {
                min = ratings[i];
                minIndex = i;
            }
        }

        return minIndex;
    }


    private static int getMin (int candies[], int n) {

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++ ) {
            min = Math.min(min, candies[i]);
        }

        return min;
    }

    private static boolean isAllEleSame(int[] ratings, int n) {

        for (int i = 0; i < n; i++)
            if (n != 0)
                if (ratings[n] != ratings[n-1])
                    return false;

        return true;

    }


    public static int candy4 (int[] ratings) {

        int n = ratings.length;

        int[] candies = new int[n];
        candies[0] = 1;

        if (n == 0)
            return 0;

        for (int i = 1; i < n; i++) {

            if (ratings[i] > ratings[i-1])
                candies[i] = candies[i-1] + 1;

            if (ratings[i] == ratings[i-1])
                candies[i] = 1;

            if (ratings[i] < ratings[i-1]) {
                candies[i] = 1;

                if(candies[i-1] == 1) {
                    int j = i;
                    while (j > 0 && ratings[j-1] > ratings[j] && candies[j-1] == candies[j]) {

                        candies[j-1] = candies[j-1] + 1;
                        j--;
                    }
                }
            }

        }

        int sum = 0;
        for (int i =0; i < n; i++) {
            sum += candies[i];
        }

        return sum;
    }

    /*

        2  3  4  1  3  4  7  10  23  5  7
        -2 -1 0 -1 0 (1) 2  3   4  3  4

        -2 -1 -1 0 0 1 2 3 3 4 4

        1   2  2 3 3 4 5 6 6 7 7

     */


    public static void main (String[] args) {

        //int[] ratings = {2, 3, 4, 1, 3, 4, 7, 10, 23, 5, 7};

        //5,1,1,1,10,2,1,1,1,3
        int[] ratings = {5,1,1,1,10,2,1,1,1,3};

        //int[] ratings = {2, 2, 1, 2, 2};
        //int[] ratings = {1,3,4,3,2,1};
        //int[] ratings = {n};
        //int[] ratings = {1,1,1};
        //int[] ratings = {1,3, 5};
        //int[] ratings = {5,3,1};

        //int[] ratings = {1, 0 , 2};


        System.out.println(candy4(ratings));

    }



}








