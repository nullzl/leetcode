package main.java.com.nullzl.leetcode100;

import java.util.*;

public class LeetCode90 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        if(null == nums || 0 == nums.length){
            return new ArrayList<List<Integer>>();
        }

        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0 ; i < nums.length ; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
        }

        int size = 1;
        Iterator<Integer> iterator = map.keySet().iterator();
        while(iterator.hasNext()){
            size *= (map.get(iterator.next()) + 1);
        }
        ArrayList<List<Integer>> rs = new ArrayList<List<Integer>>(size);
        rs.add(new LinkedList<Integer>());

        iterator = map.keySet().iterator();
        while(iterator.hasNext()){
            int key = iterator.next();
            int count = map.get(key);
            int last = rs.size() - 1;
            for(int i = 1 ; i <= count ; i++){
                for(int j = last; j>=0 ; j--){
                    List<Integer> list = rs.get(j);
                    List<Integer> item = new LinkedList<Integer>();
                    item.addAll(list);
                    for(int k = 1; k <= i ; k++)
                        item.add(key);
                    rs.add(item);
                }
            }
        }
        return rs;
    }

    public static void main(String[] args){
        int[] nums = {1,2,2};
        System.out.println(new LeetCode90().subsetsWithDup(nums));
    }
}
