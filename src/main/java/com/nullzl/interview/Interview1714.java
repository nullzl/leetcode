package com.nullzl.interview;

import java.util.Arrays;

public class Interview1714 {

    private void swap(int[] arr,int i,int j){
        if(i != j){
            arr[i] = arr[i] ^ arr[j];
            arr[j] = arr[i] ^ arr[j];
            arr[i] = arr[i] ^ arr[j];

        }
    }
    private void partition(int[] arr,int k,int s, int e){
        if(s >= e)
            return;
        int t = s - 1;
        for(int i = s ; i < e ; i++){
            if(arr[i] < arr[e])
                swap(arr,++t,i);
        }
        swap(arr,++t,e);
        if(t < k)
            partition(arr,k,t + 1,e);
        else if(t > k)
            partition(arr,k,s,t - 1);
    }

    public int[] smallestK(int[] arr, int k) {
        if(0 == k)
            return new int[k];
        partition(arr,k,0,arr.length - 1);
        return Arrays.copyOf(arr,k);
    }
}
