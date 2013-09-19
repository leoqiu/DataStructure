package Hack.helpMike;

/**
 * Created with IntelliJ IDEA.
 * User: leo
 * Date: 9/15/13
 * Time: 5:35 PM
 * To change this template use File | Settings | File Templates.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Solution {
    static BufferedReader in = new BufferedReader(new InputStreamReader(
            System.in));
    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws NumberFormatException, IOException {
        int numCases = Integer.parseInt(in.readLine());

        for(int t = 0; t < numCases; t ++)
        {
            String line = in.readLine();
            String[] data = line.split(" ");
            int n = Integer.parseInt(data[0]);
            int k = Integer.parseInt(data[1]);
            long total = 0;
            for(int i = 0; i <= k/2; i ++)
            {
                long num = n/k;
                if(n%k >= i && i != 0)
                {
                    num ++;
                }

                if(i == 0 || i + i == k)
                {
                    total += num*(num-1)/2;
                }
                else
                {
                    long num2 = n/k;
                    if(n%k >= (k-i))
                    {
                        num2 ++;
                    }
                    total += num*num2;
                }
            }
            out.append(total + "\n");
        }
        System.out.print(out);
    }
}

