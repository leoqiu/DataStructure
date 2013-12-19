package LeetCode.puzzle;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 11/13/13
 *
 *
 * http://oj.leetcode.com/problems/maximal-rectangle/
 *
 */



public class MaximalRectangle {


    public int maximalRectangle(char[][] matrix) {

        int m = matrix.length;
        if(m == 0)
            return 0;

        int n = matrix[0].length;
        //int[][] visits = new int[m][n];
        int maxArea = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if(matrix[i][j] == '1') {
                    int curArea = findArea(i, j, matrix, m, n);
                    maxArea = Math.max(curArea, maxArea);
                }
            }
        }

        return maxArea;
    }


    private int findArea (int ii, int jj, char[][] matrix, int m, int n) {

        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int i = ii; i < m; i++) {

            if(matrix[i][jj] != '1')
                break;
            int count = 0;
            for(int j = jj; j < n; j++) {

                if(matrix[i][j] == '1') {
                    count++;
                    //visits[i][j] = 1;
                } else
                    break;
            }
            list.add(count);
        }

        return getMaxArea(list);
    }

    private int getMaxArea (ArrayList<Integer> list) {

        int maxArea = 0;

        for (int i = 0; i < list.size(); i++) {
            int minHeight = list.get(i);
            for(int j = i; j >=0; j--) {
               minHeight = Math.min(minHeight, list.get(j));
               maxArea = Math.max(maxArea, minHeight*(i-j+1));
            }
        }
        return maxArea;
    }

    public static void main (String[] args) {

        MaximalRectangle s = new MaximalRectangle();
//        char[][] matrix = {
//                {'0', '0', '0', '1', '1', '0'},
//                {'0', '0', '0', '1', '1', '1'},
//                {'0', '0', '0', '0', '1', '1'},
//                {'1', '1', '1', '1', '1', '1'},
//                {'1', '1', '1', '1', '1', '1'},
//                {'0', '0', '0', '0', '1', '1'},
//                {'0', '0', '0', '1', '1', '1'},
//
//        };

        char[][] matrix = {
                {'0', '1', '1', '0', '1'},
                {'1', '1', '0', '1', '0'},
                {'0', '1', '1', '1', '0'},
                {'1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'0', '0', '0', '0', '0'},

        };

        //corner case beat visits[][]
//        char[][] matrix = {
//                {'0', '1', '1'},
//                {'1', '0', '1'},
//                {'0', '1', '1'},
//                {'1', '1', '0'},
//                {'0', '0', '0'},
//                {'0', '1', '0'},
//
//        };

        System.out.print(s.maximalRectangle(matrix));

    }

}






























