package com.nullzl.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Offer2_79 {

    private List<Integer> generate(int[] nums,int set){
        List<Integer> list = new ArrayList<>(nums.length);
        for(int i = 0 ; i < nums.length && 0 != set ; i++){
            if(0 != (1 & set))
                list.add(nums[i]);
            set >>= 1;
        }
        return list;
    }

    public List<List<Integer>> subsets(int[] nums) {
        int count = (1 << nums.length);
        List<List<Integer>> lists = new LinkedList<>();
        for(int i = 0 ; i < count ; i++){
            lists.add(generate(nums,i));
        }
        return lists;
    }
}
