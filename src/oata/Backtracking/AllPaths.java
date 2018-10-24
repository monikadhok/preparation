//https://www.geeksforgeeks.org/print-all-possible-paths-from-top-left-to-bottom-right-of-a-mxn-matrix/
/*
The problem is to print all the possible paths from top left to bottom right of a mXn matrix 
with the constraints that from each cell you can either move only to right or down.
Examples :

Input : 1 2 3
        4 5 6
Output : 1 4 5 6
         1 2 5 6
         1 2 3 6

Input : 1 2 
        3 4
Output : 1 2 4
         1 3 4
*/

package oata.Backtracking;

import java.util.*;

public class AllPaths {

    public static void traverse(int grid[][], int rows, int cols, int path[], int currRow, int currCol, int idx) {
        if (currCol == cols && currRow == rows) {
            System.out.println();
            path[idx++] = grid[currRow][currCol];
            System.out.print("//{");
            // print the listF
           for(int i  =0 ; i < path.length; i++)
                System.out.print(path[i] + " ");
            
            System.out.print("//}");
            return;
        }
        path[idx++] = grid[currRow][currCol];

        if(currRow > rows || currCol > cols)
            return;

        if (currRow == rows) {
            traverse(grid, rows, cols, path, currRow, currCol + 1, idx);
            return;
        }
        if (currCol == cols) {
            traverse(grid, rows, cols, path, currRow + 1, currCol, idx);
            return;
        }
     
        traverse(grid, rows, cols, path, currRow, currCol + 1, idx);
        traverse(grid, rows, cols, path, currRow + 1, currCol, idx);
    }

    public static void main(String args[]) {
        System.out.println("Hello world!");

        int grid[][] = { { 1, 2, 3 }, { 4, 5, 6 } };
        int path[] = new int[6];

        traverse(grid, 1, 2, path, 0, 0, 0);

        System.out.println();

        int grid1[][] = { { 1, 2, 3 }, { 4, 5, 6 }, {7, 8, 9} };
        int path1[] = new int[9];

        traverse(grid1, 2, 2, path1, 0, 0, 0);

    }
}