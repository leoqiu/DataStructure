package LeetCode.puzzle;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 12/5/13
 * Time: 11:42 AM
 * To change this template use File | Settings | File Templates.
 */


public class GasStation {



    public int canCompleteCircuit(int[] gas, int[] cost) {

        for (int i = 0 ; i < gas.length; i++) {
            if(canTravelAround(i, gas.length, gas, cost))
                return i;
        }

        return -1;
    }

    private boolean canTravelAround (int start, int n, int[] gas, int[] cost) {

        int gasLeft = 0;
        int stations = 0;
        while (stations <= n) {

            int curGas = gas[start];
            int curCost = cost[start];

            gasLeft = curGas-curCost+gasLeft;

            if(gasLeft < 0)
                return false;

            if(start == n-1)
                start = 0;
            else
                start++;

            stations++;
        }

        if(gasLeft < 0)
            return false;
        else
            return true;
    }


}
