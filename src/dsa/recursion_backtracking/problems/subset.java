package dsa.recursion_backtracking.problems;

import utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class subset {

//    Problem Description
//    Given a set of distinct integers A, return all possible subsets.
//
//            NOTE:
//
//    Elements in a subset must be in non-descending order.
//    The solution set must not contain duplicate subsets.
//    Also, the subsets should be sorted in ascending ( lexicographic ) order.
//    The list is not necessarily sorted.
//
//
//    Problem Constraints
//    1 <= |A| <= 16
//    INTMIN <= A[i] <= INTMAX
//
//
//    Input Format
//    First and only argument of input contains a single integer array A.
//
//
//
//    Output Format
//    Return a vector of vectors denoting the answer.
//
//
//
//    Example Input
//    Input 1:
//
//    A = [1]
//    Input 2:
//
//    A = [1, 2, 3]
//
//
//    Example Output
//    Output 1:
//
//            [
//            []
//            [1]
//            ]
//    Output 2:
//
//            [
//            []
//            [1]
//            [1, 2]
//            [1, 2, 3]
//            [1, 3]
//            [2]
//            [2, 3]
//            [3]
//            ]
//
//
//    Example Explanation
//    Explanation 1:
//
//    You can see that these are all possible subsets.
//            Explanation 2:
//
//    You can see that these are all possible subsets.

    public static void main(String[] args) {
        ArrayUtils.printListOfList( subsets(new ArrayList<>(Arrays.asList(1,2,3))));

    }

    private static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList();
        ArrayList<Integer> current = new ArrayList();
        Collections.sort(A);
        recurse(A, ans, current, 0);
        Collections.sort(ans, (o1, o2) -> {
            int min = Math.min(o1.size(), o2.size());
            for (int i = 0; i < min; i++) {
                if (o1.get(i) == o2.get(i)) {
                    continue;
                } else {
                    return o1.get(i) - o2.get(i);
                }
            }
            return 1;
        });
        return ans;
    }

    private static void recurse(ArrayList<Integer> num, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> output, int index) {
        if (index == num.size()) {
            ans.add(output);
            return;
        }
        recurse(num, ans, new ArrayList(output), index + 1);
        output.add(num.get(index));
        recurse(num, ans, new ArrayList(output), index + 1);
    }
}
