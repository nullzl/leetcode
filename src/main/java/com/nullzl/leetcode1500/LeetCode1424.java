package com.nullzl.leetcode1500;

import java.util.Arrays;
import java.util.List;

public class LeetCode1424 {
    //超时
    public int[] findDiagonalOrder1(List<List<Integer>> nums) {
        Integer[][] copy = new Integer[nums.size()][];
        int total = 0;
        int m = nums.size() , n = 0 , i = 0;
        for(List<Integer> list : nums){
            copy[i++] = list.toArray(new Integer[0]);
            total += list.size();
            n = Math.max(n,list.size());
        }
        int[] ans = new int[total];
        i = 0;
        for(int k = 0 ; k < m + n - 1 ; k++){
            int x = Math.min(m-1,k);
            int y = k - x;
            while(x >= 0 && y < n){
                if(y < copy[x].length)
                    ans[i++] = copy[x][y];
                x--;
                y++;
            }
        }
        return ans;
    }


    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Integer[][] copy = new Integer[nums.size()][];
        int total = 0;
        int m = nums.size() , n = 0 , i = 0;
        for(List<Integer> list : nums){
            copy[i++] = list.toArray(new Integer[0]);
            total += list.size();
            n = Math.max(n,list.size());
        }
        int[] ans = new int[total];
        int[] count = new int[m + n + 1];
        int[] left;
        for(i = 0 ; i < copy.length ; i++){
            count[i + 1]++;
            count[i + copy[i].length + 1]--;
        }
        for(i = 1 ; i < count.length ; i++)
            count[i] += count[i-1];
        left = Arrays.copyOfRange(count,1,m + n );
        for(i = 1; i < count.length ; i++)
            count[i] += count[i-1];
        for(int x = 0 ; x < copy.length ; x++){
            for(int y = 0 ; y < copy[x].length ; y++){
                int idx = count[x + y] + (--left[x + y]);
                ans[idx] = copy[x][y];
            }
        }
        return ans;
    }

}
