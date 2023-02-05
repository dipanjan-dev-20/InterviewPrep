package dsa.recursion_backtracking.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class permutations {

//    Problem Description
//    Given an integer array A of size N denoting collection of numbers , return all possible permutations.
//
//            NOTE:
//
//    No two entries in the permutation sequence should be the same.
//    For the purpose of this problem, assume that all the numbers in the collection are unique.
//    Return the answer in any order
//    WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS.
//    Example : next_permutations in C++ / itertools.permutations in python.
//    If you do, we will disqualify your submission retroactively and give you penalty points.
//
//
//            Problem Constraints
//1 <= N <= 9
//
//
//
//    Input Format
//    Only argument is an integer array A of size N.
//
//
//
//    Output Format
//    Return a 2-D array denoting all possible permutation of the array.
//
//
//
//            Example Input
//    A = [1, 2, 3]
//
//
//    Example Output
//[ [1, 2, 3]
//        [1, 3, 2]
//        [2, 1, 3]
//        [2, 3, 1]
//        [3, 1, 2]
//        [3, 2, 1] ]
//
//
//    Example Explanation
//    All the possible permutation of array [1, 2, 3].

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> ans = permute(new ArrayList<>(Arrays.asList(1, 2, 3)));
        ans.forEach(
                arr -> {
                    arr.forEach(num ->
                            {
                                System.out.print(num);
                            }
                    );
                    System.out.println();
                }


        );

    }


    private static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList();
        recurse(A, ans, 0);
        return ans;
    }

    private static void recurse(ArrayList<Integer> num, ArrayList<ArrayList<Integer>> ans, int current) {
        if (current == num.size() - 1) {
            ans.add(num);
            return;
        }
        for (int i = current; i < num.size(); i++) {
            Collections.swap(num, i, current);
            recurse(new ArrayList(num), ans, current + 1);
            Collections.swap(num, i, current);
        }
    }
}
