package LeetCode.puzzle;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 10/30/13
 * Time: 8:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class MultiplyStrings {

    public String multiply(String num1, String num2) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.

        long number1 = Integer.parseInt(num1);
        long number2 = Integer.parseInt(num2);
        long res = number1*number2;

        return String.valueOf(res);

    }


    public static void main (String[] arg) {

        MultiplyStrings s = new MultiplyStrings();
        String num1 = "6913259244";
        String num2 = "71103343";
        System.out.print(s.multiply(num1, num2));

    }

}
