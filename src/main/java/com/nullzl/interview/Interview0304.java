package com.nullzl.interview;

import java.util.LinkedList;

public class Interview0304 {

    class MyQueue {

        private LinkedList<Integer> pollStk;
        private LinkedList<Integer> offerStk;

        /** Initialize your data structure here. */
        public MyQueue() {
            this.pollStk = new LinkedList<>();
            this.offerStk = new LinkedList<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            this.offerStk.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if(this.pollStk.isEmpty()){
                while(!this.offerStk.isEmpty())
                    this.pollStk.push(this.offerStk.pop());
            }
            return this.pollStk.pop();
        }

        /** Get the front element. */
        public int peek() {
            if(this.pollStk.isEmpty()){
                while(!this.offerStk.isEmpty())
                    this.pollStk.push(this.offerStk.pop());
            }
            return this.pollStk.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return this.pollStk.isEmpty() && this.offerStk.isEmpty();
        }
    }
}
