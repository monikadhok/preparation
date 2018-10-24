package oata.Backtracking;

public class Sudoku {

    public static boolean SolveSudoku(int grid[][]) {
        int row = -1, col = -1;
        boolean isEmpty = true;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (grid[i][j] == 0) {
                    row = i;
                    col = j;
                    isEmpty = false;
                    break;
                } 
            }
            if(!isEmpty)
                break;
        }

        if(isEmpty)
            return true;


        for (int k = 1; k <= 9; k++) {

            if (isSafe(grid, row, col, k)) {
                grid[row][col] = k;
                if (SolveSudoku(grid))
                    return true;
               else
                 grid[row][col] = 0;
            }
        }

        return false;
    }

    public static boolean isSafe(int grid[][], int row, int col, int k) {
        for (int i = 0; i < 9; i++) {
            if (grid[row][i] == k)
                return false;
        }
        for (int i = 0; i < 9; i++) {
            if (grid[i][col] == k)
                return false;
        }
        int boxRowStart = row - row % 3;
        int boxColStart = col - col % 3;

        for (int r = boxRowStart; r < boxRowStart + 3; r++) {
            for (int d = boxColStart; d < boxColStart + 3; d++) {
                if (grid[r][d] == k) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void print(int[][] board, int N) {
        // we got the answer, just print it
        for (int r = 0; r < N; r++) {
            for (int d = 0; d < N; d++) {
                System.out.print(board[r][d]);
                System.out.print(" ");
            }
            System.out.print("\n");

            if ((r + 1) % (int) Math.sqrt(N) == 0) {
                System.out.print("");
            }
        }
    }

    /* Driver Program to test above functions */
    public static void main(String[] args) {
        // 0 means unassigned cells
        int grid[][] = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, { 5, 2, 0, 0, 0, 0, 0, 0, 0 }, { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 }, { 9, 0, 0, 8, 6, 3, 0, 0, 5 }, { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 }, { 0, 0, 0, 0, 0, 0, 0, 7, 4 }, { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };
        if (SolveSudoku(grid) == true)
            print(grid, 9);
        else
            System.out.println("No solution exists");
    }

}