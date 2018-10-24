/* 
Subset Sum Problem
Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal 
to given sum.
Example:

Input:  set[] = {3, 34, 4, 12, 5, 2}, sum = 9
Output:  True  //There is a subset (4, 5) with sum 9.
Let isSubSetSum(int set[], int n, int sum) be the function to find whether there is a subset of set[] with sum equal 
to sum. n is the number of elements in set[].

The isSubsetSum problem can be divided into two subproblems
…a) Include the last element, recur for n = n-1, sum = sum – set[n-1]
…b) Exclude the last element, recur for n = n-1.
If any of the above the above subproblems return true, then return true.

Following is the recursive formula for isSubsetSum() problem.
isSubsetSum(set, n, sum) = isSubsetSum(set, n-1, sum) || 
                           isSubsetSum(set, n-1, sum-set[n-1])
Base Cases:
isSubsetSum(set, n, sum) = false, if sum > 0 and n == 0
isSubsetSum(set, n, sum) = true, if sum == 0 
*/
package oata.DynamicProgramming; 

public class SubsetSum {

    public static boolean isSubsetSum(int set[], int n, int sum) {
        if(sum == 0)
            return true;
        if(sum > 0 && n == 0)
            return false; 
        
        if(set[n-1] > sum)
            return isSubsetSum(set, n-1, sum);

        return isSubsetSum(set, n-1, sum - set[n-1]) ||
            isSubsetSum(set, n-1, sum);
        
    }

    public static void main(String args[]) {
        int set[] = { 3, 34, 4, 12, 5, 2 };
        int sum = 9;
        int n = set.length;
        if (isSubsetSum(set, n, sum) == true)
            System.out.println("Found a subset" + " with given sum");
        else
            System.out.println("No subset with" + " given sum");
    }

}