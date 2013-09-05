package GeeksforGeeksAlgorithms.Strings;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 9/4/13
 *
 */
public class CountingWordsInStr {


    /*

     Given a string, count number of words in it. The words are separated by following characters: space (‘ ‘) or new line (‘\n’) or tab (‘\t’) or a combination of these.

     eg. char str[] = "One two          three\n  four\nfive  "
     */

    public void countingWords () {

        String str = "One two      \t    three\n  four\nfive  ";
        char[] charArr = str.toCharArray();
        int n = charArr.length;

        int index = 0;
        int indexS = 0;

        int count = 0;

        while (index < n && indexS < n) {

            while (index< n && charArr[index] != ' ' && charArr[index] != '\n' && charArr[index] != '\t')
                index++;


            //found one word
            indexS = index;
            count++;

            while (indexS< n && (charArr[indexS] == ' ' || charArr[indexS] == '\n' || charArr[indexS] == '\t'))
                indexS++;

            index = indexS;

        }

        System.out.print(count);

    }

    public void testSyntax () {

        int[] array = {1, 1, 1, 1, 0, 1, 0};

        for (int i = 0; i < array.length; i++) {

//            if(array[i] == 1)
//                System.out.println("sys 1");
//            else if (i%2 == 0)
//                System.out.println("sys even index");

//            if(array[i] == 1)
//                System.out.println("sys 1");
//            if (i%2 == 0)
//                System.out.println("sys even index");

        }


    }


    public static void main (String[] args) {

        CountingWordsInStr cwis = new CountingWordsInStr();
        //cwis.countingWords();
        cwis.testSyntax();
    }

}
