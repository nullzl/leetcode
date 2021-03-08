package com.nullzl.leetcode100;

import java.util.*;

public class LeetCode47 {

    private List<List<Integer>> generate(List<List<Integer>> lists,int num,int count){
        List<List<Integer>> rs = new LinkedList<List<Integer>>();
        Iterator<List<Integer>> iterator = lists.iterator();
        while(iterator.hasNext()){
            List<Integer> item = iterator.next();
            List<Integer> list = new ArrayList<Integer>(item.size() + count);
            for(int i = 0 ; i < count ; i++)
                list.add(num);
            for(int i = 0 ; i < item.size() ; i++)
                list.add(item.get(i));
            rs.add(list);

            for(int i = count ; i > 0 ; i--){
                for(int k = 1 ; k <= item.size() ; k++){
                    list = new ArrayList<Integer>(item.size() + count);
                    for(int j = 0 ; j < count - i ; j++)
                        list.add(num);
                    int x ;
                    for(x = 0 ; x < k ; x++){
                        list.add(item.get(x));
                    }
                    for(int j = 0 ; j < i ; j++)
                        list.add(num);
                    for(;x < item.size();x++)
                        list.add(item.get(x));
                    rs.add(list);
                }
            }
        }
        return rs;
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        if(null == nums || 0 == nums.length)
            return new LinkedList<List<Integer>>();
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0 ; i < nums.length ; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
        }
        List<List<Integer>> rs = new LinkedList<List<Integer>>();
        rs.add(new ArrayList<Integer>());
        Iterator<Integer> iterator = map.keySet().iterator();
        while(iterator.hasNext()){
            int num = iterator.next();
            int count = map.get(num);
            rs = generate(rs,num,count);
        }
        return rs;
    }
}
