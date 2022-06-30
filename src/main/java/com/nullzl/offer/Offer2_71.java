package com.nullzl.offer;

import java.util.Random;

public class Offer2_71 {

    class Solution {

        int[] sum;
        Random rnd = new Random();

        public Solution(int[] w) {
            sum = new int[w.length];
            sum[0] = w[0];
            for(int i = 1; i < w.length ; i++){
                sum[i] = sum[i-1] + w[i];
            }
        }

        private int search(int num){
            int s = 0, e = sum.length - 1;
            while(s <= e){
                int mid = s + ((e - s) >> 1);
                if(sum[mid] >= num)
                    e = mid - 1;
                else
                    s = mid + 1;
            }
            return s;
        }

        public int pickIndex() {
            int target = rnd.nextInt(sum[sum.length - 1]) + 1;
            return search(target);
        }
    }
}
