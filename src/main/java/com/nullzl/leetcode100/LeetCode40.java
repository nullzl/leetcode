package main.java.com.nullzl.leetcode100;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class LeetCode40 {

    private void swap(int[] nums,int i, int j){
        if(i != j){
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[i] ^ nums[j];
        }
    }

    private int partition(int[] nums,int start,int end){
        int num = nums[end];
        int k = start - 1;
        for(int i = start ; i < end ; i++){
            if(nums[i] <= num){
                swap(nums,++k,i);
            }
        }
        swap(nums,++k,end);
        return k;
    }

    private void quickSort(int[] nums,int start,int end){
        if(start < end){
            int k = partition(nums,start,end);
            quickSort(nums,start,k-1);
            quickSort(nums,k + 1,end);
        }
    }

    private void sum3(int[] nums,int target,int start,int[] count,List<List<Integer>> rs){
        if(target == 0){
            List<Integer> list = new LinkedList<Integer>();
            for(int i = 0 ; i < start ; i++){
                for(int j = 0 ; j < count[i] ; j++){
                    list.add(nums[i]);
                }
            }
            rs.add(list);
            return;
        }
        if(target < 0 || start >= nums.length || target < nums[start])
            return ;

        int max = 1;
        int nextStart ;
        for(nextStart = start + 1; nextStart < nums.length ; nextStart++){
            if(nums[nextStart] == nums[start])
                max++;
            else
                break;
        }
        for(int i = 0 ; i <= max && target >= 0 ; i++){
            count[start] = i;
            sum3(nums,target,nextStart,count,rs);
            target -= nums[start];
        }
    }

    public List<List<Integer>> combinationSum3(int[] candidates, int target) {
        List<List<Integer>> rs = new LinkedList<List<Integer>>();
        if(null == candidates || 0 == candidates.length || 0 == target)
            return rs;
        quickSort(candidates,0,candidates.length - 1);
        int[] count = new int[candidates.length];
        sum3(candidates,target,0,count,rs);
        return rs;
    }

    private void sum(int[] nums,int target,int start,int len,HashMap<Integer,Integer> map,int[] count,List<List<Integer>> rs){
        if(0 == target){
            List<Integer> list = new LinkedList<Integer>();
            for(int i = 0 ; i < start ; i++){
                for(int j = 0 ; j < count[i] ; j++){
                    list.add(nums[i]);
                }
            }
            rs.add(list);
            return ;
        }
        if(start >= len || target < 0)
            return ;
        int max = map.get(nums[start]);
        for(int i = 0 ; i <= max && target >= 0 ; i++){
            count[start] = i;
            sum(nums,target,start + 1,len,map,count,rs);
            target -= nums[start];
        }

    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> rs = new LinkedList<List<Integer>>();
        if(null == candidates || 0 == candidates.length || 0 == target)
            return rs;
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        int[] nums = new int[candidates.length];
        int len = 0;
        for(int i = 0 ;i < candidates.length ; i++){
            if(map.containsKey(candidates[i])){
                map.put(candidates[i],map.get(candidates[i]) + 1);
            }else{
                nums[len++] = candidates[i];
                map.put(candidates[i],1);
            }
        }
        int[] count = new int[len];
        sum(nums,target,0,len,map,count,rs);
        return rs;


    }
}
