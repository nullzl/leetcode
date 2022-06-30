package com.nullzl.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Offer2_7 {

    int start = 0;
    int[] map;

    private void add(int num){
        map[num - start]++;
    }
    private void remove(int num){
        map[num - start]--;
    }
    private int get(int num){
        int idx = num- start;
        return (idx >= 0 && idx < map.length ? map[idx] : 0) ;
    }

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> lists = new LinkedList<>();
        if(null == nums || nums.length < 3)
            return lists;
        Arrays.sort(nums);
        start = nums[0];
        map = new int[nums[nums.length - 1] - nums[0] + 1];

        for(int num : nums)
            add(num);

        for(int i = 0 ; i < nums.length; i++){
            remove(nums[i]);
            if(0 != i && nums[i] == nums[i-1])
                continue;
            int num = 0 - nums[i];
            for(int j = i + 1; j < nums.length && nums[j] <= (num / 2) ; j++ ){
                if(j != i + 1 && nums[j] == nums[j-1])
                    continue;
                if((nums[j] * 2 == num && get(nums[j]) >= 2) || (nums[j] * 2 != num && get(0- nums[i] - nums[j]) >= 1)){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(0 - nums[i] - nums[j]);
                    lists.add(list);
                }
            }
        }
        return lists;
    }
}
