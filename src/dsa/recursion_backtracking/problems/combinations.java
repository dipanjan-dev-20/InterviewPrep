package dsa.recursion_backtracking.problems;

import utils.ArrayUtils;

import java.util.ArrayList;

public class combinations {

//    Problem Description
//    Given two integers A and B, return all possible combinations of B numbers out of 1 2 3 ... A.
//
//    Make sure the combinations are sorted.
//
//    To elaborate,
//
//    Within every entry, elements should be sorted. [1, 4] is a valid entry while [4, 1] is not.
//    Entries should be sorted within themselves.
//    WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING COMBINATIONS.
//
//
//
//    Problem Constraints
//1 <= A, B <= 10
//
//
//
//    Input Format
//    The first argument is an integer A.
//    The second argument is an integer B.
//
//
//
//            Output Format
//    Return a 2-D vector denoting all possible combinations.
//
//
//
//    Example Input
//    Input 1:
//
//    A = 4
//    B = 2
//    Input 2:
//
//    A = 3
//    B = 2
//
//
//    Example Output
//    Output 1:
//
//            [
//            [1, 2],
//            [1, 3],
//            [1, 4],
//            [2, 3],
//            [2, 4],
//            [3, 4],
//            ]
//    Output 2:
//
//            [
//            [1, 2],
//            [1, 3],
//            [2, 3]
//            ]
//
//
//    Example Explanation
//    Explanation 1:
//
//    All the possible combinations of size 2 in sorted order.

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> ans = combine(4, 2);
        ArrayUtils.printListOfList(ans);
    }

    private static ArrayList<ArrayList<Integer>> combine(int A, int B) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList();
        recurse(1, A, B, new ArrayList<Integer>(), ans);
        return ans;
    }

    private static void recurse(int i, int N, int K, ArrayList<Integer> current, ArrayList<ArrayList<Integer>> list) {
        if (K == 0) {
            list.add(current);
            return;
        }
        if (i == N + 1) {
            return;
        }
        current.add(i);
        recurse(i + 1, N, K - 1, new ArrayList(current), list);
        current.remove(current.size() - 1);
        recurse(i + 1, N, K, new ArrayList(current), list);
    }

}
