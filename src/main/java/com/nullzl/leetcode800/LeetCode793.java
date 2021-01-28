package com.nullzl.leetcode800;

public class LeetCode793 {

    private int getF(int t){
        int count = 0;
        while(0 != t){
            count += t;
            t /= 5;
        }
        return count;
    }

    public int preimageSizeFZF(int K) {

        int s = 0;
        int e = K;

        while(s <= e){
            int mid = s + ((e - s) >> 1);
            int count = getF(mid);
            if(count == K){
                return 5;
            }
            if(count > K)
                e = mid - 1;
            else
                s = mid + 1;
        }
        return 0;
    }
}
