package com.nullzl.leetcode1000;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class LeetCode933 {


}

class RecentCounter {

    public final static int LEN = 3001;
    private int[] counter;
    private int max;
    private int count;

    public RecentCounter() {
        counter = new int[LEN];
        max = 0;
        count = 0;
    }

    public int ping(int t) {
        if(t - 3000 > max){
            count = 0;
            Arrays.fill(counter,0);
        }else {
            for (int i = max + 1; i <= t; i++) {
                int j = i % LEN;
                count -= counter[j];
                counter[j] = 0;
            }
        }
        counter[t % LEN] = 1;
        count++;
        max = t;
        return count;
    }
    public static void main(String[] args){
        Random r = new Random();
        int len  = r.nextInt(10000) + 1;

        String line = "[\"RecentCounter\"";
        for(int i = 0 ;i < len ; i++){
            line += ",\"ping\"";
        }
        line += "]";
        System.out.println(line);
        line = "[[]";
        int[] nums = new int[len];
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0 ; i < len ; ){
            int t = r.nextInt(99999) +1;
            if(!set.contains(t)){
                set.add(t);
                nums[i++] = t;
            }
        }
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length ; i++){
            line += ",[" + nums[i] + "]";
        }
        line += "]";
        System.out.println(line);
    }
}