package LeetCode.ArrayIntegers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 11/7/13
 *
 *
 *
 */


public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {

        HashSet<Integer> setRow = new HashSet<Integer>();
        HashSet<Integer> setCol = new HashSet<Integer>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++)
                if(matrix[i][j] == 0){
                    setRow.add(i);
                    setCol.add(j);
                }
        }

        Iterator<Integer> itRow = setRow.iterator();
        Iterator<Integer> itCol = setCol.iterator();

        while (itRow.hasNext()) {
            int cur = itRow.next();
            for (int j = 0; j < matrix[cur].length; j++)
                matrix[cur][j] = 0;

        }

        while (itCol.hasNext()) {
            int cur = itCol.next();
            for (int i = 0; i < matrix.length; i++)
                matrix[i][cur] = 0;

        }
    }

}





































