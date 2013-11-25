package LeetCode.hash;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 11/8/13
 *
 *
 * How do we determine if a particular window contains T? (ideally in O(1) time)
 How do we select all windows efficiently? (ideally do not include other windows that wrap about a sub-window)
 *
 */



public class MinimumWindowSubstring {



    public String minWindowNiuB(String S, String T) {

        if(S == null || T == null)
            return null;

        int ss = S.length();
        int tt = T.length();

        HashMap<Character, Integer> hashS = new HashMap<Character, Integer>();
        HashMap<Character, Integer> hashT = new HashMap<Character, Integer>();

        for (int i = 0; i < tt; i++) {

            char curKey = T.charAt(i);
            if(hashT.containsKey(curKey)) {
                hashT.put(curKey, hashT.get(curKey)+1);
            }else
                hashT.put(curKey, 1);
        }






        return null;
    }

    public String minWindow(String S, String T) {

        if(S == null || T == null)
            return null;
        int[] t = new int[256];                    //chars in T
        int[] s = new int[256];                    //chars found in S between ori and r

        String rl = "";
        for(int i = 0; i < T.length(); i++)
            t[T.charAt(i)]++;

        for(int ori = 0, r = 0, len = 0; r < S.length(); r++){
            if(t[S.charAt(r)] >= ++s[S.charAt(r)])
                len++;
            if(len < T.length())
                continue;
            while(s[S.charAt(ori)] > t[S.charAt(ori)])
                s[S.charAt(ori++)]--;
            if(rl.equals("") || rl.length() > r - ori + 1) {
                rl = S.substring(ori, r + 1);
                System.out.println(rl);
            }

        }

        return rl;
    }



    public String minWindowOther(String S, String T) {

        int ss = S.length(), tt = T.length();
        // set up a hashmap for T and also keep track of occurance
        HashMap<Character, Integer> needFind = new HashMap<Character, Integer>();
        HashMap<Character, Integer> hasFound = new HashMap<Character, Integer>();
        for (int i=0; i<tt; ++i) {
            //init hasFound
            hasFound.put(T.charAt(i), 0);
            if (needFind.containsKey(T.charAt(i))) {
                needFind.put(T.charAt(i), needFind.get(T.charAt(i))+1);
            } else {
                needFind.put(T.charAt(i), 1);
            }
        }
        // sliding window as needed
        int right = 0, found = 0, left = 0;
        ArrayList<Integer> nexts = new ArrayList<Integer>();
        String window = "";
        int winSize = Integer.MAX_VALUE;
        while (right < S.length()) {
            char c = S.charAt(right);
            if (!needFind.containsKey(c)) {  // not a match
                ++right;
                continue;
            }

            nexts.add(right);
            ++right;
            hasFound.put(c, hasFound.get(c)+1);
            if (hasFound.get(c) <= needFind.get(c))  ++found;

            if (found >= tt) { // got a window
                // move left?
                char ll = S.charAt(nexts.get(left));
                while (hasFound.get(ll) > needFind.get(ll)) {
                    hasFound.put(ll, hasFound.get(ll)-1);
                    ++left;
                    ll = S.charAt(nexts.get(left));
                }

System.out.println(nexts.get(left) + "-" + right);
                // smaller window?
                if (right - nexts.get(left) < winSize) {
                    winSize = right - nexts.get(left);
                    window = S.substring(nexts.get(left), right);
                }
            }
        }
        return window;
    }

    public static void main (String[] args) {

        MinimumWindowSubstring s = new MinimumWindowSubstring();
        String S = "ADOBECODEBANC";
        String T = "ABC";

//        HashMap<Character, Integer> hashTest = new HashMap<Character, Integer>();
//        char c = 'c';
//        hashTest.put(c, hashTest.get(c)+1);


        s.minWindowOther(S, T);


    }

}







































