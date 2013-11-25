package LeetCode.ArrayIntegers;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 11/7/13
 *
 *
 *
 */



public class SearchTwoDMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;

        int up = 0;
        int bottom = m-1;
        while (up <= bottom) {

            int middle = up + (bottom-up)/2;

            if(target < matrix[middle][0])
                bottom = middle-1;
            else if (target > matrix[middle][0])
                up = middle+1;
            else
                return true;
        }

        int tmp = up;
        up = bottom;
        bottom = tmp;

        //corner case , [[1]], 0
        if(up < 0 )
            return false;

        if(bottom <= m-1 && target == matrix[bottom][0])
            return true;
        else {
            int left = 0;
            int right = n-1;

            while(left <= right) {
                int middle = left + (right-left)/2;

                if(target < matrix[up][middle])
                    right = middle-1;
                else if (target > matrix[up][middle])
                    left = middle+1;
                else
                    return true;
            }
        }

        return false;
    }



    public ArrayList<Integer> binarySearchFact (int target) {
        //set target as 9, return (8, 7)

        int[] arr = {1,2,3,4,5,6,7,8,10,11,12,13,14,19};
        ArrayList<Integer> list = new ArrayList<Integer>();

        int left = 0;
        int right = arr.length-1;

        while (left <= right) {

            int middle = left + (right-left)/2;
            if(target < arr[middle])
                right = middle-1;
            else if(target > arr[middle])
                left = middle+1;
            else {
                list.add(middle);
                return list;
            }


        }

        list.add(left);
        list.add(right);
        return list;

    }




    public static void main (String[] args) {

//        SearchTwoDMatrix s = new SearchTwoDMatrix();
//        System.out.print(s.binarySearchFact(16));

        int[][] matrix = {
                {1,3},
                {4,5}

        };

        SearchTwoDMatrix s = new SearchTwoDMatrix();
        System.out.print(s.searchMatrix(matrix, 3));

    }

}


































