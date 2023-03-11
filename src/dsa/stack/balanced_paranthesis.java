package dsa.stack;

import java.util.Stack;

public class balanced_paranthesis {

//    Problem Description
//    Given an expression string A, examine whether the pairs and the orders of “{“,”}”, ”(“,”)”, ”[“,”]” are correct in A.
//
//    Refer to the examples for more clarity.
//
//
//
//    Problem Constraints
//      1 <= |A| <= 100
//
//
//
//    Input Format
//    The first and the only argument of input contains the string A having the parenthesis sequence.
//
//
//
//    Output Format
//    Return 0 if the parenthesis sequence is not balanced.
//
//    Return 1 if the parenthesis sequence is balanced.
//
//
//
//            Example Input
//    Input 1:
//
//    A = {([])}
//    Input 2:
//
//    A = (){
//        Input 3:
//
//        A = ()[]
//
//
//        Example Output
//        Output 1:
//
//        1
//        Output 2:
//
//        0
//        Output 3:
//
//        1
//
//
//        Example Explanation
//        You can clearly see that the first and third case contain valid paranthesis.
//
//        In the second case, there is no closing bracket for {, thus the paranthesis sequence is invalid.

    public static void main(String[] args) {
        boolean ans = solve("{([])}");
        System.out.println(ans);
    }

    private static boolean solve(String A) {
        Stack<Character> stk = new Stack();
        for (int i = 0; i < A.length(); i++) {
            char current = A.charAt(i);
            if (isOpening(current)) {
                stk.push(current);
            } else {
                if (stk.isEmpty()) {
                    return false;
                } else {
                    char top = stk.peek();
                    if ((current == ')' && top == '(') ||
                            (current == '}' && top == '{') ||
                            (current == ']' && top == '[')) {
                        stk.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        return stk.empty();
    }

    private static boolean isOpening(char ch) {
        return ch == '{' || ch == '(' || ch == '[';
    }

    private static boolean isClosing(char ch) {
        return ch == '}' || ch == ')' || ch == ']';
    }
}
