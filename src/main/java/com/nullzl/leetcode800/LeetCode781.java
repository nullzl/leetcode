package com.nullzl.leetcode800;

import com.nullzl.util.Util;

import java.util.Arrays;

public class LeetCode781 {

    public int numRabbits(int[] answers) {
        int max = Arrays.stream(answers).max().getAsInt() + 1;
        int[] counter = new int[max];

        for(int num : answers){
            counter[num]++;
        }
        int count = 0;
        for(int i = 0 ; i < counter.length ; i++){
            count += ((counter[i] / (i + 1)) + (0 == counter[i] % (i + 1) ? 0 : 1)) * (i + 1);
        }
        return count;
    }
    public static void main(String[] args){
        System.out.println(Util.generateRandomArray(1000,0,15));
    }
}
