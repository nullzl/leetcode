package com.nullzl.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Interview1624 {

    public List<List<Integer>> pairSums1(int[] nums, int target) {

        List<List<Integer>> lists = new ArrayList<>();
        if(null == nums || 0 == nums.length)
            return lists;

        HashMap<Integer,Integer> map =new HashMap<>();
        for(int num : nums){
            int count = map.getOrDefault(num,0);
            map.put(num,count + 1);
        }

        for(int num : nums){
            int count1 = map.getOrDefault(num , 0);
            if(0 == count1)
                continue;
            map.put(num, count1 - 1);
            int count2 = map.getOrDefault(target - num ,0);
            if(0 != count2){
                List<Integer> list = new ArrayList<>(2);
                list.add(num);list.add(target - num);
                lists.add(list);
                map.put(target - num , count2 - 1);
            }
        }
        return lists;
    }

    public List<List<Integer>> pairSums(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        if(null == nums || 0 == nums.length)
            return lists;
        Arrays.sort(nums);
        int i = 0 , j = nums.length-1;
        while(i < j){
            int sum = nums[i] + nums[j];
            if(sum == target){
                List<Integer> list = new ArrayList<>(2);
                list.add(nums[i]);list.add(nums[j]);
                lists.add(list);
                i++;j--;
            }else if(sum > target){
                j--;
            }else
                i++;
        }
        return lists;
    }
}
