package com.nullzl.leetcode600;

public class LeetCode556 {

    public int nextGreaterElement(int n) {
        char[] arr = String.valueOf(n).toCharArray();
        int i , j;
        for(i = arr.length - 2 ; i >= 0 && arr[i] >= arr[i+1] ; i--);
        if(-1 == i)
            return -1;
        char tmp = arr[i];
        for(j = i + 1 ; j < arr.length && arr[j] > arr[i] ; j++);
        tmp = arr[--j];
        arr[j] = arr[i];
        arr[i++] = tmp;
        j = arr.length - 1;
        while(i < j){
            tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;j--;
        }
        String num = new String(arr);
        if(Long.parseLong(num) > Integer.MAX_VALUE)
            return -1;
        return Integer.parseInt(num);
    }
}
