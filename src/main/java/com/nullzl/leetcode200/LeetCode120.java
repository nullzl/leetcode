package com.nullzl.leetcode200;

import java.util.Iterator;
import java.util.List;

public class LeetCode120 {

    public int minimumTotal(List<List<Integer>> triangle) {

        if(null == triangle || 0 == triangle.size())
            return 0;
        int[] nums = new int[triangle.size()];

        Iterator<List<Integer>> listIterator = triangle.iterator();
        nums[0] = listIterator.next().get(0);
        while(listIterator.hasNext()){
            List<Integer> list = listIterator.next();
            Iterator<Integer> iterator = list.iterator();
            int preVal = nums[0];
            nums[0] = nums[0] + iterator.next();
            int i = 1;
            while(iterator.hasNext()){
                int temp = nums[i];
                nums[i] = ((i == list.size() -1) ? preVal : Math.min(preVal,nums[i])) + iterator.next();
                i++;
                preVal = temp;
            }
        }
        int min = nums[0];
        for(int i = 1; i < triangle.size() ; i++){
            min = Math.min(min,nums[i]);
        }
        return min;
    }
}
