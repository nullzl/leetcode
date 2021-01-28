package main.java.com.nullzl.leetcode100;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LeetCode77 {

    private List<List<Integer>> generateCmobine(int[] nums,int start,int end,int t,int k){
        List<List<Integer>> rs = new LinkedList<List<Integer>>();
        if(1 == t){
            for(int i = start ; i <= end ; i++){
                List<Integer> list = new ArrayList<Integer>(k);
                list.add(nums[i]);
                rs.add(list);
            }
            return rs;
        }
        for(int i = start ; i <= end - t + 1; i++){

            List<List<Integer>> lists = generateCmobine(nums,i+1,end,t-1,k);
            Iterator<List<Integer>> iterator = lists.iterator();
            while(iterator.hasNext()){
                List<Integer> list = iterator.next();
                list.add(nums[i]);
                rs.add(list);
            }

        }
        return rs;
    }

    public List<List<Integer>> combine(int n, int k) {



        List<List<Integer>> rs = new LinkedList<List<Integer>>();
        if(0 == n || 0 == k || k > n)
            return rs;
        int[] nums = new int[n];
        for(int i = 0 ; i < n ; )
            nums[i] = ++i;

        return generateCmobine(nums,0,n - 1,k,k);
    }
}
