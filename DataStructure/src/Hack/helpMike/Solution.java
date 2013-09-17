package Hack.helpMike;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 9/16/13
 * Time: 10:12 AM
 * To change this template use File | Settings | File Templates.
 */


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        System.out.print(f(10, 4));
    }

    private static long f(int  n, int k){
        long[] c = new long[k];
        int r = n % k;
        for(int i = 1; i <= r; i++) c[i]++;
        int m = n / k;
        for(int i = 0; i < k; i++) c[i] += m;
        long t = c[0]*(c[0]-1)/2;
        for(int i = 1; i < k / 2; i++){
            t += c[i] * c[k-i];
        }
        if(k % 2 != 0) t += c[k/2]*c[k-k/2];
        if(k % 2 == 0) t += c[k/2]*(c[k/2]-1)/2;
        return t;
    }
}
