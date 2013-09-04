package GeeksforGeeksAlgorithms.Strings;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: leo
 * Date: 9/2/13
 *
 *
 */
public class CommonPrefixOfNStr {


    public  ArrayList<char[]> getCharArrList () {

        //init dictionary
        String str1 = "acbbdesca2c";
        String str2 = "acbbdea23dfagraasa";
        String str3 = "acbbddfaeadfagraa";
        String str4 = "acbbdeadxcfagraa";
        String str5 = "acbbdeadfcbagraa";
        String str6 = "acbbdeadfae345ngraa";

        char[] charArr1 = str1.toCharArray();
        char[] charArr2 = str2.toCharArray();
        char[] charArr3 = str3.toCharArray();
        char[] charArr4 = str4.toCharArray();
        char[] charArr5 = str5.toCharArray();
        char[] charArr6 = str6.toCharArray();

        ArrayList<char[]> charArrList = new ArrayList<char[]>();
        charArrList.add(charArr1);
        charArrList.add(charArr2);
        charArrList.add(charArr3);
        charArrList.add(charArr4);
        charArrList.add(charArr5);
        charArrList.add(charArr6);

        return charArrList;
    }

    //O(M*N)
    public void commonPrefixOfNStr (ArrayList<char[]> charArrList) {

        int current = 0;
        char preChar = '\0';
        char curChar = '\0';
        boolean isCurAllCharSame = true;

        //m, m is the length of longest common prefix
        while (isCurAllCharSame) {

            //n
            for (int i = 0; i < charArrList.size(); i++) {

                curChar = charArrList.get(i)[current];
                if (preChar == curChar || preChar == '\0') {
                    preChar = curChar;
                } else {
                    isCurAllCharSame = false;
                    break;
                }
            }

            if(isCurAllCharSame){
                preChar = '\0';
                current++;
            }
        }

        if(current == 0)
            System.out.println("Longest common prefix of these strings is empty");
        else {
            System.out.println("Longest common prefix of these strings is :");
            for (int i = 0; i < current; i++) {
                System.out.print(charArrList.get(0)[i]);

            }
        }
    }

    //O(M+N)
    public void commonPrefixOfNStrImproved1 (ArrayList<char[]> charArrList) {

    }

    public static void main (String[] args) {

        CommonPrefixOfNStr cps = new CommonPrefixOfNStr();
        cps.commonPrefixOfNStr(cps.getCharArrList());
    }



}
