package com.nullzl.offer;

import java.util.LinkedList;

public class Offer57 {

    public int[] twoSum(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;
        while(low < high){
            long num = (long)nums[low] + nums[high];
            if(num == target)
                return new int[]{nums[low],nums[high]};
            else if(num < target)
                low++;
            else
                high--;
        }
        return null;
    }

    public int[][] findContinuousSequence(int target) {

        if(target <= 0 )
            return null;
        LinkedList<int[]> list = new LinkedList<>();
        int num = target << 1;
        int m = (int)Math.sqrt(num);
        for(int i = m ; i > 1 ; i--){
            if(0 != num % i)
                continue;
            int n = num / i;
            int s = Math.abs(m - n);
            if(0 == (1 & n))
                continue;
            s = (s + 1) >> 1;
            int k = Math.min(m,n);
            int[] item = new int[k];
            for(int j = 0 ; j < k ; ){
                item[j++] = s++;
            }
            list.add(item);
            System.out.println(item);
        }
        return list.toArray(new int[0][0]);
    }
}
