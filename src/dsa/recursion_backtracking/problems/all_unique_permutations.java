package dsa.recursion_backtracking.problems;

import java.util.ArrayList;
import java.util.Arrays;

public class all_unique_permutations {

//    Problem Description
//    Given an array A of size N denoting collection of numbers that might contain duplicates, return all possible unique permutations.
//
//    NOTE: No 2 entries in the permutation sequence should be the same.
//
//            WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS.
//    Example : next_permutations in C++ / itertools.permutations in python.
//    If you do, we will disqualify your submission retroactively and give you penalty points.
//
//
//            Problem Constraints
//            1 <= |A| <= 9
//
//            0 <= A[i] <= 10
//
//
//
//    Input Format
//    Only argument is an integer array A of size N.
//
//
//
//    Output Format
//    Return a 2-D array denoting all possible unique permutation of the array.
//
//
//
//    Example Input
//    Input 1:
//
//    A = [1, 1, 2]
//    Input 2:
//
//    A = [1, 2]
//
//
//    Example Output
//    Output 1:
//
//            [ [1,1,2]
//            [1,2,1]
//            [2,1,1] ]
//    Output 2:
//
//            [ [1, 2]
//            [2, 1] ]
//
//
//    Example Explanation
//    Explanation 1:
//
//    All the possible unique permutation of array [1, 1, 2].
//    Explanation 2:
//
//    All the possible unique permutation of array [1, 2].

    public static void main(String[] args) {
       ArrayList<ArrayList<Integer>> ans =  permute(new ArrayList<>(Arrays.asList(1,1,2)));

       ans.forEach(list->{
           list.forEach(
                   current->{
                       System.out.print(current);
                   }
           );
           System.out.println();
       });

    }
    private static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList();
        int[] map = new int[12];
        for(int i: A){
            map[i]++;
        }
        recurse(ans,map,new ArrayList(),A.size());
        return ans;
    }

   private static void recurse(ArrayList<ArrayList<Integer>> ans, int[] map, ArrayList<Integer> current, int n){
        if(current.size() == n){
            ans.add(current);
        }
        for(int i =0;i<=10;i++){
            if(map[i]!=0){
                map[i]--;
                current.add(i);
                recurse(ans,map,new ArrayList(current),n);
                map[i]++;
                current.remove(current.size()-1);
            }
        }
    }
}
