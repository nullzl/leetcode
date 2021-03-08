package com.nullzl.leetcode100;

import java.util.*;

public class LeetCode78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> rs = new LinkedList<List<Integer>>();


        if(null == nums) {
            return rs;
        }

        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0 ; i < nums.length ; i++) {
            map.put(nums[i], i);
            LinkedList<Integer> list = new LinkedList<Integer>();
            list.add(nums[i]);
            rs.add(list);
        }

        ListIterator<List<Integer>> iterator = rs.listIterator();
        while(iterator.hasNext()){
            LinkedList<Integer> item = (LinkedList<Integer>) iterator.next();
            int num = item.getLast();
            int index = map.get(num);
            for(index++; index < nums.length ; index++){
                LinkedList<Integer> list = new LinkedList<Integer>();
                list.addAll(item);
                list.add(nums[index]);
                iterator.add(list);
                iterator.previous();
            }
        }

        rs.add(new LinkedList<Integer>());
        return rs;


    }

    public static void main(String[] args){

    }

}
