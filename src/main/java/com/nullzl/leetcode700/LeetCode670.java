package com.nullzl.leetcode700;

public class LeetCode670 {

    public int maximumSwap(int num) {

        int maxv = -1,curv = -1;
        int maxf = -1,curf = -1;
        int max = num % 10;
        int maxk = 1;
        int n = num / 10;
        int k = 10;
        while(0 != n){
            int tmp = n % 10;
            if(tmp > max){
                max = tmp;
                maxk = k;
            }else if(tmp < max){
                maxv = max;
                maxf = maxk;
                curv = tmp;
                curf = k;
            }
            n /= 10;
            k *= 10;
        }
        if(- 1== curv)
            return num;
        else
            return num - (maxv * maxf) + (curv * maxf) - (curv * curf) + (maxv * curf);
    }
}
