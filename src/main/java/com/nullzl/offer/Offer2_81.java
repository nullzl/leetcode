package com.nullzl.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Offer2_81 {

    List<List<Integer>> lists = new LinkedList<>();

    private void dfs(int[] cadidates,int[] set,int size,int sum,int target,int idx){
        if(sum == target){
            List<Integer> list = new ArrayList<>(size);
            for(int i= 0 ; i < size ; i++)
                list.add(set[i]);
            lists.add(list);
            return ;
        }
        if(sum > target || idx >= cadidates.length)
            return ;
        while(sum <= target){
            dfs(cadidates, set, size, sum, target, idx + 1);
            sum += cadidates[idx];
            set[size++] = cadidates[idx];
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int[] set = new int[target + 1];
        int size = 0;
        dfs(candidates,set,size,0,target,0);
        return lists;
    }
}
