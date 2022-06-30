package com.nullzl.offer;

import java.util.HashMap;

public class Offer2_60 {

    private int partition(int[][] nums,int s,int e){

        int[] temp = nums[s];
        int i = s, j = e;
        while(i < j){
            while(i < j && nums[j][1] < temp[1]) j--;
            nums[i] = nums[j];
            while(i < j && nums[i][1] >= temp[1]) i++;
            nums[j] = nums[i];
        }
        nums[i] = temp;
        return i;
    }

    private void sort(int[][] nums,int s,int e,int k){
        if(s == e)
            return ;
        int idx = partition(nums,s,e);
        if(idx == k)
            return ;
        if(idx < k)
            sort(nums,s + 1, e , k);
        else
            sort(nums,s , e - 1, k );
    }

    public int[] topKFrequent(int[] nums, int k) {

        int size = 0;
        int[][] count = new int[nums.length][];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++){
            int c = map.getOrDefault(nums[i],0);
            if(0 == c){
                nums[size++] = nums[i];
            }
            map.put(nums[i],c + 1);
        }
        for(int i = 0 ; i < size ; i++){
            count[i] = new int[]{i,map.get(nums[i])};
        }
        sort(count,0,size - 1,k);
        int[] ans = new int[k];
        for(int i = 0 ;i < k ; i++){
            ans[i] = nums[count[i][0]];
        }
        return ans;

    }
}
