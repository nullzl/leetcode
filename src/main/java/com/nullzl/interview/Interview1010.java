package com.nullzl.interview;

public class Interview1010 {


    class StreamRank {

        private final int MAX = 50002;
        private int[] count = new int[MAX];

        public StreamRank() {

        }

        private int qurey(int x){
            int sum = 0;
            while(0 != x){
                sum += count[x];
                x = x & (x - 1);
            }
            return sum;
        }

        private void update(int x,int c){
            while(x < count.length){
                count[x] += c;
                x += (x & (-x));
            }
        }

        public void track(int x) {
            int index = x + 1;
            update(index,1);
        }

        public int getRankOfNumber(int x) {
            return qurey(x + 1);
        }
    }
}
