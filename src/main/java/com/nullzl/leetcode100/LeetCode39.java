package main.java.com.nullzl.leetcode100;

import java.util.LinkedList;
import java.util.List;

public class LeetCode39 {

    public void sum(int[] nums,int target,int start,int[] count,List<List<Integer>> rs){
        if(start >= nums.length)
            return ;
        if(0 == target){
            LinkedList<Integer> list = new LinkedList<Integer>();
            for(int i = 0 ; i < start ; i++){
                for(int j = 0 ;  j < count[i] ; j++){
                    list.add(nums[i]);
                }
            }
            rs.add(list);
            return ;
        }
        int max = target / nums[start];
        int left = target;
        for(int i = 0 ; i <= max ; i++){
            count[start] = i;
            sum(nums,left,start + 1,count,rs);
            left -= nums[start];
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> rs = new LinkedList<List<Integer>>();
        int[] count = new int[candidates.length];
        sum(candidates,target,0,count,rs);
        return rs;
    }
}
