package com.nullzl.leetcode1300;

public class LeetCode1201 {

    private long gcd(long a ,long b){
        if(0 == a % b)
            return b;
        return gcd(b,a%b);
    }

    private long binarySearch(long seq,int a,int b,int c,long ab,long ac,long bc,long abc){
        if(0 == seq)
            return 0;
        long low = 0;
        long high = abc;
        while(low < high){
            long mid = low + ((high - low) >> 1);
            long count = mid / a + mid / b + mid /c
                    - mid / ab - mid / ac - mid / bc;
            if(seq == count)
                return mid;
            if(seq > count)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;
    }

    public int nthUglyNumber(int n, int a, int b, int c) {
        long gcdAB = gcd(a,b);
        long gcdAC = gcd(a,c);
        long gcdBC = gcd(b,c);
        long lcmAB = a / gcdAB * (long)b;
        long lcmAC = a / gcdAC * (long)c;
        long lcmBC = b / gcdBC * (long)c;
        long lcmABC = lcmAB / gcd(lcmAB,c) * c;
        long periodAmount = (lcmABC / a + lcmABC / b + lcmABC / c
                - lcmABC/lcmAB - lcmABC/lcmAC  - lcmABC/lcmBC
                + 1);
        long count = n / periodAmount;
        long seq = n % periodAmount;
        int rs = (int)(count * lcmABC);
        long k = binarySearch(seq,a,b,c,lcmAB,lcmAC,lcmBC,lcmABC);
        k -= (Math.min(k % a , Math.min(k % b,k % c)));
        return (int)(rs + k);
    }

    public static void main(String[] args){
        System.out.println(new LeetCode1201().nthUglyNumber(5,2,3,3));
    }
}
