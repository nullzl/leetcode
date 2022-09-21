package com.nullzl.leetcode1200;

import java.util.Arrays;
import java.util.Random;

public class LeetCode1156 {

    public int maxRepOpt1(String text) {
        char[] arr = text.toCharArray();
        int[] start = new int[26];
        int[] end = new int[26];
        Arrays.fill(start,arr.length);
        Arrays.fill(end,-1);

        for(int i = 0 ; i < arr.length ; i++){
            int idx = arr[i] - 'a';
            start[idx] = Math.min(start[idx],i);
            end[idx] = i;
        }

        int max = 1;
        int s = 0, e = 0 , m = -1;
        for(e++; e < arr.length ; e++){
            if(arr[e] != arr[s]){
                if(-1 == m)
                    m = e;
                else if(1 == e - m){
                    if(arr[e] == arr[m]){
                        s = m;
                        m = -1;
                    }else{
                        s = m;
                        m = e;
                    }
                }else if(2 == e - m && arr[e] == arr[m]){
                    s = m;
                    m++;
                }else{
                    s = m + 1;
                    m = e;
                }
            }
            int idx = arr[s] - 'a';
            max = Math.max(max,(e - s + 1)
                    + (-1 == m ? (start[idx] < s || end[idx] > e ? 1 : 0) : (start[idx] < s || end[idx] > e ? 0 : -1)));
        }
        return max;
    }

    public static void main(String[] args){
        int len = 19999;
        char[] arr = new char[len];
        Random r = new Random();
        for(int i = 0 ; i < len ; i++){
            arr[i] = (char)(r.nextInt(3) + 'a');
        }
        System.out.println(new String(arr));
    }
}
