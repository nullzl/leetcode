package com.nullzl.offer;


public class Offer10{



    public final static int MOD = 1000000007;

    public int[][] power(int k){
        int[][][] nums = new int[][][]{
                {{0,1},{1,1}},
                {{1,1},{1,2}},
                {{2,3},{3,5}},
                {{13,21},{21,34}},
                {{610,987},{987,1597}},
                {{1346269,2178309},{2178309,3524578}},
                {{470273943,209783453},{209783453,680057396}},
        };
        int[][] sum = new int[][]{{1,0},{0,1}};
        for(int i = 0; i < nums.length && (1 << i) <= k ; i++){
            if(0 == ((1 << i) & k))
                continue;
            long a1 = ((long)sum[0][0] * nums[i][0][0]) % MOD + ((long)sum[0][1] * nums[i][1][0]) % MOD;
            long a2 = ((long)sum[0][0] * nums[i][0][1]) % MOD + ((long)sum[0][1] * nums[i][1][1]) % MOD;
            long a3 = ((long)sum[1][0] * nums[i][0][0]) % MOD + ((long)sum[1][1] * nums[i][1][0]) % MOD;
            long a4 = ((long)sum[1][0] * nums[i][0][1]) % MOD + ((long)sum[1][1] * nums[i][1][1]) % MOD;
            sum[0][0] = (int)(a1 % MOD);
            sum[0][1] = (int)(a2 % MOD);
            sum[1][0] = (int)(a3 % MOD);
            sum[1][1] = (int)(a4 % MOD);
        }
        return sum;
    }

    public int fib(int n) {
        if(0 == n)
            return 0 ;
        if(1 == n)
            return 1;
        int[][] sum = power(n);
        return sum[0][1];
    }

    public static void main(String[] argc){
        long[][] nums = new long[][]{{0,1},{1,1}};
        for(int i = 2; i < 100 ; i <<= 1){
            long a1 = ((long)nums[0][0] * nums[0][0]) % MOD + ((long)nums[0][1] * nums[1][0]) % MOD;
            long a2 = ((long)nums[0][0] * nums[0][1]) % MOD + ((long)nums[0][1] * nums[1][1]) % MOD;
            long a3 = ((long)nums[1][0] * nums[0][0]) % MOD + ((long)nums[1][1] * nums[1][0]) % MOD;
            long a4 = ((long)nums[1][0] * nums[0][1]) % MOD + ((long)nums[1][1] * nums[1][1]) % MOD;
            nums[0][0] = a1 % MOD;
            nums[0][1] = a2 % MOD;
            nums[1][0] = a3 % MOD;
            nums[1][1] = a4 % MOD;

            System.out.println("{{" + nums[0][0] + "," + nums[0][1] + "}{" + nums[1][0] + "," + nums[1][1] + "}}");
        }
    }

}
