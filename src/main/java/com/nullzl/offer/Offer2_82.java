package com.nullzl.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Offer2_82 {

    List<List<Integer>> ans = new LinkedList<>();

    private void dfs(int[] nums,int[] map,int target,List<Integer> list,int sum,int idx){
        if(sum == target){
            ans.add(new ArrayList<>(list));
            return ;
        }
        if(sum > target || idx >= nums.length)
            return ;

        dfs(nums,map,target,list,sum,idx + 1);
        if(map[nums[idx]] > 0){
            map[nums[idx]]--;
            list.add(nums[idx]);
            dfs(nums,map,target,list,sum + nums[idx],idx);
            map[nums[idx]]++;
            list.remove(list.size() - 1);
        }
    }


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int max = candidates[0];
        for(int num : candidates){
            max = Math.max(max,num);
        }
        int[] map = new int[max + 1];
        for(int num : candidates)
            map[num]++;
        int[] temp  = new int[map.length];
        int size = 0;
        for(int i = 1 ; i < map.length ; i++){
            if(0 != map[i])
                temp[size++] = i;
        }
        int[] nums = Arrays.copyOf(temp,size);
        dfs(nums,map,target,new ArrayList<>(),0,0);
        return ans;
    }
}
