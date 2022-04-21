package com.nullzl.offer;

public class Offer16 {

    public double myPow(double x, int n) {

        if(0 == n)
            return 1;
        if(0 == x)
            return 0;
        long m = n;
        if(m < 0){
            x = 1 / x;
            m = -m;
        }

        long i = 1;
        double num = x;
        double rs = 1;
        for(;i <= m ; i <<= 1){
            if(0 != (i & m)){
                rs *= num;
            }
            num *= num;
        }
        return rs;
    }
}
