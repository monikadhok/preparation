/*
perm_identity
Rat in a Maze with multiple steps or jump allowed
This is the variation of Rat in Maze

A Maze is given as N*N binary matrix of blocks where source block is the upper left most block i.e., maze[0][0] and destination block is lower rightmost block i.e., 
maze[N-1][N-1]. A rat starts from source and has to reach destination. The rat can move only in two directions: forward and down.
In the maze matrix, 0 means the block is dead end and non-zero number means the block can be used in the path from source to destination. The non-zero value of 
mat[i][j] indicates number of maximum jumps rat can make from cell mat[i][j].

In this variation, Rat is allowed to jump multiple steps at a time instead of 1.

Examples
Examples:

Input : { {2, 1, 0, 0},
         {3, 0, 0, 1},
         {0, 1, 0, 1},
          {0, 0, 0, 1}
        }
Output : { {1, 0, 0, 0},
           {1, 0, 0, 1},
           {0, 0, 0, 1},
           {0, 0, 0, 1}
         }

Explanation 
Rat started with M[0][0] and can jump upto 2 steps right/down. 
Let's try in horizontal direction - 
M[0][1] won't lead to solution and M[0][2] is 0 which is dead end. 
So, backtrack and try in down direction. 
Rat jump down to M[1][0] which eventually leads to solution.  

Input : { 
      {2, 1, 0, 0},
      {2, 0, 0, 1},
      {0, 1, 0, 1},
      {0, 0, 0, 1}
    }
Output : Solution doesn't exist
*/


/*
Naive Solution
while there are untried paths
{
   generate the next path
   if this path has all blocks as non-zero
   {
      print this path;
   }
}
Backtracking Algorithm

If destination is reached
    print the solution matrix
Else
   a) Mark current cell in solution matrix as 1. 
   b) Move forward/jump (for each valid steps) in horizontal direction 
      and recursively check if this move leads to a solution. 
   c) If the move chosen in the above step doesn't lead to a solution
       then move down and check if this move leads to a solution. 
   d) If none of the above solutions work then unmark this cell as 0 
       (BACKTRACK) and return false.
*/
package oata.Backtracking;

public class RatInMaze { 
    public static void main(String args[]){
        System.out.println("Hello world!");
    }
}