package LeetCode.string;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 11/20/13
 *
 *
 *
 */



public class DistinctSubsequences {


    public int numDistinctR(String S, String T) {

        int i = 0;
        for (int m = 0; m < S.length(); m++) {
            if(S.charAt(m) == T.charAt(0)) {
                i = m;
                break;
            }
        }

        return numDisRR(S, i, T, 0);
    }


    private int numDisRR (String S, int i, String T, int j) {

        if (j == T.length()) {
            System.out.println(i + " - " + j);
            return 1;
        }

        int count = 0;
         for (int k = i; k < S.length(); k++) {
            if(S.charAt(k) == T.charAt(j)) {
                count += numDisRR(S, k+1, T, j+1);
            }
        }
        return count;
    }

    public static void main (String[] args) {
        DistinctSubsequences s = new DistinctSubsequences();

        String S = "rabbbit";
        String T = "rabbit";

//        String S = "aabdbaadcbbdedacb";
//        String T = "babd";
        System.out.print(s.numDistinctR(S, T));

    }

}










































