package LeetCode.string;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 11/7/13
 *
 *   http://discuss.leetcode.com/questions/97/minimum-window-substring
 *
 */




public class MinimumWindowSubstring {



    public String minWindow(String S, String T) {

//        if(S.length() < T.length())
//            return "";

        HashMap<Character, Integer> hashT = new HashMap<Character, Integer>();
        HashMap<Character, Integer> hashS = new HashMap<Character, Integer>();

        //hashT for comparison purpose
        for (int i = 0; i < T.length(); i++) {
            char curKey = T.charAt(i);
            if(hashT.containsKey(curKey))
                hashT.put(curKey, hashT.get(curKey)+1);
            else
                hashT.put(curKey, 1);
        }

        int winLeft = 0;
        int winRight = 0;

        //find the first place for winLeft
        for (int i = 0; i < S.length(); i++) {
            char curKey = S.charAt(i);
            if(hashT.containsKey(curKey)) {
                winLeft = i;
                break;
            }
        }

        int minLen = Integer.MAX_VALUE;
        int minWinLeft = 0;
        int minWinRight = -1;
        for (int i = winLeft; i < S.length(); i++) {

            char curKey = S.charAt(i);
            if(hashT.containsKey(curKey) ) {
                //
                if(hashS.containsKey(curKey) )
                    hashS.put(curKey, hashS.get(curKey)+1);
                else
                    hashS.put(curKey, 1);
            }

            if(isHashSHasHashT(hashS, hashT)) {
                winRight = i;
                int curLen = winRight-winLeft+1;
                if(curLen < minLen) {
                    minLen = curLen;
                    minWinLeft = winLeft;
                    minWinRight = winRight;
                }

                winLeft = getNextWinLeft(winLeft, S, hashS, hashT);

                if(isHashSHasHashT(hashS, hashT)) {
                    curLen = winRight-winLeft+1;
                    if(curLen < minLen) {
                        minLen = curLen;
                        minWinLeft = winLeft;
                        minWinRight = winRight;
                    }
                }
            }

        }

        return S.substring(minWinLeft, minWinRight+1);
    }

    private boolean isHashSHasHashT(HashMap<Character, Integer> hashS, HashMap<Character, Integer> hashT) {

        Iterator it = hashT.entrySet().iterator();
        while(it.hasNext()){

            Map.Entry<Integer, Integer> pairs = (Map.Entry) it.next();

            if(!hashS.containsKey(pairs.getKey()))
                return false;
            else if(pairs.getValue() > hashS.get(pairs.getKey()))
                return false;
        }

        return true;
    }


    private int getNextWinLeft (int winLeft, String S, HashMap<Character, Integer> hashS, HashMap<Character, Integer> hashT) {

        if (hashS.get(S.charAt(winLeft)) > 1){
            hashS.put(S.charAt(winLeft), hashS.get(S.charAt(winLeft))-1);
        } else {
            hashS.remove(S.charAt(winLeft));
        }

        for (int i = winLeft+1; i < S.length(); i++) {

            char curChar = S.charAt(i);
            if(hashS.containsKey(curChar)) {
                return i;
            }
        }

        return 0;
    }


    public static void main (String[] args) {

        MinimumWindowSubstring s = new MinimumWindowSubstring();
//        String S = "ADOBECODEBANC";
//        String T = "ABC";

//        String S = "a";
//        String T = "aa";

//        String S = "a";
//        String T = "aa";

        String S = "bba";
        String T = "ab";

        System.out.print(s.minWindow(S, T));

    }



}






































