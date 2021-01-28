package com.nullzl.leetcode700;

public class LeetCode668 {

    public int findKthNumber(int m, int n, int k) {

        if(m > n)
            return findKthNumber(n,m,k);

        int s = 1;
        int e = m * n;

        while(s <= e){
            int mid = s + ((e - s) >> 1);
            int j = (mid / n);
            int count = Math.min(j,m) * n;
            for(int i = m ; i > j && count < k ; i--){
                count += Math.min(mid/i,n);
            }

            if(count >= k)
                e = mid - 1;
            else
                s = mid + 1;
        }
        return s;
    }
}
