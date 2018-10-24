/* 
Longest Common Subsequence 
We have discussed Overlapping Subproblems and Optimal Substructure properties in Set 1 and Set 2 respectively. We 
also discussed one example problem in Set 3. Let us discuss Longest Common Subsequence (LCS) problem as one more 
example problem that can be solved using Dynamic Programming.


It is a classic computer science problem, the basis of diff (a file comparison program that outputs the differences 
between two files), and has applications in bioinformatics.

*/

package oata.DynamicProgramming;

public class LCS {

    public static int lcs(char X[], char Y[], int m, int n){
        int res[][] = new int[m+1][n+1];

        for(int i = 0; i <= m ; i++)
            res[i][0] = 0;

        for(int i = 0 ; i <= n; i++)
            res[0][i] = 0;

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                 if(X[i-1] == Y[j-1])
                    res[i][j] = res[i-1][j-1] + 1;
                else 
                    res[i][j] = Math.max(res[i-1][j], res[i][j-1]);
            }
        }
        return res[m][n];
    }

    public static void main(String[] args) {
        LCS lcs = new LCS();
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        char[] X = s1.toCharArray();
        char[] Y = s2.toCharArray();
        int m = X.length;
        int n = Y.length;

        System.out.println("Length of LCS is" + " " + lcs.lcs(X, Y, m, n));
    }
}
