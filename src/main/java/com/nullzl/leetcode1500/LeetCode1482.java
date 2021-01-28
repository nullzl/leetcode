package com.nullzl.leetcode1500;

import java.util.Random;

public class LeetCode1482 {
    public int minDays(int[] bloomDay, int m, int k) {

        if(bloomDay.length / k < m )
            return -1;

        int e = bloomDay[0];
        int s = bloomDay[0];
        for(int b : bloomDay) {
            e = Math.max(e, b);
            s = Math.min(s,b);
        }

        while(s <= e){
            int mid = s + ((e - s) >> 1);
            int count = 0 ;
            int t = -1;
            for(int i = 0 ; i < bloomDay.length && count < m ; i++){
                if(bloomDay[i] <= mid && -1 == t){
                    t = i;
                }else if(bloomDay[i] > mid && -1 != t){
                    count += ((i - t) / k);
                    t = -1;
                }
            }
            if(-1 != t){
                count += ((bloomDay.length - t) / k);
            }

            if(count >= m)
                e = mid - 1;
            else
                s = mid + 1;
        }

        return s;
    }

    public static void main(String[] args){
        Random r = new Random();
        LeetCode1482 l = new LeetCode1482();
        for(int x = 0 ; x < 10000 ; x++){
            int len = r.nextInt(100000) + 1;
            int[] arr = new int[len];
            for(int i = 0 ; i < arr.length ; i++)
                arr[i] = r.nextInt(1000000000) + 1;
            int k = r.nextInt(len / 20 + 1) + 1;
            int m = r.nextInt(len / k) + 1;
            int rs = l.minDays(arr,m,k);

            System.out.print(x + "\t" + len + "\t" + m + "\t" + k + "\t" + rs);

            if(-1 == rs){
                if(m * (long)k <= (long)len) {
                    System.out.println("\terror");
                    break;
                }
            }else{
                int count = 0;
                int t = 0;
                for(int i = 0 ; i < arr.length ; i++){
                    if(arr[i] <= rs - 1)
                        t++;
                    else {
                        count += (t/k);
                        t = 0;
                    }
                }
                count += (t/k);
                if(count >= m){
                    System.out.println("\terror");
                    break;
                }
            }
            System.out.println("\tok");
        }
    }
}
