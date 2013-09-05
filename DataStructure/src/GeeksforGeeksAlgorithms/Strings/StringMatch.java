package GeeksforGeeksAlgorithms.Strings;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 9/4/13
 */
public class StringMatch {


     /*
    String matching where one string contains wildcard characters
    April 11, 2013

    Given two strings where first string may contain wild card characters and second string is a normal string. Write a function that returns
    true if the two strings match. The following are allowed wild card characters in first string.

    * --> Matches with 0 or more instances of any character or set of characters.
    ? --> Matches with any one character.

    For example, “g*ks” matches with “geeks” match. And string “ge?ks*” matches with “geeksforgeeks” (note ‘*’ at the end of first string).
    But “g*k” doesn’t match with “gee” as character ‘k’ is not present in second string

     */
    public static void main (String[] args) {

        StringMatch sm = new StringMatch();
        //System.out.print(sm.matchStrings(0, 0, 5, 13));

        String str1 = "abc*bc*dd";
        String str2 = "abcdhghgbcddsx";
        //String str1 = "ge?ks";
        //String str2 = "geeksforgeeks";
        //System.out.print(sm.match(str1, str2));
        System.out.print(sm.wildCardMatch(str1, str2));

    }



//    String str1 = "ge?ks";
//    String str2 = "geeksforgeeks";
//    String str1 = "*?c*d";
//    String str2 = "abcd";
    String str1 = "abc*bcd";
    String str2 = "abcdhghgbcd";


    char[] charArr1 = str1.toCharArray();
    char[] charArr2 = str2.toCharArray();
    public boolean matchStrings (int first, int sec, int m, int n) {

        if((first + 1) < m && charArr1[first] == '*' && sec == n -1)
            return false;

        if(first == m-1 || sec == n-1)
            return true;

        if (charArr1[first] == '?' || charArr1[first] == charArr2[sec])
            return matchStrings(first+1, sec+1, m, n);

        if (charArr1[first] == '*')
            return matchStrings(first + 1, sec, m, n) || matchStrings(first, sec+1, m, n);

        return false;
    }



    public boolean match(String input1, String input2) {
        if(input1.length() == 0 && input2.length() == 0)
            return true;
        if(input2.length() == 0 && input1.charAt(0)!='*')
            return false;
        if(input1.length() ==0 && input2.length()!=0)
            return false;
        if (input1.charAt(0) == '*' && input1.length() != 1  && input2.length() == 0)
            return false;
        if(input1.charAt(0) == '*' && input1.length() ==1  && input2.length() == 0)
            return true;
        else if(input1.charAt(0) == '?'|| input1.charAt(0)==input2.charAt(0))
            return match(input1.substring(1),input2.substring(1));
        else if(input1.charAt(0) == '*'){
            return match(input1,input2.substring(1)) || match(input1.substring(1),input2.substring(0));
        }
        else if(input1.charAt(0) != input2.charAt(0))
            return false;
        return false;
    }


    public boolean wildCardMatch (String pattern, String text) {

        String[] words = pattern.split("\\*");

        for (String word : words) {

            //the index of the first occurrence of the specified substring
            int index = text.indexOf(word);

            if(index == -1)
                return false;

            text = text.substring(index + word.length());

        }

        if(text.length() != 0)
            return false;

        return true;
    }


}
