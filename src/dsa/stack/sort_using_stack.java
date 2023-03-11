package dsa.stack;

import utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;

public class sort_using_stack {

//    Problem Description
//    Given a stack of integers A, sort it using another stack.
//
//    Return the array of integers after sorting the stack using another stack.
//
//
//
//    Problem Constraints
//       1 <= |A| <= 5000
//
//            0 <= A[i] <= 109
//
//
//
//    Input Format
//    The only argument is a stack given as an integer array A.
//
//
//
//    Output Format
//    Return the array of integers after sorting the stack using another stack.
//
//
//
//    Example Input
//    Input 1:
//
//    A = [5, 4, 3, 2, 1]
//    Input 2:
//
//    A = [5, 17, 100, 11]
//
//
//    Example Output
//    Output 1:
//
//            [1, 2, 3, 4, 5]
//    Output 2:
//
//            [5, 11, 17, 100]
//
//
//    Example Explanation
//    Explanation 1:
//
//    Just sort the given numbers.
//            Explanation 2:
//
//    Just sort the given numbers.

    public static void main(String[] args) {
       ArrayList<Integer> ans =  sort(new ArrayList<>(Arrays.asList(5, 4, 3, 2, 1)));
        ArrayUtils.printList(ans);
    }


    private static ArrayList<Integer> sort(ArrayList<Integer> A) {
        ArrayList<Integer> ans = new ArrayList();
        while(A.size()>0){
            int lastIndex = A.size()-1;
            int temp = A.get(lastIndex);
            A.remove(lastIndex);
            while(ans.size()>0 && ans.get(ans.size()-1) > temp){
                A.add(ans.get(ans.size()-1));
                ans.remove(ans.size()-1);
            }
            ans.add(temp);
        }


        return ans;
    }

}
