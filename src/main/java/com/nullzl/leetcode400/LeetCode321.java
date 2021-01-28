package com.nullzl.leetcode400;

import java.util.Random;

public class LeetCode321 {

    //数组num，取k个数，字典序最大
    //方法1. 动态规划，dp[i][j],表示使用前i个中取j个的字典序最大
    //  dp[i][j] =  max{dp[i-1][j],dp[i-1][j-1] + num[i]}
    //方法2：利用字符串删除k个字符，字典序最大的字符串
    private int[][] getMax(int[] num,int k){
        int len = Math.min(k,(null == num ? 0 : num.length));
        int[][] dp = new int[len + 1][];
        dp[0] = new int[0];
        if(null == num || 0 == num.length)
            return dp;

        int[] stk = new int[num.length];
        int size = 0;
        if(num.length == len){
            dp[len] = new int[num.length];
            System.arraycopy(num,0,dp[len],0,num.length);
        }
        int count = 0;
        for(int i = 0 ; i < num.length ; i++){
            while(size > 0 && num[i] > stk[size - 1]){
                size --;
                count++;
                if(num.length - count <= len){
                    dp[num.length - count] = new int[num.length - count];
                    System.arraycopy(stk,0,dp[num.length - count],0,size);
                    System.arraycopy(num,i,dp[num.length - count],size,num.length - i);
                }
            }
            stk[size++] = num[i];
        }
        for(int i = 1 ; i <= len && null == dp[i] ; i++){
            dp[i] = new int[i];
            System.arraycopy(stk,0,dp[i],0,i);
        }
        return dp;
    }

    private int[] merge(int[] nums1,int[] nums2){
        int i = 0 ;
        int j = 0;
        int k = 0;
        int[] rs = new int[nums1.length + nums2.length];
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] > nums2[j])
                rs[k++] = nums1[i++];
            else if(nums1[i] < nums2[j])
                rs[k++] = nums2[j++];
            else{
                int m = i + 1;
                int n = j + 1;
                //找到相等部分和大于部分
                //相等部分和大于部分，可直接被加入
                while(m < nums1.length && n < nums2.length
                    && nums1[m] == nums2[n] && nums1[m] == nums1[i]){
                    m++;
                    n++;
                }
                int x = m - i;
                while(m < nums1.length && n < nums2.length
                    && nums1[m] == nums2[n] && nums1[m] > nums1[i]){
                    m++;
                    n++;
                }
                x = m - i;
                //找到第一个不相等或者小于的位置
                while(m < nums1.length && n < nums2.length
                        && nums1[m] == nums2[n] && nums1[m] >= nums1[i] ){
                    m++;
                    n++;
                }

                if(n == nums2.length || nums2[n] < nums2[j] || (m != nums1.length && nums1[m] > nums2[n])){
                    System.arraycopy(nums1,i,rs,k,x);
                    i += x;
                    k += x;
                }
                if(m == nums1.length || nums1[m] < nums1[i] || (n != nums2.length && nums2[n] > nums1[m])){
                    System.arraycopy(nums2,j,rs,k,x);
                    j += x;
                    k += x;
                }
            }
        }
        while(i < nums1.length) rs[k++] = nums1[i++];
        while(j < nums2.length) rs[k++] = nums2[j++];
        return rs;

    }

    private int compare(int[] nums1,int[] nums2){
        for(int i = 0 ; i < nums1.length ; i++){
            if(nums1[i] > nums2[i])
                return 1;
            else if(nums1[i] < nums2[i])
                return -1;
        }
        return 0;
    }

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        if(k <= 0 ||
                (null == nums1 ? 0 : nums1.length) + (null == nums2 ? 0 : nums2.length) < k)
        return  new int[0];


        int[][] max1 = getMax(nums1,k);
        int[][] max2 = getMax(nums2,k);

        int[] rs = new int[k];
        for(int i = k - max2.length + 1 ; i < max1.length ; i++){
            int j = k - i;
            int[] tmp = merge(max1[i],max2[j]);
            if(compare(tmp,rs) > 0) {
                rs = tmp;
            }
        }
        return rs;
    }

    private void print(int[] num){
        if(null == num || 0 == num.length){
            System.out.println("[]");
            return ;
        }
        System.out.print("[" + num[0]);
        for(int i = 1 ; i < num.length ; i++) {
            System.out.print("," + num[i]);
        }
        System.out.println("]");
    }

    public static void main(String[] args){

        Random r = new Random();
        int len1 = r.nextInt(1000) + 1;
        int len2 = r.nextInt(1000) + 1;

        int[] nums1 = new int[len1];
        int[] nums2 = new int[len2];
        nums1[0] = r.nextInt(9) + 1;
        nums2[0] = r.nextInt(9) + 1;
        int k = r.nextInt(len1 + len2) + 1;

        System.out.print("[" + nums1[0]);
        for(int i = 1 ; i < len1 ; i++) {
            System.out.print("," + r.nextInt(10));
        }
        System.out.println("]");


        System.out.print("[" + nums2[0]);
        for(int i = 1 ; i < len2 ; i++)
            System.out.print("," + r.nextInt(10));
        System.out.println("]");
        System.out.println(k);


    }

}
