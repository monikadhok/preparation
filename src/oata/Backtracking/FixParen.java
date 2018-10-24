/*

An expression will be given which can contain open and close parentheses and optionally some 
characters, No other operator will be there in string. We need to remove minimum number of 
parentheses to make the input string valid. If more than one valid output are possible 
removing same number of parentheses then print all such output.
Examples:

Input  : str = ()())()
Output : ()()() (())()
There are two possible solutions
"()()()" and "(())()"

Input  : str = (v)())()
Output : (v)()()  (v())()
*/

package oata.Backtracking;

public class FixParen { 
    public static void main(String args[]){
        System.out.println("Hello world!");
    }
}


// Solution 

/*
As we need to generate all possible output we will backtrack among all states by removing one opening or closing bracket and check if they are valid 

if invalid 
    then add the removed bracket back and go for next state. 
    We will use BFS for moving through states, use of BFS will 
    assure removal of minimal number of brackets because we traverse into states level by level and each level corresponds to one extra bracket removal. 
    
    Other than this BFS involve no recursion so overhead of passing parameters is also saved.
Below code has a method isValidString to check validity of string, it counts open and closed parenthesis at each index ignoring non-parenthesis character. 
If at any instant count of close parenthesis becomes more than open then we return false else we keep update the count variable.
()())()
q ->  ()())() 
    if invalid add 
        )())(), (())(), ()))(), etc. 
    check validity 
*/
