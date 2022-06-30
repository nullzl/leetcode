package com.nullzl.offer;

import com.nullzl.util.Util;

import java.util.HashSet;

public class Offer2_67 {

    public int findMaximumXOR(int[] nums) {
        int k , t = 0;
        int ans = 0;
        HashSet<Integer> set = new HashSet<>();
        for(k = (1 << 30) ; k > 0 ; k >>= 1){
            t |= k;
            set.clear();
            for(int num : nums){
                set.add(num & t);
            }
            int temp = ans | k;
            for(int num : nums){
                if(set.contains((num & t) ^ temp)){
                    ans = temp;
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args){
        System.out.println(Util.generateRandomArray(15000,0,Integer.MAX_VALUE - 10));
    }
}
