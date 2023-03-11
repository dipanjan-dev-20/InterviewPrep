package dsa.stack;

import java.util.ArrayList;

public class min_stack {

//    Problem Description
//
//    Design a stack that supports push, pop, top, and retrieve the minimum element in constant time.
//            push(x) -- Push element x onto stack.
//            pop() -- Removes the element on top of the stack.
//    top() -- Get the top element.
//    getMin() -- Retrieve the minimum element in the stack.
//            NOTE:
//    All the operations have to be constant time operations.
//            getMin() should return -1 if the stack is empty.
//    pop() should return nothing if the stack is empty.
//    top() should return -1 if the stack is empty.
//    Problem Constraints
//
//    1 <= Number of Function calls <= 107
//    Input Format
//
//    Functions will be called by the checker code automatically.
//            Output Format
//
//    Each function should return the values as defined by the problem statement.
//    Example Input
//
//    Input 1:
//    push(1)
//    push(2)
//    push(-2)
//    getMin()
//    pop()
//    getMin()
//    top()
//    Input 2:
//    getMin()
//    pop()
//    top()
//    Example Output
//
//    Output 1:
//            -2 1 2
//    Output 2:
//            -1 -1
//    Example Explanation
//
//    Explanation 1:
//    Let the initial stack be : []
//            1) push(1) : [1]
//            2) push(2) : [1, 2]
//            3) push(-2) : [1, 2, -2]
//            4) getMin() : Returns -2 as the minimum element in the stack is -2.
//            5) pop() : Return -2 as -2 is the topmost element in the stack.
//            6) getMin() : Returns 1 as the minimum element in stack is 1.
//            7) top() : Return 2 as 2 is the topmost element in the stack.
//            Explanation 2:
//             Let the initial stack be : []
//            1) getMin() : Returns -1 as the stack is empty.
//            2) pop() :  Returns nothing as the stack is empty.
//            3) top() : Returns -1 as the stack is empty.

    public static void main(String[] args) {
        MinStack ms = new MinStack();
        ms.push(1);
        ms.push(2);
        ms.push(-2);
        System.out.println(ms.getMin());
        ms.pop();
        System.out.println(ms.getMin());
        System.out.println(ms.top());
    }



    static class MinStack {
        ArrayList<Integer> list = new ArrayList();
        int min = -1;
        public void push(int x) {
            if(list.size()==0){
                list.add(x);
                min = x;
            } else if(x<min){
                int val = (2*x) - min;
                list.add(val);
                min = x;
            } else {
                list.add(x);
            }
        }

        public void pop() {
            if(list.size()>0){
                if(min > list.get(list.size()-1)){
                    min = (2 * min) - list.get(list.size()-1);
                }
                list.remove(list.size()-1);
            }
        }

        public int top() {
            if(list.size()==0){
                return -1;
            } else if(list.get(list.size()-1)<min){
                return  min;
            } else {
                return list.get(list.size()-1);
            }

        }

        public int getMin() {
            if(list.size()==0){
                return -1;
            } else {
                return min;
            }

        }
    }


}
