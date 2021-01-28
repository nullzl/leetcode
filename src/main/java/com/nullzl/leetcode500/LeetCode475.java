package com.nullzl.leetcode500;

import java.util.Arrays;

public class LeetCode475 {

    public int findRadius(int[] houses, int[] heaters) {

        int radius = 0;
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int i = 0 , j = 0;
        if(houses[0] < heaters[0])
            radius = heaters[0] - houses[0];
        while(i < houses.length && houses[i] < heaters[0])
            i++;
        j++;
        while(i < houses.length && j < heaters.length){
            if(houses[i] <= heaters[j]){
                radius = Math.max(radius,
                        Math.min(houses[i] - heaters[j-1],heaters[j] - houses[i]));
                i++;
            }else
                j++;
        }
        if(i < houses.length)
            radius = Math.max(radius,houses[houses.length - 1] - heaters[heaters.length -1]);

        return radius;
    }
}
