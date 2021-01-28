package com.nullzl.leetcode1600;

import java.util.Arrays;

public class LeetCode1552 {

    boolean valid(int[] position,int k,int m){
        int dis = 0;
        int count = 0;
        for(int i = 1 ;i < position.length && count + 1 <= m ; i++){
            dis += position[i];
            if(dis >= k){
                count++;
                dis = 0;
            }
        }
        if(count + 1 >= m)
            return true;
        return false;
    }

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int e = position[position.length - 1] - position[0];
        int s = Integer.MAX_VALUE;
        for(int i = position.length - 1 ; i > 0 ; i--) {
            position[i] -= position[i - 1];
            if(position[i] < s)
                s = position[i];
        }

        while(s <= e){
            int mid = s + ((e - s) >> 1);
            if(valid(position,mid,m))
                s = mid + 1;
            else
                e = mid - 1;
        }
        return e;
    }

    public static void main(String[] args){
        System.out.print(new LeetCode1552().maxDistance(new int[]{79,74,57,22},4));
    }
}
