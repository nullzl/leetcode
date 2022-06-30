package com.nullzl.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Offer2_84 {
    List<List<Integer>> ans = new LinkedList<>();

    private void dfs(int[] nums,int[] count,int size,int total,List<Integer> list){
        if(list.size() == total){
            ans.add(new ArrayList<>(list));
            return ;
        }

        for(int i = 0 ; i < size ; i++){
            if(0 == count[i])
                continue;
            list.add(nums[i]);
            count[i]--;
            dfs(nums,count,size,total,list);
            count[i]++;
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        int[] map = new int[21];
        for(int n : nums)
            map[n + 10]++;

        int[] count = new int[nums.length];
        int size = 0;
        for(int i = 0 ; i < map.length ; i++){
            if(0 != map[i]){
                nums[size] = i - 10;
                count[size++] = map[i];
            }
        }
        dfs(nums,count,size,nums.length,new ArrayList<>());
        return ans;
    }
}
