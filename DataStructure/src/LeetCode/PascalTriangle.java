package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: leo
 * Date: 9/27/13
 *
 *
 *
 *
 *
 [
 [1],
 [1,1],
 [1,2,1],
 [1,3,3,1],
 [1,4,6,4,1]
 ]
 *
 */



public class PascalTriangle {


    public ArrayList<int[]> generate(int numRows) {
        ArrayList<int[]> pTriangle = new ArrayList<int[]>();

        int level = 0;

        while (level < numRows) {

            int[] curList = new int[level+1];

            //first last as 1
            curList[0] = 1;
            curList[level] = 1;

            for (int i = 1; i < level ; i++) {

                int left = pTriangle.get(level - 1)[i-1];
                int right = pTriangle.get(level - 1)[i];
                curList[i] = left + right;

            }

            pTriangle.add(curList);
            level++;

        }

        return pTriangle;
    }


    public void printPascalTriangle (ArrayList<int[]> pTriangle) {

        for (int i = 0; i < pTriangle.size(); i++) {
            int[] curList = pTriangle.get(i);
            for (int j = 0; j < curList.length; j++) {
                System.out.print(curList[j] + " ");
            }
            System.out.println();
        }

    }




    public static void main (String[] args) {

        PascalTriangle pt = new PascalTriangle();

        pt.printPascalTriangle(pt.generate(10));


    }


}












































