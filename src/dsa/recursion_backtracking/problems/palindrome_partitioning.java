package dsa.recursion_backtracking.problems;

import utils.ArrayUtils;

import java.util.ArrayList;

public class palindrome_partitioning {
//    Problem Description
//    Given a string A, partition A such that every string of the partition is a palindrome.
//
//    Return all possible palindrome partitioning of A.
//
//    Ordering the results in the answer : Entry i will come before Entry j if :
//    len(Entryi[0]) < len(Entryj[0]) OR
//            (len(Entryi[0]) == len(Entryj[0]) AND len(Entryi[1]) < len(Entryj[1])) OR * * *
//            (len(Entryi[0]) == len(Entryj[0]) AND ... len(Entryi[k] < len(Entryj[k]))
//
//
//    Problem Constraints
//      1 <= len(A) <= 15
//
//
//
//    Input Format
//    First argument is a string A of lowercase characters.
//
//
//
//            Output Format
//    Return a list of all possible palindrome partitioning of s.
//
//
//
//    Example Input
//    Input 1:
//
//    A = "aab"
//    Input 2:
//
//    A = "a"
//
//
//    Example Output
//    Output 1:
//
//            [
//            ["a","a","b"]
//            ["aa","b"],
//            ]
//    Output 2:
//
//            [
//            ["a"]
//            ]
//
//
//    Example Explanation
//    Explanation 1:
//
//    In the given example, ["a", "a", "b"] comes before ["aa", "b"] because len("a") < len("aa").
//    Explanation 2:
//
//    In the given example, only partition possible is "a" .

    public static void main(String[] args) {
        ArrayList<ArrayList<String>> ans = partition("abbab");
        ArrayUtils.printListOfList(ans);
    }

    private static ArrayList<ArrayList<String>> partition(String a) {
        ArrayList<ArrayList<String>> ans = new ArrayList();
        recurse(0,a,new ArrayList(),ans);
        return ans;
    }

    private static void recurse(int i, String s, ArrayList<String> current, ArrayList<ArrayList<String>> ans){
        if(i == s.length()){
            ans.add(new ArrayList(current));
            return;
        }
        for(int j = i;j<s.length();j++){
            if(isPalindrome(s,i,j)){
                current.add(s.substring(i,j+1));
                recurse(j+1,s,current,ans);
                current.remove(current.size()-1);
            }
        }
    }

    private static boolean isPalindrome(String s, int i ,int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
