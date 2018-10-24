/*


1) Optimal Substructure: 
This problem is similar to Rod Cutting Problem. We can get the maximum product by making a cut at different positions and comparing the values obtained after a cut. We can recursively call the same function for a piece obtained after a cut.

Let maxProd(n) be the maximum product for a rope of length n. maxProd(n) can be written as following.

maxProd(n) = max(i*(n-i), maxProdRec(n-i)*i) for all i in {1, 2, 3 .. n}

2) Overlapping Subproblems
Following is simple recursive implementation of the problem. The implementation simply follows the recursive structure mentioned above. 

Maximum Product Cutting
Given a rope of length n meters, cut the rope in different parts of integer lengths in a way that maximizes product of lengths of all parts.
You must make at least one cut. Assume that the length of rope is more than 2 meters.
Examples:

Input: n = 2
Output: 1 (Maximum obtainable product is 1*1)

Input: n = 3
Output: 2 (Maximum obtainable product is 1*2)

Input: n = 4
Output: 4 (Maximum obtainable product is 2*2)

Input: n = 5
Output: 6 (Maximum obtainable product is 2*3)

Input: n = 10
Output: 36 (Maximum obtainable product is 3*3*4) */
package oata.DynamicProgramming; 

public class MaximumProductCutting {

    public static int maxProd(int n) {

        int res[] = new int[n + 1];

        res[0] = 1;
        res[1] = 1;

        for(int i  = 2 ; i <= n; i++) {
            int val = Integer.MIN_VALUE;
            for(int j = 1 ; j <= i; j++ ) {
                val = Math.max(val, j * res[i-j]);
            }
            res[i] = val;
        }

         return res[n];
    }

    /* Driver program to test above functions */
    public static void main(String[] args) {
        System.out.println("Maximum Product is " + maxProd(10));
    }
}