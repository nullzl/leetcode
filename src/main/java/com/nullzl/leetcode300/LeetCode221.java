package com.nullzl.leetcode300;

public class LeetCode221 {

    /**
     * 定义dp[i][j]为以顶点matrix[i][j]为右下顶点的最大正方形
     * 1. 如果matrix[i][j]为0  dp[i][j]=0
     * 2. 如果matrix[i][j]为1，则dp[i][j]= min{dp[i-1][j-1],row[i][j-1],column[j][i-1]}
     *    row[i][j-1]，表示第i行，j-1列及之前1的最大长度
     *    column[j][i-1]，表示第j列，
     * 3. 递推公式优化，matrix[i][j]所在的列1的长度比dp[i-1][j-1]不会对结果产生影响，同样所在行比dp[i-1][j-1]大也不会有影响
     *    dp[i][j] = min{dp[i-1][j],dp[i][j-1],dp[i-1][j-1]} + 1
     */
    public int maximalSquare(char[][] matrix) {

        if(null == matrix || 0 == matrix.length || null == matrix[0] || 0 == matrix[0].length)
            return 0;
        int[] dp = new int[matrix[0].length];
        int preDP = 0;
        int max = 0;
        for(int i = 0 ; i < matrix.length ; i++){
            preDP = dp[0];
            dp[0] = '1' == matrix[i][0] ? 1 : 0;
            if(dp[0] > max)
                max = dp[0];
            for(int j = 1; j < matrix[i].length ; j++){
                int temp = dp[j];
                if('0' == matrix[i][j])
                    dp[j] = 0;
                else{
                    dp[j] = Math.min(Math.min(dp[j-1],dp[j]),preDP) + 1;
                }
                if(dp[j] > max)
                    max = dp[j];
                preDP = temp;
            }
        }
        return max * max;
    }
}
