package com.nullzl.offer;

public class Offer43 {

    public int countDigitOne(int n) {

        int k = 1;
        int high = n / 10;
        int low = 0;
        int cur = n % 10;
        int count = 0;

        while(0 != cur || high != 0){
            int tmp = (high + (cur >= 1 ? 1 : 0)) * k;
            tmp -= (1 == cur ? (k - low - 1) : 0);
            count += tmp;

            low = cur * k + low;
            cur = high % 10;
            high /= 10;
            k *= 10;
        }
        return count;
    }

    public static void main(String[] args){
        System.out.println(Integer.MAX_VALUE);
    }
}
