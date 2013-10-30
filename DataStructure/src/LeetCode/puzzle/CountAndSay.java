package LeetCode.puzzle;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 10/29/13
 *
 *
 *
 */


public class CountAndSay {



    public String countAndSay(int n) {

        if (n == 1)
            return "1";
        else if (n == 2)
            return "11";
        else {

            String preStr = countAndSay(n-1);
            StringBuilder curStr = new StringBuilder();

            for (int i = 0; i < preStr.length(); i++) {

                char cur = preStr.charAt(i);
                int count = 1;

                if (i < preStr.length() - 1 && cur == preStr.charAt(i+1)) {
                    while (i < preStr.length() - 1 && cur == preStr.charAt(i+1)) {
                        count++;
                        i++;
                    }

                    curStr.append(count).append(cur);
                } else
                    curStr.append('1').append(cur);


            }

            return curStr.toString();

        }
    }

    public static void main (String[] args) {

        CountAndSay s = new CountAndSay();
        System.out.print(s.countAndSay(25));
        //StringBuilder curStr = new StringBuilder();
        //System.out.print(curStr.append(3).toString());
    }







}
