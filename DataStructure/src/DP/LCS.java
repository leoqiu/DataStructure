package DP;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 8/19/13
 * Time: 4:05 PM
 * To change this template use File | Settings | File Templates.
 */


public class LCS {
    public static void main(String[] args) {
        char[] string = "abcbbc".toCharArray();
        char[] string2 = "abccbb".toCharArray();

        findLCS(string, string2);
    }
    /**
     *
     * @param string
     * @param string2
     */
    public static void findLCS(char[] string ,char[] string2) {
        int m = string.length;
        int n = string2.length;
        int[][] c = new int[m+1][n+1];
        int[][] b = new int[m+1][n+1];
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(string[i]==string2[j]) {
                    c[i+1][j+1]=c[i][j]+1;
                    b[i+1][j+1]= '\\';
                } else {
                    if(c[i][j+1] >= c[i+1][j]) {
                        c[i+1][j+1] = c[i][j+1];
                        b[i+1][j+1]= '|';
                    } else {
                        c[i+1][j+1] = c[i+1][j];
                        b[i+1][j+1]= '-';

                    }
                }
            }
        }

        System.out.println("LCS长度:"+c[m][n]);

        System.out.println("LCS序列:");
        printLCS(b,string,m,n);
    }
    private static void printLCS(int[][] b, char[] string, int i, int j) {
        if(i==0 || j==0) {
            return ;
        }

        if(b[i][j]=='\\') {
            printLCS(b, string, i-1, j-1);
            System.out.println(string[i-1]);
        } else if(b[i][j]=='|'){
            printLCS(b, string, i-1, j);
        } else {
            printLCS(b, string, i, j-1);
        }

    }

}
