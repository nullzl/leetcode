package com.nullzl.leetcode500;

import java.util.Arrays;

public class LeetCode451 {

    public String frequencySort(String s) {
        int[][] counter = new int[256][2];
        for(int i = 0 ; i < counter.length ; i++)
            counter[i][0] = i;

        char[] arr = s.toCharArray();
        for(char ch : arr)
            counter[(int)ch][1]++;
        Arrays.sort(counter,(op1,op2) ->{
            return -Integer.compare(op1[1],op2[1]);
        });
        for(int i = 0,j = 0 ; i < counter.length && counter[i][1] > 0 ; i++){
            char ch = (char)counter[i][0];
            for(int k = 0 ; k < counter[i][1]; k++)
                arr[j++] = ch;
        }
        return new String(arr);
    }
}
