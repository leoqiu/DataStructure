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
 *
 *
 *
 *  1. 如果S1[i] == S2[j]。就是i,j对应位置上的字符相等。那么可以得出M[i,j] = M[i-1,j-1]+1;为什么呢？可以想象的。
 *  如果M[i-1,j-1]也是一个最后方案，在这个最优方案上我们同时增加一个字符。而这两个字符又相等。那么我们只需要在这个M[i-1,j-1]的最优方案上++就可以了。
 *
 *  2. 如果S1[i] != S2[j]。那么就拿M[i-1,j]和M[i,j-1]来比较。M[i,j]的值就是M[i-1,j]和M[i,j-1]中大的值。这好比原来的字符串是S1[1...i-1]是ABC，S2[1...j-1]是ABE。
 *  那S1[1..i]是ABCE，S2[1..j]是ABEC。可以看出来这个时候M[i,j]不是由M[i-1,j-1]决定的，而是由ABCE和ABE或者ABC和ABEC来决定的，也就是M[i-1,j]和M[i,j-1]。
 *
 *
 *            C[i-1][j-1] + 1, X[i] == Y[j]
 * C[i][j] =
 *            MAX( C[i-1][j], C[i][j-1] ),   X[i] != Y[j]
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
    }


    //String strX = "ACCGGGTTACCGTTT";
    //String strX = "ACGTCGTT";
    String strX = "ABCBDAB";
    char[] X = strX.toCharArray();

    //String strY = "CCAGGACCAGGGACCGTTTA";
    //String strY = "CCACAGGTTA";
    String strY = "BDCABA";
    char[] Y = strY.toCharArray();

    //array to store subsequence lengths  int[row][col]
    //X.len = 9, Y.len = 10
    int[][] lenArr = new int[X.length+1][Y.length+1];


    public void calSizeOfLCS () {

        //initialize array to store size of subsequence lengths

        for (int i = 0; i < X.length; i++) {
            for (int j = 0; j < Y.length; j++) {
                if (X[i] == Y[j]) {
                    lenArr[i+1][j+1] = lenArr[i][j] + 1;
                } else  {
                    if(lenArr[i][j+1] > lenArr[i+1][j])
                        lenArr[i+1][j+1] = lenArr[i][j+1];
                    else
                        lenArr[i+1][j+1] = lenArr[i+1][j];
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






















































