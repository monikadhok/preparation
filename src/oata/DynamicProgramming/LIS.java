/* Longest Increasing Subsequence
We have discussed Overlapping Subproblems and Optimal Substructure properties.

Let us discuss Longest Increasing Subsequence (LIS) problem as an example problem that can be solved using Dynamic Programming.
The Longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence of a given sequence such that all 
elements of the subsequence are sorted in increasing order. For example, the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} 
is 6 and LIS is {10, 22, 33, 50, 60, 80}.
longest-increasing-subsequence

More Examples:

Input  : arr[] = {3, 10, 2, 1, 20}
Output : Length of LIS = 3
The longest increasing subsequence is 3, 10, 20

Input  : arr[] = {3, 2}
Output : Length of LIS = 1
The longest increasing subsequences are {3} and {2}

Input : arr[] = {50, 3, 10, 7, 40, 80}
Output : Length of LIS = 4
The longest increasing subsequence is {3, 7, 40, 80}
*/
package oata.DynamicProgramming; 

public class LIS {

    public static int lis(int arr[], int n) { 
        int lisVal[] = new int[n];
        for ( int i = 0; i < n; i++ ) 
            lisVal[i] = 1; 

        for(int i = 0 ; i < n; i++) {
            for(int j = 0 ; j < i; j++){
                if(arr[i] > arr[j] && lisVal[i] <= lisVal[j] + 1)
                    lisVal[i] = lisVal[j] + 1;
            }
        }
        return lisVal[n-1];
    }


    public static void main(String args[]) {
        int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
        int n = arr.length;
        System.out.println("Length of lis is " + lis(arr, n) + "n");
    }
}