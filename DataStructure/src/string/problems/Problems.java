package string.problems;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu


 */
public class Problems {


    /**
     *
     * problem #7 - reverse the string without using any temporary variable
     *
     *
     * @param
     */
    public void reverseString () {

        String str = "abcdef";

        int i = 0;
        int j = str.length() - 1;

        while ( i < j) {




        }
    }

    /**
     *
     * permutation of a string
     *
     * This one can not deal with duplicates
     *
     * @param
     */
    public void permutationInOrder (String prefix, String str) {

        int len = str.length();
        if(len == 0)
            System.out.println(prefix);
        else {

            for (int i = 0; i < len; i++)
                permutationInOrder(prefix+str.charAt(i), str.substring(0, i) + str.substring(i+1));

        }
    }























    public static void main (String[] args) {


        Problems p = new Problems();
        p.permutationInOrder("", "aab");

    }



}


























































