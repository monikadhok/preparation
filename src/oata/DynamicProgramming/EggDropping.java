/* Egg Dropping Puzzle


1) Optimal Substructure:
When we drop an egg from a floor x, there can be two cases (1) The egg breaks (2) The egg doesn’t break.

1) If the egg breaks after dropping from xth floor, then we only need to check for floors lower than x with remaining eggs; so the problem reduces to x-1 floors and n-1 eggs
2) If the egg doesn’t break after dropping from the xth floor, then we only need to check for floors higher than x; so the problem reduces to k-x floors and n eggs.

Since we need to minimize the number of trials in worst case, we take the maximum of two cases. We consider the max of above two cases for every floor and choose the floor which yields minimum number of trials.

  k ==> Number of floors
  n ==> Number of Eggs
  eggDrop(n, k) ==> Minimum number of trials needed to find the critical
                    floor in worst case.
  eggDrop(n, k) = 1 + min{max(eggDrop(n - 1, x - 1), eggDrop(n, k - x)): 
                 x in {1, 2, ..., k}}

The following is a description of the instance of this famous puzzle involving n=2 eggs and a building with k=36 floors.
Suppose that we wish to know which stories in a 36-story building are safe to drop eggs from, and which will cause the eggs 
to break on landing. We make a few assumptions:

…..An egg that survives a fall can be used again.
…..A broken egg must be discarded.
…..The effect of a fall is the same for all eggs.
…..If an egg breaks when dropped, then it would break if dropped from a higher floor.
…..If an egg survives a fall then it would survive a shorter fall.
…..It is not ruled out that the first-floor windows break eggs, nor is it ruled out that the 36th-floor do not cause an egg to break.

If only one egg is available and we wish to be sure of obtaining the right result, the experiment can be carried out in only 
one way. Drop the egg from the first-floor window; if it survives, drop it from the second floor window. Continue upward until it 
breaks. In the worst case, this method may require 36 droppings. Suppose 2 eggs are available. What is the least number of 
egg-droppings that is guaranteed to work in all cases?
The problem is not actually to find the critical floor, but merely to decide floors from which eggs should be dropped so that 
total number of trials are minimized.


n this post, we will discuss solution to a general problem with n eggs and k floors. The solution is to try dropping an egg from 
every floor (from 1 to k) and recursively calculate the minimum number of droppings needed in worst case. The floor which gives the 
minimum value in worst case is going to be part of the solution.
In the following solutions, we return the minimum number of trials in worst case; these solutions can be easily modified to print 
floor numbers of every trials also.

*/

package oata.DynamicProgramming;

public class EggDropping {


  public static int eggDrop(int n, int k) { 
    int res[][] = new int[n+1][k+1];

    for(int i = 0 ; i <= k; i++) { 
      res[1][i] = i;
      res[0][i] = 0;
    }

    for(int i = 0 ; i <= n; i++) { 
      res[i][0] = 0; 
      res[i][1] = 1; 
    }


    for(int i = 2 ; i <= n ; i++) {
      for(int j = 2 ; j <= k; j++) {
        int value = Integer.MAX_VALUE;
         for(int p = 1 ; p <= j; p++) {
            int trials = 1 + Math.max(res[n-1][p-1], res[n][j-p]);
            value = Math.min(value, trials);
         }

         res[i][j] = value;
      }
    }
    return res[n][k];
  }

  public static void main(String args[]) {
    int n = 2, k = 36;
    System.out.println(
        "Minimum number of trials in worst case with " + n + "  eggs and " + k + " floors is " + eggDrop(n, k));
  }
}
