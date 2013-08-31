package GeeksforGeeksAlgorithms.Strings;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 8/28/13
 *
 *
 *  http://www.geeksforgeeks.org/category/c-strings/
 */
public class problems {

    private void printCharA (char[] charA) {

        for(int i = 0; i < charA.length; i++) {
            if(charA[i] != '\0')
            System.out.print(charA[i]);
        }

    }

    /**
     * http://www.geeksforgeeks.org/remove-a-and-bc-from-a-given-string/
     *
     * Problem #1. Remove “b” and “ac” from a given string
     *
     * Examples:
     * acbac   ==>  ""
     * aaac    ==>  aa
     * ababac  ==>   aa
     * bbbbd   ==>   d
     *
     */
    public void removeBAndAC  () {

        //String str = "ababac";
        String str = "abcaaccd";

        char[] charA = str.toCharArray();

        int index1 = 0;


        while (index1 < charA.length) {

            while ( index1 < charA.length && charA[index1] != 'b' && charA[index1] != 'a' ) {
                index1++;
            }

            if (index1 < charA.length && charA[index1] == 'b') {
                charA[index1] = '\0';
                index1++;
            }

            if (index1 < charA.length && charA[index1] == 'a') {
                if(index1 + 1 == charA.length)
                    break;
                else if (charA[index1+1] == 'c') {
                    charA[index1] = '\0';
                    charA[index1+1] = '\0';
                    index1 = index1 + 2;
                } else
                    index1++;
            }

        }

        printCharA (charA);
        //System.out.print(new String(charA));
    }

    public void removeBAndACImproved  () {

        //String str = "ababac";
        //String str = "aacacca";
        String str = "abcaaccd";

        char[] charA = str.toCharArray();

        int index1 = 0;
        //for tracing back 'c'
        int index2 = -1;

        while (index1 < charA.length) {

            while ( index1 < charA.length && charA[index1] != 'b' && charA[index1] != 'a' ) {
                index1++;
            }

            if (index1 < charA.length && charA[index1] == 'b') {
                charA[index1] = '\0';
                index1++;
            }

            if (index1 < charA.length && charA[index1] == 'a') {
                if(index1 + 1 == charA.length)
                    break;
                else if (charA[index1+1] == 'c') {
                    charA[index1] = '\0';
                    charA[index1+1] = '\0';
                    index1 = index1 + 2;
                } else
                    index1++;
            }

            if (index1 < charA.length && charA[index1] == 'c')
                index2 = index1;

            while (index2 >= 0) {
                if(charA[index2] == 'a') {
                    charA[index2] = '\0';
                    charA[index1] = '\0';
                    index2 = -1;
                    break;
                }
                index2--;
            }
        }

        printCharA (charA);
    }


    /**
     *
     * problem #2. Longest Common Substring
     *
     * eg.
     * input "GeeksforGeeks"
     * input "GeeksQuiz"
     * output "Geeks"
     *
     *
     *
     * @param
     */
    public void lcSubStr () {

        String str1 = "OldSite:GeeksforGeeks.org";
        String str2 = "NewSite:GeeksQuiz.com";

        char[] charArr1 =str1.toCharArray();
        char[] charArr2 =str2.toCharArray();

        int curStart = -1;
        int curEnd = -1;

        int finalStart = -1;
        int finalEnd = -1;

        int maxSubLen = 0;

        for (int i = 0; i < charArr1.length; i++) {
            for (int j = 0; j < charArr2.length; ) {

                int current1 = i;
                if (charArr1[current1] == charArr2[j]) {
                    curStart = j;

                    while (j < charArr2.length && current1 < charArr1.length && charArr1[current1] == charArr2[j]) {
                        current1++;
                        j++;
                    }

                    curEnd = j - 1;

                    int currentSubLen = curEnd - curStart + 1;
                    if (currentSubLen > maxSubLen) {
                        maxSubLen = currentSubLen;
                        finalStart = curStart;
                        finalEnd = curEnd;
                    }

                } else
                    j++;
            }
        }

        for (int i = finalStart; i <= finalEnd; i++) {
            System.out.print(charArr2[i]);
        }
    }

    /**
     *
     * dpArr[i][j] = dpArr[i-1][j-1] + 1 , charArr1[i-1] == charArr2[j-1]
     *
     */
    public void lcSubStrDP () {

        String str1 = "OldSite:GeeksforGeeks.org";
        String str2 = "NewSite:GeeksQuiz.com";

        char[] charArr1 =str1.toCharArray();
        char[] charArr2 =str2.toCharArray();

        //length record
        int[][] dpArr = new int[charArr1.length+1][charArr2.length+1];
        //string index record
        char[][] dpArr2 = new char[charArr1.length+1][charArr2.length+1];
        int currentLcsLen = 0;
        int maxLcsLen = 0;

        for (int i = 0; i < charArr1.length; i++) {
            for (int j = 0; j < charArr2.length; j++) {

                if (i == 0 || j == 0)
                    dpArr[i][j] = 0;
                else if (charArr1[i-1] == charArr2[j-1]) {
                    dpArr[i][j] = dpArr[i-1][j-1] + 1;
                    dpArr2[i][j] = '\\';
                    currentLcsLen = Math.max(currentLcsLen, dpArr[i][j]);

                    if(currentLcsLen > maxLcsLen)
                        maxLcsLen = currentLcsLen;

                }else
                    dpArr[i][j] = 0;
            }
        }

        //print array
        for (int i = 0; i < dpArr.length; i++) {
            for (int j = 0; j < dpArr[0].length; j++) {
                System.out.print(dpArr[i][j] + " ");
            }
            System.out.println();

        }

        System.out.println(maxLcsLen);

        //print the LCS
        printLCS(dpArr, maxLcsLen, charArr2);

    }

    private void printLCS (int[][] dpArr, int maxLen, char[] charArr2) {

        int indexOfLast1 = -1;
        int indexOfLast2 = -1;

        for (int i = 0 ; i < dpArr.length; i++) {
            for (int j = 0; j < dpArr[0].length; j++) {
                if (dpArr[i][j] == maxLen) {
                    indexOfLast1 = i;
                    indexOfLast2 = j;
                }
            }
        }

        printStr(dpArr, charArr2, indexOfLast1, indexOfLast2);

    }

    private void printStr (int[][] dpArr, char[] charArr1, int index1, int index2) {

        if(dpArr[index1][index2] == 0){
            return;
        }
        else {
            printStr(dpArr, charArr1, index1 - 1, index2 - 1);
            //charArr start from index 1 of dpArr
            System.out.print(charArr1[index1-1] + " ");
        }

    }




    /**
     *
     * Longest common substring among 3 string
     *
     * http://stackoverflow.com/questions/7950244/longest-common-substring-among-3-strings
     *
     * @param
     */
    public void lcSubStrDP3Str () {

        String str1 = "OldSite:GeeksforGeeks.org";
        String str2 = "NewSite:GeeksQuiz.com";
        String str3 = "HAHANewSite:GeeksQduiz.com";

        char[] charArr1 = str1.toCharArray();
        char[] charArr2 = str2.toCharArray();
        char[] charArr3 = str3.toCharArray();

        for (int i = 0; i < charArr1.length; i++) {

            for (int j = 0; j < charArr2.length; j++) {

                for (int m = 0; m < charArr3.length; m++) {



                }

            }


        }

    }

    /**
     * longest common substring dp solution
     *
     * dpArr[i][j][k] = dpArr[i-1][j-1][k-1] + 1 , charArr1[i] == charArr2[j] == charArr[k]
     *
     */
    public void lcSubStrDP3StrDP () {

        String str1 = "OldSite:GeeksforGeeks.org";
        String str2 = "NewSite:GeeksQuiz.com";
        String str3 = "HAHANewSite:GeeksQduiz.com";

        char[] charArr1 = str1.toCharArray();
        char[] charArr2 = str2.toCharArray();
        char[] charArr3 = str3.toCharArray();

        int curLen = 0;
        int maxLen = 0;

        int[][][] dpArr = new int[charArr1.length+1][charArr2.length+1][charArr3.length+1];

        for (int i = 0; i < dpArr.length; i++) {

            for (int j = 0; j < dpArr[i].length; j++) {

                for (int k = 0; k < dpArr[i][j].length; k++) {

                    if (i == 0 || j == 0 || k == 0) {
                        dpArr[i][j][k] = 0;
                    } else if ( (charArr1[i-1] == charArr2[j-1]) && (charArr2[j-1] == charArr3[k-1])) {

                        dpArr[i][j][k] = dpArr[i-1][j-1][k-1] + 1;
                        curLen = Math.max(curLen, dpArr[i][j][k]);

                        if(curLen > maxLen)
                            maxLen = curLen;

                    } else
                        dpArr[i][j][k] = 0;
                }
            }
        }

        //print 3 dimensions array

        //print the longest common substring of 3 strings
        printLCS3StrDP(dpArr, maxLen, charArr1);


    }

    private void printLCS3StrDP (int[][][] dpArr, int maxLen, char[] charArr1) {

        int index1 = -1;
        int index2 = -1;
        int index3 = -1;

        for (int i = 0; i < dpArr.length; i++) {

            for (int j = 0; j < dpArr[i].length; j++) {

                for (int k = 0; k < dpArr[i][j].length; k++) {

                    if(dpArr[i][j][k] == maxLen) {
                        index1 = i;
                        index2 = j;
                        index3 = k;
                    }
                }
            }
        }

        printStr3StrDP (dpArr, charArr1, index1, index2, index3);

    }

    private void printStr3StrDP (int[][][] dpArr, char[] charArr1, int index1, int index2, int index3) {

        if(dpArr[index1][index2][index3] == 0)
            return;
        else {
            printStr3StrDP (dpArr, charArr1, index1 - 1, index2 - 1, index3 - 1);
            System.out.print(charArr1[index1-1] + " ");

        }
    }


    /**
     * Common prefix of three string
     *
     *
     * @param
     */


    public static void main (String[] args) {
        problems p = new problems();
        //p.removeBAndAC();
        //p.removeBAndACImproved();
        //p.lcSubStr();
        //p.lcSubStrDP();
        p.lcSubStrDP3StrDP();
    }


}






















