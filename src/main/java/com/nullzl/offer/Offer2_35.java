package com.nullzl.offer;

import java.util.Arrays;
import java.util.List;

public class Offer2_35 {

    public int findMinDifference(List<String> timePoints) {
        int[] times = new int[timePoints.size()];
        int i = 0;
        for(String s : timePoints){
            times[i++] = Integer.parseInt(s.substring(0,2)) * 60 + Integer.parseInt(s.substring(3,5));
        }
        Arrays.sort(times);
        int min = Integer.MAX_VALUE;
        for(i = 1; i < times.length && 0 != min ; i++){
            min = Math.min(min,times[i] - times[i - 1]);
        }
        min = Math.min(min,times[0] + (24 * 60) - times[times.length - 1]);
        return min;
    }
}
