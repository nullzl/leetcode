package com.nullzl.leetcode1600;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class LeetCode1590 {

    public int minSubarray(int[] nums, int p) {

        nums[0] %= p;
        for(int i = 1 ; i < nums.length ; i++)
            nums[i] = (nums[i] + nums[i - 1]) % p;

        if(0 == nums[nums.length - 1])
            return 0;
        int k = nums[nums.length - 1];
        int min = nums.length ;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length - 1 ; i++){
            if(k == nums[i])
                min = Math.min(min,i + 1);
            int t = nums[i] - k;
            t = t < 0 ? p + t : t;
            Integer j = map.get(t);
            if(null != j)
                min = Math.min(min,i - j);
            map.put(nums[i],i);
        }
        Integer j = map.get(0);
        if(null != j)
            min = Math.min(min,nums.length - 1 - j);
        return min == nums.length ? -1 : min;

    }



    public static void main(String[] args){
        Random r  = new Random();
        LeetCode1590 l = new LeetCode1590();
        for(int k = 0 ; k < 10000 ; k++){
            int len = r.nextInt(100) + 1;
            int[] arr = new int[len];
            int p = r.nextInt(100) + 1;
            for(int i = 0 ; i < len; i++)
                arr[i] = r.nextInt(10000) + 1;
            int[] tmp = new int[len];
            System.arraycopy(arr,0,tmp,0,len);
            int min = l.minSubarray(tmp,p);
            int rs = len;
            outer:
            for(int i = 0 ; i < len ; i++){
                for(int j = i ; j < len + 1 && j < len + i ; j++){
                    int sum = 0;
                    for(int x =  0 ; x < i ; x++)
                        sum = (sum + arr[x]) % p;
                    for(int x = j ; x < arr.length ; x++)
                        sum = (sum + arr[x]) % p;
                    if(0 == sum)
                        rs = Math.min(rs,j - i);
                    if(0 == rs || 1 == rs)
                        break outer;
                }
            }
            rs = rs == len ? -1 : rs;
            if(min == rs){
                System.out.println(k + "\t" + len + "\t" + min + "\t" + rs + "\tok");
            }else{
                System.out.println(k + "\t" + len +  "\t" + p + "\t" + min + "\t" + rs + "\terror");
                Arrays.stream(arr).forEach(System.out::println);
                break;
            }
        }
    }
}
