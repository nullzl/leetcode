package com.nullzl.leetcode1100;

import com.nullzl.util.Util;

import java.util.Arrays;
import java.util.Random;

public class LeetCode1049 {



    public int lastStoneWeightII(int[] stones) {
        int sum = Arrays.stream(stones).sum();
        boolean[][] map = new boolean[2][(sum << 1) + 1];
        int[][] set = new int[2][(sum << 1) + 1];
        int size = 0;
        int idx = 0;
        set[idx][size++] = stones[0];
        set[idx][size++] = -stones[0];
        map[idx][stones[0] + sum] = true;
        map[idx][-stones[0] + sum] = true;
        for(int i = 1 ;i < stones.length ; i++){
            int next = (idx + 1) % 2;
            int nsize = 0;
            Arrays.fill(map[idx],false);
            for(int j = 0 ; j < size ; j++){
                int val = set[idx][j] + stones[i];
                if(!map[next][val + sum]){
                    map[next][val + sum] = true;
                    set[next][nsize++] = val;
                }
                val = set[idx][j] - stones[i];
                if(!map[next][val + sum]){
                    map[next][val + sum] = true;
                    set[next][nsize++] = val;
                }
            }
            idx = next;
            size = nsize;
        }
        for(int i = sum ; i < map[idx].length ; i++) {
            if (map[idx][i])
                return i - sum;
        }
        return -1;
    }
    public static void main(String[] args){
        Random r = new Random();
        int len = r.nextInt(10) + 16;
        System.out.println(Util.generateRandomArray(len,1,20));
    }
}
