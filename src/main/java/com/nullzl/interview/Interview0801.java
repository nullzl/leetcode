package com.nullzl.interview;

import java.util.Arrays;

public class Interview0801 {

    public long[][] multipy(long[][] a,long[][] b){
        long[][] rs = new long[a.length][b[0].length];
        for(int i = 0 ; i < a.length ; i++){
            for(int j = 0 ; j < b[0].length ; j++){
                for(int k = 0 ; k < b.length ; k++){
                    rs[i][j] = (rs[i][j] + a[i][k] * b[k][j]) % 1000000007;
                }
            }
        }
        return rs;
    }


    public int waysToStep(int n) {
        int[] nums = new int[]{1,2,4};
        if(n < 4)
            return nums[n - 1];

        n -= 3;
        long[][] steps = new long[][]{
                {0,0,1},
                {1,0,1},
                {0,1,1}
        };
        int bit = 1;
        long[][] rs = new long[][]{
                {1,0,0},
                {0,1,0},
                {0,0,1}
        };
        for(int i = 0 ; i < 31 && 0 != n ; i++,bit <<= 1,n = n & (n - 1)){
            if(0 != (bit & n)){
                rs = multipy(rs,steps);
            }
            steps = multipy(steps,steps);
        }
        Arrays.stream(rs[0]).forEach(k -> System.out.print(k + "\t"));
        System.out.println();
        Arrays.stream(rs[1]).forEach(k -> System.out.print(k + "\t"));
        System.out.println();
        Arrays.stream(rs[2]).forEach(k -> System.out.print(k + "\t"));
        System.out.println();
        return (int) ((rs[0][2] + (rs[1][2] << 1) + (rs[2][2] << 2)) % 1000000007);
    }
}
