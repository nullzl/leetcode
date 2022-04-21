package com.nullzl.leetcode2100;

public class LeetCode2055 {

    public int[] platesBetweenCandles(String s, int[][] queries) {
        char[] arr = s.toCharArray();
        int[] left  = new int[arr.length];
        int[] right = new int[arr.length];
        int[] sum = new int[arr.length];
        int count = 0;
        int last = Integer.MAX_VALUE;
        int k = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if('*' == arr[i]){
                count++;
            }else{
                while(k <= i) right[k++] = i;
                last = i;
            }
            sum[i] = count;
            left[i] = last;
        }
        while(k < arr.length) right[k++] = Integer.MAX_VALUE;
        int[] rs = new int[queries.length];
        for(k = 0 ; k < queries.length ; k++){
            int[] query = queries[k];
            int i = right[query[0]];
            int j = left[query[1]];
            rs[k] = (i == Integer.MAX_VALUE || j == Integer.MAX_VALUE  || i >= j) ? 0 : sum[j] - sum[i];
        }
        return rs;
    }
}
