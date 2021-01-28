package com.nullzl.leetcode300;


import java.util.LinkedList;

public class LeetCode232 {

    class MyQueue {

        private LinkedList<Integer> pushStk;
        private LinkedList<Integer> popStk;

        /** Initialize your data structure here. */
        public MyQueue() {
            this.pushStk = new LinkedList<>();
            this.popStk = new LinkedList<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            this.pushStk.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if(!popStk.isEmpty())
                return this.popStk.pop();
            while(!pushStk.isEmpty())
                this.popStk.push(this.pushStk.pop());
            return this.popStk.pop();
        }

        /** Get the front element. */
        public int peek() {
            if(!this.popStk.isEmpty())
                return popStk.peek();
            while(!pushStk.isEmpty())
                this.popStk.push(this.pushStk.pop());
            return this.popStk.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            if(this.popStk.isEmpty() && this.pushStk.isEmpty())
                return true;
            return false;
        }
    }
}
