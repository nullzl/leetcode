package com.nullzl.leetcode900;

public class LeetCode878 {
    private int gcd(int a ,int b){
        if(0 == b)
            return a;
        if(0 == a % b)
            return b;
        else
            return gcd(b,a % b);
    }
    private int  binarySearch(int count,int A,int B,int lcm){
        if (0 == count)
            return 0;
        int low = 0;
        int high = lcm;
        while(low < high){
            int mid = low + ((high - low) >> 1);
            int seq = mid / A + mid / B;
            if(seq == count)
                return mid;
            else if(seq > count)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }
    public int nthMagicalNumber(int N, int A, int B) {

        int lcm = A / gcd(A,B) * B;
        int periodAmount = lcm / A + lcm / B - 1;
        int count = N / periodAmount;
        int seq = N % periodAmount;
        long rs = (long)lcm * count;
        int k = binarySearch(seq,A,B,lcm);
        rs += ( k -  Math.min(k % A, k % B));
        return (int)(rs % 1000000007);

    }

    public static void main(String[] args){
        System.out.print(new LeetCode878().nthMagicalNumber(3,6,4));
    }
}
