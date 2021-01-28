package main.java.com.nullzl.interview;

import java.util.LinkedList;

public class LeetCode59 {

    class MaxQueue {

        private LinkedList<Integer> queue;
        private LinkedList<Integer> stk;

        public MaxQueue() {
            queue = new LinkedList<>();
            stk = new LinkedList<>();
        }

        public int max_value() {
            if(stk.isEmpty())
                return -1;
            return stk.peekFirst();
        }

        public void push_back(int value) {
            queue.addLast(value);
            while(!stk.isEmpty() && stk.peekLast() < value)
                stk.pollLast();
            stk.addLast(value);
        }

        public int pop_front() {
            if(queue.isEmpty())
                return -1;
            int val = queue.pollFirst();
            if(val == stk.peekFirst())
                stk.pollFirst();
            return val;
        }
    }
}
