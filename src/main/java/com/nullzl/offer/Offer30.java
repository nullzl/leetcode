package com.nullzl.offer;

import java.util.LinkedList;

public class Offer30 {

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
            if(!stk.isEmpty()) {
                int tmp = stk.pop();
                if(tmp == minStk.peek())
                    minStk.pop();
            }
        }

        public int top() {
            return stk.peek();
        }

        public int min() {
            return minStk.peek();
        }
    }
}
