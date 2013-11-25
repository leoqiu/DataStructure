package LeetCode.recursion;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 11/7/13
 *
 *  http://oj.leetcode.com/problems/climbing-stairs/
 *
 */


public class ClimbingStairs {

    static int numOfWay = 0;

    public int climbStairs(int n) {
        buildPyramid(n, 1);
        //buildPyramid(n, 2);
        return numOfWay;
    }


    public int climbStairsDP(int n) {

        int fn1 = 1;
        int fn2 = 2;

        if (n == 1)
            return fn1;

        if (n == 2)
            return fn2;

        int fn = 0;
        for (int i = 3; i <= n; i++) {

            fn = fn1+fn2;
            fn1 = fn2;
            fn2 = fn;
        }

        return fn;
    }


    private void climbs (int n, int curSteps) {

        if(curSteps == n) {
            numOfWay++;
            return;
        }

        if(curSteps > n)
            return;

        climbs(n, curSteps+1);
        climbs(n, curSteps+2);

    }

    private void buildClimbsTree (int n, Node root, int pathLen) {

        pathLen = root.step + pathLen;

         if (pathLen == n) {
             numOfWay++;
             return;
         }

        if (pathLen > n)
            return;

        Node left = new Node(1);
        root.left = left;
        Node right = new Node(2);
        root.right = right;

        buildClimbsTree(n, left, pathLen);
        buildClimbsTree(n, right, pathLen);
    }

    public void buildPyramid (int n, int rootStep) {

        ArrayList<Integer> odd = new ArrayList<Integer>();
        ArrayList<Integer> even = new ArrayList<Integer>();
        odd.add(rootStep);

        while (true) {

            //set up even row
           for (int i = 0; i < odd.size(); i++) {
                int curLeftSteps = 1+odd.get(i);
                if(curLeftSteps == n)
                    numOfWay++;
                int curRightSteps = 2+odd.get(i);
                if(curRightSteps == n)
                    numOfWay++;
                even.add(i*2, curLeftSteps);
                even.add(i*2+1, curRightSteps);
           }
           if(even.get(0) == n)
                break;
            odd.clear();

           //set up odd row
           for (int i = 0; i < even.size(); i++) {
               int curLeftSteps = 1+even.get(i);
               if(curLeftSteps == n)
                  numOfWay++;
               int curRightSteps = 2+even.get(i);
               if(curRightSteps == n)
                  numOfWay++;
               odd.add(i*2, curLeftSteps);
               odd.add(i*2+1, curRightSteps);
            }
            if(odd.get(0) == n)
                break;
            even.clear();

        }
    }

    class Node {

        int step;
        Node left;
        Node right;

        Node (int step) {
            this.step = step;
        }
    }

    private void printList (ArrayList<Integer> list) {

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

    }


    public static void main (String[] args) {
        ClimbingStairs s = new ClimbingStairs();
        System.out.print(s.climbStairsDP(20));
//        s.climbs(38, 0);
//        System.out.print(numOfWay);
    }

}
