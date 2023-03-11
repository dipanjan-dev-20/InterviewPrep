package dsa.recursion_backtracking.problems;

import utils.ArrayUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class invalid_parentheses {

    public static void main(String[] args) {
        ArrayList<String> ans = solve("))())()))(()((");
        ArrayUtils.printList(ans);
    }

    private static ArrayList<String> solve(String A) {
        Set<String> set = new HashSet();
        int minR = minRemoval(A);
        recurse(A,minR,set);
        ArrayList<String> ans = new ArrayList();
        for(String s : set) {
            ans.add(s);
        }
        return ans;
    }

    private static void recurse(String s,int min,Set<String> set){
        if(min == 0){
            boolean isValid = minRemoval(s) == 0;
            if(isValid){
                if(!set.contains(s)){
                    set.add(s);
                }
            }
            return;
        }
        for(int i =0;i<s.length();i++){
            String left = s.substring(0,i);
            String right = s.substring(i+1);
            recurse(left + right,min-1,set);
        }
    }

    private static int minRemoval(String str){
        Stack<Character> stk = new Stack();
        for(int i = 0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch == '('){
                stk.push(ch);
            } else if(ch == ')'){
                if(stk.size()==0){
                    stk.push(ch);
                } else if(stk.peek()==')'){
                    stk.push(ch);
                } else {
                    stk.pop();
                }
            }
        }
        return stk.size();
    }

}
