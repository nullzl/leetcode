package main.java.com.nullzl.leetcode300;

import java.util.LinkedList;

public class LeetCode225 {

    class MyStack {

        private LinkedList<Integer> queue;

        /** Initialize your data structure here. */
        public MyStack() {
            this.queue = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            this.queue.offerLast(x);
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return this.queue.pollLast();
        }

        /** Get the top element. */
        public int top() {
            return this.queue.peekLast();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return this.queue.isEmpty();
        }
    }
}
