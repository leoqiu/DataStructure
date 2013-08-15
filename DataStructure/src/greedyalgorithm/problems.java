package greedyalgorithm;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 8/14/13
 */
public class problems {


    /**
     *
     * problem #15 - number of railway-platforms
     *
     *            Arrival            Departure
     * rail A:    9:00                9:30
     * rail B:    9:15                13:00
     * rail C:    10:30               11:00
     * rail D:    10:45               11:45
     *
     *
     * 1. sort arrival and departure time
     *    9:00,a  9:15,a  9:30,d  10:30,a  10:45,a  11:00,d  11:45,d   13:00,d
     *
     * 2. mark arrival as 1 and departure as -1
     *    1 1 -1 1 1 -1 -1 -1
     *
     * 3. add from beginning
     *    1 2 1 2 3 2 1 0
     *
     * 4. the total minimal platforms is 3
     *
     *
     * @param
     */



















    public static void main (String[] args) {

    }


}
