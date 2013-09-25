package LeetCode;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 9/24/13
 * Time: 3:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class NQueensImproved {

    private static int sum = 0;


    private static boolean isCanBePlaced(int n, int[] queens, int row, int col) {

        for (int i = 0; i < n; i++) {

            if (queens[i] == col)
                 return false;

            if (Math.abs(i - row) == Math.abs(queens[i] - col) )
                 return false;

        }

        return true;
    }

    private static void printQueens (int[] queens, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("(" + i + ", " + queens[i] + ")");
        }
        System.out.println();
    }

    public static void getChessBoard (int[] queens, int n, int row) {

        if (row == n) {
           //printQueens(queens, n);
           sum++;
        } else {
            for (int i = 0; i < n; i++) {


                if(isCanBePlaced(n, queens, row, i)) {

                    queens[row] = i;
                    //printQueens(queens, n);
                    getChessBoard(queens, n, row+1);

                }
            }

            queens[row] = Integer.MAX_VALUE;
        }
    }

    public int totalNQueens(int n) {
        int[] queens = new int[n];
        for (int i = 0; i < n; i++) {
            queens[i] = Integer.MAX_VALUE;
        }
        getChessBoard(queens, n, 0);

        return sum;
    }


    public static void main (String[] args) {
//        int n = 4;
//        int[] queens = new int[n];
//        for (int i = 0; i < n; i++) {
//            queens[i] = Integer.MAX_VALUE;
//        }
//        getChessBoard(queens, n, 0);
        NQueensImproved nqi = new NQueensImproved();
        System.out.print(nqi.totalNQueens(15));

    }

}
