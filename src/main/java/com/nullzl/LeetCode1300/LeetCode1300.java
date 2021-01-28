package com.nullzl.LeetCode1300;

import java.util.Arrays;
import java.util.Random;

public class LeetCode1300 {

    private int search(int[] arr,int target){
        int s = 0;
        int e = arr.length - 1;
        while(s <= e){
            int mid = s + ((e - s) >> 1);
            if(arr[mid] <= target)
                s = mid + 1;
            else
                e = mid - 1;
        }
        return s;
    }

    public int findBestValue(int[] arr, int target) {

        Arrays.sort(arr);

        int[] sums = new int[arr.length];
        sums[0] = arr[0];
        for(int i = 1 ; i < arr.length ; i++)
            sums[i] = arr[i] + sums[i-1];

        int s = 0;
        int e = arr[arr.length - 1];
        while(s <= e){
            int mid = s + ((e - s) >> 1);
            int index = search(arr,mid);

            int tmp = (index == 0 ? 0 : sums[index - 1]) + (arr.length - index) * mid;

            if(tmp <= target)
                s = mid + 1;
            else
                e = mid - 1;
        }

        if(s > arr[arr.length - 1])
            return e;

        int si = search(arr,s);
        int ei = search(arr,e);
        int ss = (si == 0 ? 0 : sums[si - 1]) + (arr.length - si) * s;
        int es = (ei == 0 ? 0 : sums[ei - 1]) + (arr.length - ei) * e;
        if(Math.abs(ss - target) >= Math.abs(es - target))
            return e;
        return s;

    }

    public static void main(String[] args){
        LeetCode1300 l = new LeetCode1300();
        Random r = new Random();
        for(int i = 0 ; i < 10000 ; i++){
            int len = r.nextInt(10000) + 1;
            int[] arr = new int[len];
            for(int j = 0 ; j < len ; j++){
                arr[j] = r.nextInt(10000) + 1;
            }
            int target = r.nextInt(100000) + 1;

            int s = l.findBestValue(arr,target);

            System.out.print(i + "\t" + len + "\t" + s);

            int sum1 = 0;
            int sum2 = 0;
            int sum3 = 0;
            for(int t : arr){
                if(t <= s)
                    sum1 += t;
                else
                    sum1 += s;

                if(t <= s - 1)
                    sum2 += t;
                else
                    sum2 += (s-1);

                if(t <= s + 1)
                    sum3 += t;
                else
                    sum3+=(s + 1);
            }

            int a1 = Math.abs(sum1 - target);
            int a2 = Math.abs(sum2 - target);
            int a3 = Math.abs(sum3 - target);

            if(a3 < a1 || a2 <= a1){
                System.out.println("\terror");
                break;
            }else
                System.out.println("\tok");
        }
    }
}
