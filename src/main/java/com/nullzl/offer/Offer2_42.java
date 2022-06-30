package com.nullzl.offer;

import java.util.LinkedList;

public class Offer2_42 {

    class RecentCounter {

        private LinkedList<Integer> queue ;

        public RecentCounter() {
            queue = new LinkedList<>();
        }

        public int ping(int t) {
            queue.offer(t);
            while(!queue.isEmpty() && queue.peek() < t - 3000)
                queue.poll();
            return queue.size();
        }
    }
}
