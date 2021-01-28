package com.nullzl.leetcode400;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LeetCode327 {

    private void update(int[] count,int i){
        while(i < count.length){
            count[i]++;
            i += (i & (-i));
        }
    }

    private int get(int[] count, int i){
        if(0 == i)
            return 0;
        int rs = 0;
        while(i > 0){
            rs += count[i];
            i -= (i & (-i));
        }
        return rs;
    }

    private int query(int[] count,int l,int h){
        return get(count,h) - get(count,l-1);
    }


    public int countRangeSum(int[] nums, int lower, int upper) {
        if(null == nums || 0 == nums.length)
            return 0;

        if(1 == nums.length){
            if(nums[0] >= lower && nums[0] <= upper)
                return 1;
            else
                return 0;
        }

        HashMap<Long,Integer> map = new HashMap<>();
        long[] ns = new long[nums.length];
        ns[0] = nums[0];
        map.put(0L,-1);
        map.putIfAbsent(ns[0], -1);
        map.putIfAbsent(ns[0] - upper,-1);
        map.putIfAbsent(ns[0] - lower,-1);
        for(int i = 1; i < ns.length; i++){
            ns[i] = ns[i-1] + nums[i] ;
            map.putIfAbsent(ns[i], -1);
            map.putIfAbsent(ns[i] - upper,-1);
            map.putIfAbsent(ns[i] - lower,-1);
        }

        long[] copy = new long[map.size()];
        int[] count = new int[map.size() + 1];
        int k = 0;
        Iterator<Map.Entry<Long,Integer>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Long,Integer> entry = iterator.next();
            copy[k++] = entry.getKey();
        }
        Arrays.sort(copy);

        for(k = 0 ; k < copy.length; k++)
            map.put(copy[k],k+1);
        update(count,map.get(0L));

        int rs = 0;
        for(k = 0 ; k < ns.length ; k++){
            int index = map.get(ns[k]);
            int l = map.get(ns[k] - upper);
            int h = map.get(ns[k] -lower);
            rs += query(count,l,h);
            update(count,index);
        }

        return rs;
    }

    public static void main(String[] args){
        System.out.println(new LeetCode327().countRangeSum(
                new int[]{2147483647,-2147483648,-1,0},
                -1,0
        ));
    }
}
