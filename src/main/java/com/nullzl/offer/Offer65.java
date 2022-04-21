package com.nullzl.offer;

public class Offer65 {

    public int add(int a, int b) {
        int m = 1;
        int n = 0;
        int rs = 0;
        for(int i = 0 ; i < 32 ; i++){
            int x = a & m;
            int y = b & m;
            int t= (x ^ y ^ n);
            n = ((x | y | n) & ~t) | (x & y & n);
            rs |= t;
            m <<= 1;
            n <<= 1;
        }
        return rs;
    }
}
