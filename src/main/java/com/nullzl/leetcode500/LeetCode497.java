package com.nullzl.leetcode500;

import java.util.Arrays;
import java.util.Random;

public class LeetCode497 {

    private int[] sums ;
    private int[][] rects ;
    Random random ;

    public LeetCode497(int[][] rects) {
        this.random = new Random();
        this.sums = new int[rects.length];
        this.rects = rects;
        sums[0] = (rects[0][2] - rects[0][0] + 1) * (rects[0][3] - rects[0][1] + 1);
        for(int i = 1 ; i < rects.length ; i++){
            sums[i] = sums[i-1] + (rects[i][2] - rects[i][0] + 1) * (rects[i][3] - rects[i][1] + 1);
        }
    }

    public int[] pick() {
        int tmp = this.random.nextInt(sums[sums.length - 1]);
        int index = Arrays.binarySearch(sums,tmp);
        if(index < 0)
            index = - index - 1;
        else
            index++;
        tmp = tmp - (0 == index  ? 0 : sums[index - 1]);
        int width = rects[index][2] - rects[index][0] + 1;
        return new int[]{rects[index][0] + tmp % width, rects[index][1] + tmp / width};
    }

    public static  void main(String[] args){
        int[][] r = new int[][]{
                {1,1,5,5}
        };
        new LeetCode497(r).pick();
    }
}
