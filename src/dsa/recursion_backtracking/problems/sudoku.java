package dsa.recursion_backtracking.problems;

import utils.ArrayUtils;

public class sudoku {

//    Problem Description
//    Write a program to solve a Sudoku puzzle by filling the empty cells. Empty cells are indicated by the character '.' You may assume that there will be only one unique solution.
//
//
//
//    A sudoku puzzle,
//
//
//
//    and its solution numbers marked in red.
//
//
//
//    Problem Constraints
//    N = 9
//
//
//    Input Format
//    First argument is an array of array of characters representing the Sudoku puzzle.
//
//
//            Output Format
//    Modify the given input to the required answer.
//
//
//    Example Input
//    Input 1:
//
//    A = [[53..7....], [6..195...], [.98....6.], [8...6...3], [4..8.3..1], [7...2...6], [.6....28.], [...419..5], [....8..79]]
//
//
//    Example Output
//    Output 1:
//
//            [[534678912], [672195348], [198342567], [859761423], [426853791], [713924856], [961537284], [287419635], [345286179]]
//
//
//    Example Explanation
//    Explanation 1:
//
//    Look at the diagrams given in the question.

    public static void main(String[] args) {
        char[][] c = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        solveSudoku(c);
        ArrayUtils.printCharArrayOfArray(c);
    }

    private static void solveSudoku(char[][] A) {
        solve(A, 0, 0);
    }

    private static boolean solve(char[][] A, int r, int c) {
        if (c == A.length) {
            c = 0;
            r++;
        }
        if (r == A.length) {
            return true;
        }
        if (A[r][c] != '.') {
            return solve(A, r, c + 1);
        }
        for (int i = 1; i <= A.length; i++) {
            if (isValid(A, r, c, i)) {
                A[r][c] = (char) ('0' + i);
                if (solve(A, r, c + 1)) {
                    return true;
                }
            }
            A[r][c] = '.';
        }
        return false;
    }

    private static boolean isValid(char[][] A, int r, int c, int i) {
        for (int j = 0; j < A.length; j++) {
            if (A[r][j] == i + '0') {
                return false;
            }
            if (A[j][c] == i + '0') {
                return false;
            }
        }
        int rStart = r / 3 * 3;
        int cStart = c / 3 * 3;
        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 3; k++) {
                if (A[rStart + j][cStart + k] == i + '0') {
                    return false;
                }
            }
        }
        return true;
    }

}
