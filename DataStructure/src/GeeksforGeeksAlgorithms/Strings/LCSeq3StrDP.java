package GeeksforGeeksAlgorithms.Strings;

/**
 * Created with IntelliJ IDEA.
 * User: leo
 * Date: 9/2/13
 *
 *
 *
 */
public class LCSeq3StrDP {



    public static void main (String[] args) {

        LCSeq3StrDP lcSeq3StrDP = new LCSeq3StrDP();
        lcSeq3StrDP.lcSeq3StrDP();

    }


    /**
     * 2 strings  : totally has 3 different directions to go
     *      1. dpArr[i+1][j+1] = dpArr[i][j] + 1, X[i] == Y[j]
     *      2. dpArr[i+1][j+1] = Max(dpArr[i+1][j], dpArr[i][j+1]), X[i] != Y[j]
     *
     * 3 strings  : totally has 7 different directions to go
     *      1. dpArr[i+1][j+1][k+1] = dpArr[i][j][k] + 1, X[i] == Y[j] == Z[k]
     *      2. dpArr[i+1][j+1][k+1] = Max(dpArr[i+1][j][k], dpArr[i][j+1][k], dpArr[i+1][j+1][k], dpArr[i][j][k+1], dpArr[i+1][j][k+1], dpArr[i+1][j][k+1], dpArr[i][j+1][k+1]),
     *      X[i] != Y[j] or Y[j] != Z[k] or X[i] != Z[k]
     *
     *
     */
    public void lcSeq3StrDP () {

//        String strX = "CAGTGFDFDFBJOOEOJGTT";
//        String strY = "ACCGHYIO8DFHAAACAGGTT";
//        String strZ = "ACCACAGGTBBASSDFHQEREVET";
        String strX = "ACBGTCGTTA";
        String strY = "ACCBACAGGTTA";
        String strZ = "ACCABCAGGTTA";

        char[] X = strX.toCharArray();
        char[] Y = strY.toCharArray();
        char[] Z = strZ.toCharArray();

        int curLen = 0;
        int maxLen = 0;

        //dp Array
        int[][][] dpArr = new int[X.length+1][Y.length+1][Z.length+1];
        int[][][] dpDirArr = new int[X.length+1][Y.length+1][Z.length+1];

        for (int i = 0; i < X.length; i++) {
            for (int j = 0; j < Y.length; j++) {
                for (int k = 0; k < Z.length; k++) {
//
//                    if(i == 0 || j == 0 || k == 0)
//                        dpArr[i][j][k] = 0;
                    if (X[i] == Y[j] && Y[j] == Z[k]) {

                        dpArr[i+1][j+1][k+1] = dpArr[i][j][k] + 1;
                        //direction array , x is aix 1, y is aix 2, z is aix 3
                        dpDirArr[i+1][j+1][k+1] = 123;


                    } else {
                        //has 6 different directions to go
                        dpArr[i+1][j+1][k+1] = Math.max(Math.max(dpArr[i+1][j][k], dpArr[i][j+1][k]), Math.max(Math.max(dpArr[i+1][j+1][k],
                                dpArr[i][j][k+1]), Math.max(dpArr[i+1][j][k+1], dpArr[i][j+1][k+1])));

                        //023
                        if (dpArr[i+1][j][k] == Math.max(Math.max(dpArr[i+1][j][k], dpArr[i][j+1][k]), Math.max(Math.max(dpArr[i+1][j+1][k],
                                dpArr[i][j][k+1]), Math.max(dpArr[i+1][j][k+1], dpArr[i][j+1][k+1])))) {
                            dpDirArr[i+1][j+1][k+1] = 023;

                        //103
                        } else if (dpArr[i][j+1][k] == Math.max(Math.max(dpArr[i+1][j][k], dpArr[i][j+1][k]), Math.max(Math.max(dpArr[i+1][j+1][k],
                                dpArr[i][j][k+1]), Math.max(dpArr[i+1][j][k+1], dpArr[i][j+1][k+1])))) {
                            dpDirArr[i+1][j+1][k+1] = 103;

                        //003
                        } else if (dpArr[i+1][j+1][k] == Math.max(Math.max(dpArr[i+1][j][k], dpArr[i][j+1][k]), Math.max(Math.max(dpArr[i+1][j+1][k],
                                dpArr[i][j][k+1]), Math.max(dpArr[i+1][j][k+1], dpArr[i][j+1][k+1])))) {
                            dpDirArr[i+1][j+1][k+1] = 003;

                        //120
                        } else if (dpArr[i][j][k+1] == Math.max(Math.max(dpArr[i+1][j][k], dpArr[i][j+1][k]), Math.max(Math.max(dpArr[i+1][j+1][k],
                                dpArr[i][j][k+1]), Math.max(dpArr[i+1][j][k+1], dpArr[i][j+1][k+1])))) {
                            dpDirArr[i+1][j+1][k+1] = 120;

                        //020
                        } else if (dpArr[i+1][j][k+1] == Math.max(Math.max(dpArr[i+1][j][k], dpArr[i][j+1][k]), Math.max(Math.max(dpArr[i+1][j+1][k],
                                dpArr[i][j][k+1]), Math.max(dpArr[i+1][j][k+1], dpArr[i][j+1][k+1])))) {
                            dpDirArr[i+1][j+1][k+1] = 020;

                        //100
                        } else if (dpArr[i][j+1][k+1] == Math.max(Math.max(dpArr[i+1][j][k], dpArr[i][j+1][k]), Math.max(Math.max(dpArr[i+1][j+1][k],
                                dpArr[i][j][k+1]), Math.max(dpArr[i+1][j][k+1], dpArr[i][j+1][k+1])))) {
                            dpDirArr[i+1][j+1][k+1] = 100;

                        }

                    }

                }
            }
        }

        System.out.println("Longest common subsequence size is: " + dpArr[X.length][Y.length][Z.length]);

        printLCSeq3Str (dpDirArr, X, X.length, Y.length, Z.length);
    }

    private void printLCSeq3Str (int[][][] dpDirArr, char[] X, int i, int j, int k) {

        if(i == 0 || j == 0 || k == 0)
            return;
        else {

            if(dpDirArr[i][j][k] == 123) {
                printLCSeq3Str(dpDirArr, X, i - 1, j - 1, k - 1);
                System.out.print(X[i-1] + "");
            }if(dpDirArr[i][j][k] == 023) {
                printLCSeq3Str(dpDirArr, X, i, j-1, k-1);
            }else if(dpDirArr[i][j][k] == 103) {
                printLCSeq3Str(dpDirArr, X, i-1, j, k-1);
            }else if(dpDirArr[i][j][k] == 003) {
                printLCSeq3Str(dpDirArr, X, i, j, k-1);
            } else if(dpDirArr[i][j][k] == 120) {
                printLCSeq3Str(dpDirArr, X, i-1, j-1, k);
            } else if(dpDirArr[i][j][k] == 020) {
                printLCSeq3Str(dpDirArr, X, i, j-1, k);
            } else if(dpDirArr[i][j][k] == 100) {
                printLCSeq3Str(dpDirArr, X, i-1, j, k);
            }
        }

    }

}






















































