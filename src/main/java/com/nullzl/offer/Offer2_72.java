package com.nullzl.offer;

public class Offer2_72 {

    public int mySqrt(int x) {

        if(0 == x || 1 == x)
            return x;

        long s = 1 , e = (x >> 1);
        while(s <= e){
            long mid = s + ((e - s) >> 1);
            long num = mid * mid;
            if(num > x)
                e = mid - 1;
            else
                s = mid + 1;
        }
        return (int)e;
    }
}
