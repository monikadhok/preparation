/*  Edit Distance
Given two strings str1 and str2 and below operations that can performed on str1. Find minimum number of edits (operations) required to convert ‘str1’ into 
‘str2’.

Insert
Remove
Replace
All of the above operations are of equal cost.

Examples:

Input:   str1 = "geek", str2 = "gesek"
Output:  1
We can convert str1 into str2 by inserting a 's'.

Input:   str1 = "cat", str2 = "cut"
Output:  1
We can convert str1 into str2 by replacing 'a' with 'u'.

Input:   str1 = "sunday", str2 = "saturday"
Output:  3
Last three and first characters are same.  We basically
need to convert "un" to "atur".  This can be done using
below three operations. 
Replace 'n' with 'r', insert t, insert a

*/
package oata.DynamicProgramming;

public class EditDistance {

    static int min(int x,int y,int z) 
    { 
        if (x <= y && x <= z) return x; 
        if (y <= x && y <= z) return y; 
        else return z; 
    } 

    public static int editDistDP (String str1, String str2, int m, int n) {
        int res[][] = new int[m+1][n+1];

        char arr1[] = str1.toCharArray();
        char arr2[] = str2.toCharArray();

        for(int i = 0 ; i <= m ; i++)
            res[i][0] = i;
        
        for(int i  = 0; i <= n ; i++)
            res[0][i] = i;
        
        for(int i  = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(arr1[i-1] == arr2[j-1]) { 
                    res[i][j] = res[i-1][j-1];
                } else {
                    res[i][j] = 1 + min(res[i-1][j-1], res[i-1][j], res[i][j-1]);
                }
            }
        }

        return res[m][n];   
    }
    
    public static void main(String args[]) 
    { 
        String str1 = "sunday"; 
        String str2 = "saturday"; 
        System.out.println( editDistDP( str1 , str2 , str1.length(), str2.length()) ); 
    } 

}