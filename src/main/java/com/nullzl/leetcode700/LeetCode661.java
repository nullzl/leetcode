package com.nullzl.leetcode700;

public class LeetCode661 {

    private void sum(int i , int j , int[] sum,int[][] img){
        if(i < 0 || i >= img.length || j < 0 || j >= img[i].length)
            return ;
        sum[0] += img[i][j];
        sum[1] += 1;
    }

    public int[][] imageSmoother(int[][] img) {
        int[][] rs = new int[img.length][img[0].length];
        for(int i = 0 ; i < img.length ; i++){
            for(int j = 0 ; j < img[i].length ; j++){
                int[] arr = new int[2];
                sum(i,j,arr,img);
                sum(i-1,j-1,arr,img);
                sum(i-1,j,arr,img);
                sum(i-1,j+1,arr,img);
                sum(i,j-1,arr,img);
                sum(i,j+1,arr,img);
                sum(i + 1,j-1,arr,img);
                sum(i+1,j,arr,img);
                sum(i+1,j+1,arr,img);
                rs[i][j] = 0 == arr[1] ? 0 : arr[0] / arr[1];
            }
        }
        return rs;
    }
}
