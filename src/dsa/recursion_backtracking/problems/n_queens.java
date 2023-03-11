package dsa.recursion_backtracking.problems;

import utils.ArrayUtils;

import java.util.ArrayList;

public class n_queens {

//    Problem Description
//    The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
//
//
//
//    Given an integer A, return all distinct solutions to the n-queens puzzle.
//
//    Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
//    The final list should be generated in such a way that the indices of the queens in each list should be in reverse lexicographical order.
//
//
//            Problem Constraints
//     1 <= A <= 10
//
//
//
//    Input Format
//    First argument is an integer n denoting the size of chessboard
//
//
//
//    Output Format
//    Return an array consisting of all distinct solutions in which each element is a 2d char array representing a unique solution.
//
//
//
//    Example Input
//    Input 1:
//
//    A = 4
//    Input 2:
//
//    A = 1
//
//
//    Example Output
//    Output 1:
//
//            [
//            [".Q..",  // Solution 1
//            "...Q",
//            "Q...",
//            "..Q."],
//
//            ["..Q.",  // Solution 2
//            "Q...",
//            "...Q",
//            ".Q.."]
//            ]
//    Output 1:
//
//            [
//            [Q]
//            ]
//
//
//    Example Explanation
//    Explanation 1:
//
//    There exist only two distinct solutions to the 4-queens puzzle:
//    Explanation 1:
//
//    There exist only one distinct solutions to the 1-queens puzzle:

    public static void main(String[] args) {
        ArrayList<ArrayList<String>> ans = solveNQueens(12);
        ArrayUtils.printListOfList(ans);
    }

    private static ArrayList<ArrayList<String>> solveNQueens(int A) {
        ArrayList<ArrayList<String>> ans = new ArrayList();
        int[] board = new int[A];
        placeNQueens(board,0,A,ans);
        return ans;
    }



    private  static void placeNQueens(int[] board,int r,int N,ArrayList<ArrayList<String>> ans){
        if(r==N){
            ans.add(createBoard(board));
        }
        for(int i = 0;i<N;i++){
            if(isValid(r,i,board)){
                board[r] = i;
                placeNQueens(board,r+1,N,ans);
                board[r] = -1;
            }
        }
    }

    private  static boolean isValid(int r, int c, int[] arr){
        for(int i = 0;i<r;i++){
            if(arr[i]==c)
                return false;
            if(r+c==i+arr[i] || r-c == i-arr[i])
                return false;
        }
        return true;
    }

    private static ArrayList<String> createBoard(int[] board){
        ArrayList<String> ans = new ArrayList();
        for(int i = 0;i<board.length;i++){
            int current = board[i];
            String str = "";
            for(int j = 0;j<board.length;j++){
                if(j==current){
                    str += "Q";
                } else {
                    str += ".";
                }
            }
            ans.add(str);
        }
        return ans;
    }

}
