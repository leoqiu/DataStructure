package GeeksforGeeksAlgorithms.Strings;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 8/28/13
 */
public class problems {

    private void printCharA (char[] charA) {

        for(int i = 0; i < charA.length; i++) {
            if(charA[i] != '\0')
            System.out.print(charA[i]);
        }

    }

    /**
     * http://www.geeksforgeeks.org/remove-a-and-bc-from-a-given-string/
     *
     * Problem #1. Remove “b” and “ac” from a given string
     *
     * Examples:
     * acbac   ==>  ""
     * aaac    ==>  aa
     * ababac  ==>   aa
     * bbbbd   ==>   d
     *
     */
    public void removeBAndAC  () {

        //String str = "ababac";
        String str = "abcaaccd";

        char[] charA = str.toCharArray();

        int index1 = 0;


        while (index1 < charA.length) {

            while ( index1 < charA.length && charA[index1] != 'b' && charA[index1] != 'a' ) {
                index1++;
            }

            if (index1 < charA.length && charA[index1] == 'b') {
                charA[index1] = '\0';
                index1++;
            }

            if (index1 < charA.length && charA[index1] == 'a') {
                if(index1 + 1 == charA.length)
                    break;
                else if (charA[index1+1] == 'c') {
                    charA[index1] = '\0';
                    charA[index1+1] = '\0';
                    index1 = index1 + 2;
                } else
                    index1++;
            }

        }

        printCharA (charA);
        //System.out.print(new String(charA));
    }

    public void removeBAndACImproved  () {

        //String str = "ababac";
        //String str = "aacacca";
        String str = "abcaaccd";

        char[] charA = str.toCharArray();

        int index1 = 0;
        //for tracing back 'c'
        int index2 = -1;

        while (index1 < charA.length) {

            while ( index1 < charA.length && charA[index1] != 'b' && charA[index1] != 'a' ) {
                index1++;
            }

            if (index1 < charA.length && charA[index1] == 'b') {
                charA[index1] = '\0';
                index1++;
            }

            if (index1 < charA.length && charA[index1] == 'a') {
                if(index1 + 1 == charA.length)
                    break;
                else if (charA[index1+1] == 'c') {
                    charA[index1] = '\0';
                    charA[index1+1] = '\0';
                    index1 = index1 + 2;
                } else
                    index1++;
            }

            if (index1 < charA.length && charA[index1] == 'c')
                index2 = index1;

            while (index2 >= 0) {
                if(charA[index2] == 'a') {
                    charA[index2] = '\0';
                    charA[index1] = '\0';
                    index2 = -1;
                    break;
                }
                index2--;
            }
        }

        printCharA (charA);
    }


    public static void main (String[] args) {
        problems p = new problems();
        //p.removeBAndAC();
        p.removeBAndACImproved();
    }


}






















