package com.nullzl.interview;

import java.util.LinkedList;

public class Interview0305 {

    class SortedStack {

        LinkedList<Integer> stk;
        LinkedList<Integer> tempStk;

        public SortedStack() {
            stk = new LinkedList<>();
            tempStk = new LinkedList<>();
        }

        public void push(int val) {
            while(!stk.isEmpty() && stk.peek() < val){
                tempStk.push(stk.pop());
            }
            stk.push(val);
            while(!tempStk.isEmpty())
                stk.push(tempStk.pop());
        }

        public void pop() {
            if(!stk.isEmpty())
                stk.pop();
        }

        public int peek() {
            if(!stk.isEmpty())
                return stk.peek();
            return -1;
        }

        public boolean isEmpty() {
            return stk.isEmpty();
        }
    }
}
