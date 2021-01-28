package com.nullzl.leetcode600;

import java.util.Random;

public class LeetCode517 {
    public int findMinMoves(int[] machines) {
        int sum = 0 ;
        for(int m : machines)
            sum += m;

        if(0 != sum % machines.length)
            return -1;

        int num = sum / machines.length;
        int step = 0;
        int need = 0;
        for(int m : machines){
            int s = 0;
            if(need < 0)
                s += Math.abs(need);
            need = m + need - num;
            if(need > 0)
                s += need;
            step = Math.max(s,step);
        }
        return step;
    }

    public static void main(String[] args){
        Random r = new Random();
        int[] nums = new int[100];
        for(int i = 0 ;i < 100; i ++){
            System.out.print(r.nextInt(10000) + ",");
        }
    }
}
