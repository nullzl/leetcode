package com.nullzl.leetcode1200;

public class LeetCode1103 {
    public int[] distributeCandies(int candies, int num_people) {

        int k = (int)Math.sqrt(2 * candies);
        while(k * k + k < 2 * candies)
            k++;

        int x = (k - 1) / num_people;
        int y = (k - 1) % num_people;

        int[] rs = new int[num_people];
        for(int i = 0 ; i < num_people ; i++){
            int t = x + (i < y ? 1 : 0);
            rs[i] = (((t - 1) * t) / 2) * num_people + (i + 1) * t;
        }
        rs[y] += candies - ((k * (k - 1)) / 2);

        return rs;
    }
}
