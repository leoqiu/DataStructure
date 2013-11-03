package LeetCode.string;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 11/2/13
 * Time: 8:52 PM
 * To change this template use File | Settings | File Templates.
 */

public class LengthLastWord {

    public int lengthOfLastWord(String s) {

        if(s.length() == 0 || s == null)
            return 0;
        else {

            String[] strs = s.split(" ");

            if(strs.length != 0)
                return strs[strs.length-1].length();
            else
                return 0;
        }
    }

    public static void main (String[ ] args) {

        LengthLastWord s = new LengthLastWord();

        //String str = " ";
        //String str = "a ";
        String str = "a ";

        System.out.print(s.lengthOfLastWord(str));

    }

}
