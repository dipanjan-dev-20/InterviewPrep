package dsa.recursion_backtracking.problems;

import utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;

public class unique_paths {

//    Problem Description
//    Given a matrix of integers A of size N x M . There are 4 types of squares in it:
//
//            1. 1 represents the starting square.  There is exactly one starting square.
//            2. 2 represents the ending square.  There is exactly one ending square.
//            3. 0 represents empty squares we can walk over.
//     4. -1 represents obstacles that we cannot walk over.
//    Find and return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.
//
//    Note: Rows are numbered from top to bottom and columns are numbered from left to right.
//
//
//
//            Problem Constraints
//            2 <= N * M <= 20
//            -1 <= A[i] <= 2
//
//
//
//    Input Format
//    The first argument given is the integer matrix A.
//
//
//
//            Output Format
//    Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.
//
//
//
//    Example Input
//    Input 1:
//
//    A = [   [1, 0, 0, 0]
//            [0, 0, 0, 0]
//            [0, 0, 2, -1]   ]
//    Input 2:
//
//    A = [   [0, 1]
//            [2, 0]    ]
//
//
//    Example Output
//    Output 1:
//
//            2
//    Output 2:
//
//            0
//
//
//    Example Explanation
//    Explanation 1:
//
//    We have the following two paths:
//            1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
//            2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
//    Explanation 1:
//
//    Answer is evident here.

    private static int[] xX = {1,0,0,-1};
    private static int[] yY = {0,1,-1,0};

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> prob = new ArrayList<>();
        prob.add(new ArrayList<>(Arrays.asList(1,0,0,0)));
        prob.add(new ArrayList<>(Arrays.asList(0,0,0,0)));
        prob.add(new ArrayList<>(Arrays.asList(0,0,2,-1)));
        int ans = solve(prob);
        System.out.println(ans);
    }

    private static int solve(ArrayList<ArrayList<Integer>> A) {
        int[] ans = new int[1];
        int r = A.size();
        int c = A.get(0).size();
        int sR = -1;
        int sC = -1;
        int count = 0;
        for(int i = 0;i<r;i++){
            for(int j = 0;j<c;j++){
                if(A.get(i).get(j)==1){
                    sR = i;
                    sC = j;
                }
                if(A.get(i).get(j)==0){
                    count++;
                }
            }
        }
        recurse(sR,sC,count + 1,A,ans);
        return ans[0];
    }

    private static void recurse(int sR,int sC,int count,ArrayList<ArrayList<Integer>> A,int[] ans){
        if(A.get(sR).get(sC)==2){
            if(count==0){
                ans[0]++;
            }
            return;
        }
        A.get(sR).set(sC,-1);
        for(int i =0;i<4;i++){
            int x = sR + xX[i];
            int y = sC + yY[i];
            if(isValid(x,y,A)){
                recurse(x,y,count-1,A,ans);
            }
        }
        A.get(sR).set(sC,0);
    }

    private static boolean isValid(int r,int c,ArrayList<ArrayList<Integer>> A){
        int m = A.size();
        int n = A.get(0).size();
        return r>=0 && r<m && c>=0 && c<n && A.get(r).get(c) != -1;
    }
}
