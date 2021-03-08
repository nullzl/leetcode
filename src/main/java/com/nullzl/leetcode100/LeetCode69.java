package com.nullzl.leetcode100;

public class LeetCode69 {

    public int find(int s, int e,int x){
        if(s > e){
            return e;
        }
        long mid = (s + e) >> 1;
        long num = mid * mid;
        if(num == x)
            return (int)mid;
        if(num < x){
            return find((int)(mid+1),e,x);
        }else{
            return find(s,(int)(mid-1),x);
        }
    }

    public int mySqrt(int x) {

        if(0 == x)
            return  0;
        if(1 == x)
            return 1;
        return find(1,x>>1,x);

    }
    public static void main(String[] args){
        System.out.println(new LeetCode69().mySqrt(Integer.MAX_VALUE));
    }
}
