package com.nullzl.leetcode700;

import java.util.Random;

public class LeetCode688 {



    int[][] step = new int[][]{{2,-2},{1,-1}};

    public double get(double[][][] dp,boolean[][][] fill,int i,int j,int k){
        if(i < 0 || j < 0 || i >= dp.length || j >= dp.length)
            return 0.0;
        if(0 == k)
            return 1.0;

        if(fill[i][j][k])
            return dp[i][j][k];
        double tmp = 0.0;
        for(int x = 0;  x < step.length ; x++){
            int y = 1 - x;
            for(int a = 0 ; a < step[x].length ; a++){
                for(int b = 0 ; b < step[y].length ; b++){
                    double rs = get(dp,fill,i + step[x][a],j + step[y][b],k-1);
                    tmp += (0.125 * rs);
                }
            }
        }
        dp[i][j][k] = tmp;
        fill[i][j][k] = true;
        return tmp;
    }

    public double knightProbability(int N, int K, int r, int c) {
        double dp[][][] = new double[N][N][K+1];
        boolean fill[][][] = new boolean[N][N][K+1];
        return get(dp,fill,r,c,K);
    }

    public static void main(String[] args){
        Random r = new Random();
        int len = (r.nextInt(14) + 10);
        System.out.println(
                len + "\r\n"
                + r.nextInt(101) + "\r\n"
                + (r.nextInt(len)) + "\r\n"
                + (r.nextInt(len))
        );
    }

}
