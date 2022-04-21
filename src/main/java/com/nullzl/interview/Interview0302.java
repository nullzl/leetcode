package com.nullzl.interview;

import java.util.LinkedList;

public class Interview0302 {

    class MinStack {

        private LinkedList<Integer> stk;
        private LinkedList<Integer> minStk;

        /** initialize your data structure here. */
        public MinStack() {
            stk = new LinkedList<>();
            minStk = new LinkedList<>();
        }

        public void push(int x) {
            stk.push(x);
            if(minStk.isEmpty() || x <= minStk.peek())
                minStk.push(x);
        }

        public void pop() {
            int val = stk.pop();
            if(val == minStk.peek())
                minStk.pop();
        }

        public int top() {
            return stk.peek();
        }

        public int getMin() {
            return minStk.peek();
        }
    }
}
