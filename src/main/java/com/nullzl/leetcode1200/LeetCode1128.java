package com.nullzl.leetcode1200;

import java.util.Random;

public class LeetCode1128 {

    public int numEquivDominoPairs(int[][] dominoes) {

        int maxBits = 4;
        int[] map = new int[1 << (maxBits << 1)];

        int count = 0;
        for(int i = 0 ; i < dominoes.length ; i++){
            int key = (dominoes[i][0] << maxBits) | dominoes[i][1];
            map[key]++;
        }
        for(int i = 1 ; i < 10 ; i ++){
            int tmp = map[(i << maxBits) | i];
            count += ((tmp * (tmp - 1)) >> 1);
            for(int j = i+1 ; j < 10 ; j++){
                tmp = map[(i << maxBits) | j] + map[(j << maxBits) | i];
                count += ((tmp * (tmp - 1)) >> 1);
            }
        }
        return count;
    }

    public static  void main(String[] args){
        Random r = new Random();

        int len = r.nextInt(40000) + 1;
        System.out.print("[");
        System.out.print("[" + (r.nextInt(9) + 1) + "," + (r.nextInt(9) + 1) + "]");
        for(int i = 1; i < len ; i++)
            System.out.print(",[" + (r.nextInt(9) + 1) + "," + (r.nextInt(9) + 1) + "]");
        System.out.print("]");
    }


}
