package com.nullzl.leetcode1700;

import java.util.Arrays;

public class LeetCode1654 {

    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        int max = Arrays.stream(forbidden).max().getAsInt();
        boolean[] map = new boolean[max + 1];
        for(int num : forbidden)
            map[num] = true;

        return 0;
    }
}
