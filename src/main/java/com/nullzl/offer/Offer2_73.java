package com.nullzl.offer;

public class Offer2_73 {

    private int eat(int[] piles,int s){
        int count = 0;
        for(int num : piles){
            int temp = num / s;
            count += (temp * s == num ? temp : temp + 1);
        }
        return count;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int max = piles[0];
        for(int num : piles)
            max = Math.max(max,num);

        int s = 1, e = max;
        while(s < e){
            int mid = s + ((e - s) >> 1);
            int k = eat(piles,mid);
            if(k <= h)
                e = mid;
            else
                s = mid + 1;
        }
        return s;
    }
}
