package com.race;

import java.util.Arrays;

public class LeetCode1898 {

    private boolean check(char[] arr1,char[] arr2,int i,int j,boolean[] deleted){
        if(j == arr2.length)
            return true;
        if(i == arr1.length)
            return false;
        if(deleted[i])
            return check(arr1,arr2,i+1,j,deleted);
        if(arr1[i] == arr2[j])
            return check(arr1,arr2,i+1,j+1,deleted);
        return check(arr1,arr2,i+1,j,deleted);
    }


    public int maximumRemovals(String s, String p, int[] removable) {

        char[] arr1 = s.toCharArray();
        char[] arr2 = p.toCharArray();
        boolean[] deleted = new boolean[arr1.length];
        int l = 0, r = removable.length - 1;
        while(l <= r){
            int mid = l + ((r - l) >> 1);
            Arrays.fill(deleted,false);
            for(int i = 0 ; i <= mid ; i++)
                deleted[removable[i]] = true;
            if(check(arr1,arr2,0,0,deleted)){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return r + 1;

    }
}
