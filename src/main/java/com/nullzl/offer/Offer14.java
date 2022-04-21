package com.nullzl.offer;

public class Offer14 {

    public int cuttingRope1(int n) {

        int[] nums = new int[n + 1];
        nums[1] = 1;

        for(int i = 2 ; i <= n ; i++){
            nums[i] = 0;
            for(int j = 1 ; j < i ; j++){
                nums[i] = Integer.max(nums[i],j * (i - j));
                nums[i] = Integer.max(nums[i],j * nums[i - j]);
            }
        }
        return nums[n];
    }

    public final static int MOD = 1000000007;

    public int cuttingRope(int n) {
        if(n < 4)
            return n - 1;
        else if(n == 4)
            return 4;
        long rs = 1;
        while(n > 4){
            rs = (rs * 3) % MOD;
            n -= 3;
        }
        rs = (rs * n) % MOD;
        return (int)rs;
    }
}
