package com.nullzl.interview;

import java.util.Arrays;

public class Interview0813 {

    public int pileBox(int[][] box) {
        if(null == box || 0 == box.length)
            return 0;
        Arrays.sort(box,(op1,op2) ->{
            if(op1[0] > op2[0])
                return 1;
            else if(op1[0] < op2[0])
                return -1;
            else if(op1[1] > op2[1])
                return 1;
            else if(op1[1] < op2[1])
                return -1;
            else
                return op1[2] - op2[2];
        });

        int max = 0;
        int[] dp = new int[box.length];
        for(int i = 0 ;i < box.length ; i++){
            dp[i] = box[i][2];
            for(int j = i - 1; j >= 0 ; j--){
                if(box[i][0] > box[j][0] && box[i][1] > box[j][1] && box[i][2] > box[j][2]){
                    dp[i] = Math.max(dp[i],box[i][2] + dp[j]);
                }
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
