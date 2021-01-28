package com.nullzl.leetcode1600;

import java.util.Random;

public class LeetCode1521 {

    public int closestToTarget(int[] arr, int target) {
         int[] list = new int[20];
         int[] list2 = new int[20];
         int min = Integer.MAX_VALUE;
         int size1 = 0;
         int size2 = 0;

         for(int n : arr){
             list2[size2++] = n;
             min = Math.min(min,Math.abs(n - target));
             for(int i = 0 ; i < size1 ; i++){
                 int t = list[i] & n;
                 if(t != list2[size2 - 1]) {
                     list2[size2++] = t;
                     min = Math.min(min,Math.abs(t - target));
                 }
             }
             int[] tmp  = list;
             list = list2;
             size1 = size2;
             list2 = tmp;
             size2 = 0;
         }
        return min;
    }

    public static  void main(String[] args){
        Random r = new Random();
        LeetCode1521 l = new LeetCode1521();
        for(int i = 0 ; i < 1000; i++){
            int len = r.nextInt(100000) + 1;
            int[] a = new int[len];
            for(int j = 0 ;j < a.length ; j++){
                a[j] = r.nextInt(1000000) + 1;
            }
            int target = r.nextInt(10000000) + 1;

            int ans = l.closestToTarget(a,target);

            int min = Integer.MAX_VALUE;
            for(int x = 0; x < len ; x++){
                int n = 0xFFFFFFFF;
                for(int y = x ; y < len ; y++){
                    n &= a[y];
                    min = Math.min(min,Math.abs(n - target));
                }
            }

            if(min != ans){
                System.out.println("error");
                break;
            }else{
                System.out.println(i + "\t" + len + "ok");
            }
        }
    }
}
