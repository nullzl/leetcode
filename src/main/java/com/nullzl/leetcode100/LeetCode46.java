package com.nullzl.leetcode100;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LeetCode46 {

    private List<List<Integer>> permuteList(int[] nums,int n){
        if(0 == n){
            List<List<Integer>> lists = new LinkedList<List<Integer>>();
            List<Integer> list = new ArrayList<Integer>(1);
            list.add(nums[0]);
            lists.add(list);
            return lists;
        }
        int len = n + 1;
        List<List<Integer>> lists = permuteList(nums,n-1);
        List<List<Integer>> rs =  new LinkedList<List<Integer>>();
        Iterator<List<Integer>> listsIterator = lists.iterator();
        while(listsIterator.hasNext()){
            List<Integer> list = listsIterator.next();
            for(int i = 0 ; i < len ; i++){
                List<Integer> temp = new ArrayList<Integer>(len);
                int j = 0;
                for(; j < i ; j++){
                    temp.add(list.get(j));
                }
                temp.add(nums[n]);
                for(;j < n ; j++ ){
                    temp.add(list.get(j));
                }
                rs.add(temp);
            }
        }
        return rs;
    }

    public List<List<Integer>> permute(int[] nums) {

        return permuteList(nums,nums.length - 1);

    }
}
