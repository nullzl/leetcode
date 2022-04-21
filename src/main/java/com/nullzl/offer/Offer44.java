package com.nullzl.offer;


public class Offer44 {



    public int findNthDigit(int n) {

        if(n < 10)
            return n;

        long count = n - 10;
        int k = 2;
        long m = 10;

        while(count > 9 *m * k){
            count -= 9 * m * k;
            m *= 10;
            k++;
        }

        long times = count / k;
        long mod = count % k;

        if(0 == mod)
            return (int)((m + times - 1) % 10);

        long num = m + times;
        for(int i = 0 ; i < k - mod ; i++)
            num /= 10;
        return (int)(num % 10);

    }
}
