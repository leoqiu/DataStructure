package DP;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 8/20/13
 */
class StrInfo {
    int times;
    boolean isFirstOccurrence;
}


public class DisplayAllLCS {

    //String strX = "ABCBDAB";
    String strX = "ACGTCGTT";
    char[] X = strX.toCharArray();
    //String strY = "BDCABA";
    String strY = "CCACAGGTTA";
    char[] Y = strY.toCharArray();

    StrInfo[][] infoArr = new StrInfo[X.length + 1][Y.length + 1];

    private void initInfoArr () {
        for (int i = 0; i < infoArr.length; i++) {

            for (int j = 0; j < infoArr[0].length; j++) {

                infoArr[i][j] = new StrInfo();
                infoArr[i][j].times = 0;
                infoArr[i][j].isFirstOccurrence = false;
            }
        }
    }

    private void printInfoArr () {
        for (int i = 0; i < infoArr.length; i++) {

            for (int j = 0; j < infoArr[0].length; j++) {
                System.out.print("[" + infoArr[i][j].times + "," + infoArr[i][j].isFirstOccurrence + "]  ");
            }
            System.out.println();
            //System.out.println();
        }

    }

    public void calLCSInfoArr () {

        initInfoArr();

        for (int i = 0; i < X.length; i++) {
            for (int j = 0; j < Y.length; j++) {

                if(X[i] == Y[j]) {
                    infoArr[i+1][j+1].times = infoArr[i][j].times + 1;
                    infoArr[i+1][j+1].isFirstOccurrence = true;
                } else {
                    if (infoArr[i+1][j].times > infoArr[i][j+1].times)
                        infoArr[i+1][j+1].times = infoArr[i+1][j].times;
                    else
                        infoArr[i+1][j+1].times = infoArr[i][j+1].times;
                }

//                if (infoArr[i+1][j+1].times == infoArr[i][j].times + 1) {
//                    infoArr[i+1][j+1].isFirstOccurrence = true;
//                }

            }
        }

        printInfoArr();

    }

    public void findAllLCS () {

        ArrayList<ArrayList<Character>> lcsList = new ArrayList<ArrayList<Character>>();

        for (int i = 1; i < infoArr.length; i++ ) {
            ArrayList<Character> charList = new ArrayList<Character>();

            int row = i;
            int col = 1;
            int nextStart = 1;

            while (row < infoArr.length) {

                col = nextStart;
                while (col < infoArr[row].length) {

                    if(infoArr[row][col].isFirstOccurrence) {
                        //string starts from position 1 of infoArr
                        charList.add(Y[col - 1]);
                        nextStart = col + 1;
                        break;
                    }
                    col++;
                }

                row++;

            }

            lcsList.add(charList);
        }

        System.out.println(lcsList);
    }


    public static void main (String[] args) {
        DisplayAllLCS daLCS = new DisplayAllLCS();
        daLCS.calLCSInfoArr();
        daLCS.findAllLCS();
    }





}
