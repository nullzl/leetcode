package com.nullzl.leetcode400;

import java.util.TreeSet;

public class LeetCode363 {

    private void update(int[] sum,int i,int num){
        while(i < sum.length){
            sum[i] += num;
            i += (i & (-i));
        }
    }
    private int query(int[] sum,int i){
        int rs = 0;
        while(i > 0){
            rs += sum[i];
            i -= (i & (-i));
        }
        return rs;
    }
    private int query(int[] sum,int i,int j){
        return query(sum,j+1) - query(sum,i);
    }

    private int maxSum(int[] sum){
        int min = 0;
        int max = Integer.MIN_VALUE;
        int s = 0;

        for(int i = 0 ; i < sum.length ; i++){
            s += sum[i];
            max = Math.max(max,s - min);
            min = Math.min(min,s);
        }
        return max;
    }

    public int maxSumSubmatrix(int[][] matrix, int k) {

        int rows = matrix.length;
        int columns = matrix[0].length;
        int max = Integer.MIN_VALUE;

        int[][] sums = new int[rows][columns + 1];
        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < columns; j++){
                update(sums[i],j+1,matrix[i][j]);
            }
        }

        int[] sum = new int[rows];
        for(int i = 0 ; i < columns ; i++){
            for(int j = i ; j < columns ; j++){

                for(int x = 0 ; x < rows; x++){
                    sum[x] = query(sums[x],i,j);
                }

                //剪枝，如果最大子数组和小于k，那么就不需要去遍历每个子数组和
                //如果等于k，那么可以直接返回
                int m = maxSum(sum);
                if(m == k)
                    return k;
                if(m < k){
                    max = Math.max(max,m);
                    continue;
                }

                //需要遍历，每个位置存储前缀和，前缀和的差就是区间和
                TreeSet<Integer> set = new TreeSet<Integer>();
                set.add(0);
                int s = 0;
                for(int x = 0 ;  x < sum.length ; x++){
                    s += sum[x];
                    Integer num = set.ceiling(s - k);
                    set.add(s);
                    if(null == num)
                        continue;
                    if(num == s - k)
                        return k;
                    max = Math.max(max,s - num);
                }
            }
        }
        return max;
    }

    public static void main(String[] args){
        new LeetCode363().maxSumSubmatrix(new int[][]{
                {5,-4,-3,4},{-3,-4,4,5},{5,1,5,-4}
        },8);
    }
}
