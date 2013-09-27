package LeetCode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

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


    public static int mimSum = Integer.MAX_VALUE;


    private static int getPathSum (int[] path, int n, ArrayList<ArrayList<Integer>> triangle) {

        int sum = 0;


        for (int i = 0; i < n; i++) {

            sum = sum + triangle.get(i).get(path[i]);

        }

        return sum;
    }

    private static void getMaxSum (ArrayList<ArrayList<Integer>> triangle, int level, int n, int rootIndex, int curSum) {


        if( n == 0 )
            return;
        else if (level == n) {
            //int curSum = getPathSum(path, n ,triangle);
            mimSum = Math.min(mimSum, curSum);
            return;
        }
        else {

            //path[level] = rootIndex;
            curSum = curSum + triangle.get(level).get(rootIndex);
            level++;

            getMaxSum (triangle, level, n, rootIndex, curSum) ;
            getMaxSum (triangle, level, n, rootIndex + 1, curSum) ;

        }


    }


    private int getCurMin (Stack<Integer> stack) {

        Iterator<Integer> it = stack.iterator();
        int sum = 0;

        while (it.hasNext())
            sum += it.next();

        return sum;

    }

    private int getMaxSum2 (ArrayList<ArrayList<Integer>> triangle, int n, int rootIndex) {

        int level = 0;

        if (n == 0)
            return 0;
        else if (n == 1)
            return triangle.get(level).get(rootIndex);
        else {

            Stack<Integer> stack = new Stack<Integer>();
            stack.push(triangle.get(level).get(rootIndex));
            level++;

            while (!stack.isEmpty()) {



            }




        }



        return 0;


    }

    public static void main (String[] args) {

        ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        list1.add(2);
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        list2.add(3);
        list2.add(4);
        ArrayList<Integer> list3 = new ArrayList<Integer>();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        ArrayList<Integer> list4 = new ArrayList<Integer>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        triangle.add(list1);
        triangle.add(list2);
        triangle.add(list3);
        triangle.add(list4);

        System.out.println(mimSum);
        getMaxSum(triangle, 0, 4, 0, 0);
        System.out.println(mimSum);

        //System.out.print(getMaxSum2(triangle, 1, 4, 0));

    }




}


































