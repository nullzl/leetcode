package com.nullzl.leetcode600;

import java.util.Arrays;
import java.util.Random;

public class LeetCode528 {

    private int[] sums;
    private Random random;

    public LeetCode528(int[] w) {
        sums = new int[w.length];
        sums[0] = w[0];
        random =new Random();
        for(int i = 1 ; i < w.length; i++)
            sums[i] = sums[i-1] + w[i];
    }

    public int pickIndex() {
        int tmp = random.nextInt(sums[sums.length - 1]) + 1;
        int index = Arrays.binarySearch(sums,tmp);
        index = index < 0 ? -index - 1 : index;
        return index;
    }
}
