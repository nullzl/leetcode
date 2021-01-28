package com.nullzl.leetcode700;

import java.util.Arrays;
import java.util.Random;

public class LeetCode646 {

    public int findLongestChain(int[][] pairs) {

        Arrays.sort(pairs, (op1,op2) -> {
            return op1[0] - op2[0];
        });

        int[] dp = new int[pairs.length];
        int size = 0;
        int idx= 0;
        for(int i = 0 ; i < pairs.length ; i++){
            while(idx < size && dp[idx] < pairs[i][0] )idx++;

            if(idx < size && pairs[i][1] < dp[idx])
                dp[idx] = pairs[i][1];
            else if(idx == size)
                dp[size++] = pairs[i][1];
        }
        return size;
    }

    public static void main(String[] args){
        Random r = new Random();
        int len = r.nextInt(1000) + 1;
        System.out.print("[");
        for(int i = 0 ; i < len ; i++){
            int t = r.nextInt(10000) + 1;
            System.out.print("[" + t + "," + (r.nextInt(10000) + t + 1) + "],");
        }
        System.out.print("]\r\n");
//        int[][] ps = new int[][]{{95,172},{39,55},{50,100},{42,70},{60,107},{21,24},{3,58},{61,65},{45,90},{7,28},{31,86},{78,123},{52,120},{89,157},{17,104},{17,25},{53,127},{6,46},{4,61},{53,99},{91,170},{7,8},{99,163},{40,138},{45,74},{10,33},{50,63},{41,72},{75,112},{32,89},{42,72},{99,198}};
//        System.out.println(new LeetCode646().findLongestChain(ps));
    }
}
