/*
Coin Change 

Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins, how many ways can we make the change? 
The order of coins doesn’t matter. For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4. For N = 10 
and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. So the output should be 5.
*/

package oata.DynamicProgramming;

import java.util.*;

public class CoinChange {


    public static int count(int S[], int m, int value) { 
        int res[] = new int[value+1];

        Arrays.fill(res, 0);
        res[0] = 1;

        for(int i  = 0 ; i < m; i++) { 
            for(int j = S[i]; j <= value; j++) { 
                res[j] += res[j-S[i]];
            }
        }

        return res[value];
    }

    public static void main(String args[]) {
        System.out.println("Hello world!");
        int arr[] = { 1, 2, 3 };
        int m = arr.length;
        System.out.println(count(arr, m, 4));


        
        int arr1[] = {2, 5, 3, 6};
        int m1 = arr1.length;
        System.out.println(count(arr1, m1, 10));
    }
}