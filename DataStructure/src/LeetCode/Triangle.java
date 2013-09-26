package LeetCode;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 9/26/13
 *
 *
 * [
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
 ]
 *
 *
 */
public class Triangle {


    public static int maxSum = 0;


    private static int getPathSum (ArrayList<Integer> path, ArrayList<ArrayList<Integer>> triangle) {

        int sum = 0;

        for (int i = 0; i < path.size(); i++) {

            sum = sum + triangle.get(i).get(path.get(i));

        }

        return sum;
    }

    private static void getMaxSum (ArrayList<ArrayList<Integer>> triangle, int level, int n, int rootIndex, ArrayList<Integer> path) {


        if( n == 0)
            return;
        else {

            path.add(rootIndex);

            if (level == n) {
                maxSum = Math.max(maxSum, getPathSum(path, triangle));
            }

            getMaxSum (triangle, level++, n, rootIndex, path) ;
            getMaxSum (triangle, level++, n, rootIndex + 1, path) ;

            path.remove(path.size() - 1);

        }


    }






}


































