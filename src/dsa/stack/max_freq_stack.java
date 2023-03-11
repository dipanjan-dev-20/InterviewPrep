package dsa.stack;

import utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class max_freq_stack {

//    Problem Description
//    You are given a matrix A of size N x 2 which represents different operations.
//    Assume initially you have a stack-like data structure you have to perform operations on it.
//
//    Operations are of two types:
//
//            1 x: push an integer x onto the stack and return -1.
//
//            2 0: remove and return the most frequent element in the stack.
//
//    If there is a tie for the most frequent element, the element closest to the top of the stack is removed and returned.
//
//    A[i][0] describes the type of operation to be performed. A[i][1] describe the element x or 0 corresponding to the operation performed.
//
//
//
//            Problem Constraints
//            1 <= N <= 100000
//
//            1 <= A[i][0] <= 2
//
//            0 <= A[i][1] <= 109
//
//
//
//    Input Format
//    The only argument given is the integer array A.
//
//
//
//            Output Format
//    Return the array of integers denoting the answer to each operation.
//
//
//
//            Example Input
//    Input 1:
//
//    A = [
//            [1, 5]
//            [1, 7]
//            [1, 5]
//            [1, 7]
//            [1, 4]
//            [1, 5]
//            [2, 0]
//            [2, 0]
//            [2, 0]
//            [2, 0]  ]
//    Input 2:
//
//    A =  [
//            [1, 5]
//            [2, 0]
//            [1, 4]   ]
//
//
//    Example Output
//    Output 1:
//
//            [-1, -1, -1, -1, -1, -1, 5, 7, 5, 4]
//    Output 2:
//
//            [-1, 5, -1]
//
//
//    Example Explanation
//    Explanation 1:
//
//    Just simulate given operations.
//    Explanation 2:
//
//    Just simulate given operations.

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        arr.add(new ArrayList<>(Arrays.asList(1, 5)));
        arr.add(new ArrayList<>(Arrays.asList(1, 7)));
        arr.add(new ArrayList<>(Arrays.asList(1, 5)));
        arr.add(new ArrayList<>(Arrays.asList(1, 7)));
        arr.add(new ArrayList<>(Arrays.asList(1, 4)));
        arr.add(new ArrayList<>(Arrays.asList(1, 5)));
        arr.add(new ArrayList<>(Arrays.asList(2, 0)));
        arr.add(new ArrayList<>(Arrays.asList(2, 0)));
        arr.add(new ArrayList<>(Arrays.asList(2, 0)));
        arr.add(new ArrayList<>(Arrays.asList(2, 0)));
        ArrayList<Integer> ans = solve(arr);
        ArrayUtils.printList(ans);
    }


    private static ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A) {
        ArrayList<Integer> ans = new ArrayList();
        Map<Integer, ArrayList<Integer>> maxFreqMap = new HashMap();
        Map<Integer, Integer> freqMap = new HashMap();
        int maxFreq = -1;
        for (int i = 0; i < A.size(); i++) {
            ArrayList<Integer> current = A.get(i);
            if (current.get(0) == 1) {
                int currentFreq = 1;
                if (freqMap.containsKey(current.get(1))) {
                    currentFreq = freqMap.get(current.get(1)) + 1;
                }
                freqMap.put(current.get(1), currentFreq);
                if (maxFreqMap.containsKey(currentFreq)) {
                    maxFreqMap.get(currentFreq).add(current.get(1));
                } else {
                    ArrayList<Integer> arr = new ArrayList();
                    arr.add(current.get(1));
                    maxFreqMap.put(currentFreq, arr);
                }
                maxFreq = Math.max(maxFreq, currentFreq);
                ans.add(-1);
            } else {
                ArrayList<Integer> maxList = maxFreqMap.get(maxFreq);
                int max = maxList.get(maxList.size() - 1);
                maxList.remove(maxList.size() - 1);
                maxFreqMap.put(maxFreq, maxList);
                freqMap.put(max, freqMap.get(max) - 1);
                if (maxList.size() == 0) {
                    maxFreq--;
                }
                ans.add(max);

            }
        }


        return ans;
    }


}
