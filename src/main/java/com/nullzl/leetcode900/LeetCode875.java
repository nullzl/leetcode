package com.nullzl.leetcode900;

import java.util.Random;

public class LeetCode875 {

    private int getTime(int[] piles,int p){
        int time = 0 ;
        for(int t : piles){
            time += (t / p + (t % p == 0 ? 0 : 1) );
        }
        return time;
    }

    public int minEatingSpeed(int[] piles, int H) {


        int s = 1;
        int e = piles[0];
        for(int t : piles) {
            e = Math.max(e, t);
        }
        while(s <= e){
            int mid = s + ((e - s) >> 1);
            int time = getTime(piles,mid);
            if(time <= H)
                e = mid - 1;
            else
                s = mid + 1;
        }
        return s;
    }


    private int getT(int[] ps,int p){
        int time = 0;
        if(0 == p)
            return Integer.MAX_VALUE;
        for(int i = 0 ; i < ps.length ; i++){
            time += (ps[i] / p + (ps[i] % p == 0 ? 0 : 1));
        }
        return time;
    }

    public static void main(String[] args){
        Random r = new Random();
        LeetCode875 l = new LeetCode875();
        for(int i = 0 ; i < 10000 ; i++){
            int len = r.nextInt(10000) + 1;
            int[] ps = new int[len];
            int H = r.nextInt(1000000000 - len ) + 1;
            for(int k= 0 ; k < len ; k++)
                ps[k] = r.nextInt(1000000000) + 1;

            int min = l.minEatingSpeed(ps,H);

            int time1 = l.getT(ps,min);
            int time2 = l.getT(ps,min - 1);
            if(time1 <= H && time2 > H){
                System.out.println(i + "\tok");
            }else{
                System.out.println("error");
                break;
            }
        }
    }
}
