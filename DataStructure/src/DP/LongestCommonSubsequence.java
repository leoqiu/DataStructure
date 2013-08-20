package DP;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 8/19/13
 *
 */


/**
 *
 * X = ACCGGGTTACCGTTT
 * Y = CCAGGACCAGGGACCGTTTA
 *
 *
 * Define:
 * C[i][j] -- length of LCS of sequence X[1...i] and Y[1...j]
 * Thus : C[i][0] == 0 for all i
 *        C[0][j] == 0 for all j
 * Goal: Find C[N][M]
 *
 *
 *            C[i-1][j-1] + 1, X[i] == Y[j]
 * C[i][j] =
 *            MAX( C[i-1][j], C[i][j-1] ),   X[i] != Y[j]
 *
 *
 */

public class LongestCommonSubsequence {

    //print subsequence lengths array
    private void printTwoDimensionArray (int[][] array) {

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "  ");
            }
            System.out.println();
        }


        System.out.println(array.length);
        System.out.println(array[0].length);
    }


    //String strX = "ACCGGGTTACCGTTT";
    String strX = "ACGTCGTT";
    //String strX = "ACCGGGTTAC";
    //String strX = "AC";
    char[] X = strX.toCharArray();

    //String strY = "CCAGGACCAGGGACCGTTTA";
    String strY = "CCACAGGTTA";
//String strY = "AGGACCA";
    char[] Y = strY.toCharArray();

    //array to store subsequence lengths  int[row][col]
    //X.len = 9, Y.len = 10
    int[][] lenArr = new int[X.length+1][Y.length+1];


    public void calSizeOfLCS () {

//        printTwoDimensionArray(lenArr);
//        System.out.println(lenArr.length);
//        System.out.println(lenArr[0].length);
        //initialize array to store size of subsequence lengths

        for (int i = 0; i < X.length; i++) {
            for (int j = 0; j < Y.length; j++) {
                if (X[i] == Y[j]) {
                    lenArr[i+1][j+1] = lenArr[i][j] + 1;
                } else  {
                    lenArr[i+1][j+1] = Math.max(lenArr[i][j+1] , lenArr[i+1][j]);
                }
            }
        }

       printTwoDimensionArray(lenArr);

    }



    public static void main (String[] args) {

        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        lcs.calSizeOfLCS();

    }





}






















































