package com.nullzl.leetcode900;

import java.util.Arrays;
import java.util.Random;

public class LeetCode862 {

    private int start(int[] nums,int i){
        while(i < nums.length && nums[i] <= 0)
            i++;
        return i;
    }

    public int shortestSubarray(int[] A, int K) {

        int minLen = Integer.MAX_VALUE;
        long[] sums = new long[A.length + 1];
        int[] lens = new int[A.length + 1];
        int[] idx = new int[A.length + 1];
        int i = start(A,0);
        int se  = 1;
        sums[0] = idx[0] = 0;
        lens[0] = i;

        while(i < A.length){
            if(A[i] >= K)
                return 1;

            if(A[i] <= 0){
                long tmp = A[i] + sums[se - 1];
                if(tmp <= 0){
                    i = start(A,i + 1);
                    lens[0] = i;
                    se = 1;
                }else{
                    int k = Arrays.binarySearch(sums,0,se,tmp);
                    k = k < 0 ? -k-1 : k;
                    if(i + 1 - lens[k - 1] >= minLen) {
                        i = start(A, i + 1);
                        se = 1;
                        lens[0] = i;
                    }
                    else{
                        sums[k] = tmp;
                        lens[k] = i + 1;
                        idx[k] = idx[k-1];
                        se = k + 1;
                        i++;
                    }
                }
            }else{
                sums[se] = sums[se - 1] + A[i];
                lens[se] = i + 1;
                int j = idx[se-1];
                while(j < se && (sums[se] - sums[j]) >= K) j++;
                idx[se] = j;
                if(j > 0){
                    minLen = Math.min(minLen,lens[se] - lens[j-1]);
                }
                se++;
                i++;
            }
        }
        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }

    public static void main(String[] args){
//        System.out.print(new LeetCode862().shortestSubarray(new int[]{
//                -140,34,293,-69,491,371
//        },1101));

        Random r = new Random();
        for(int k = 0 ; k < 10000;k++){
            int len = r.nextInt(20000) + 1;
            int[] nums = new int[len];
//            int[] nums = new int[]{-33,-6,-95,-217,-328,-238,398,-481,283,194,429,450,-46,-301,-462,-200};
//            int len = nums.length;
            long[] sums = new long[len + 1];
            int K = r.nextInt(500000) + 1;
            int min = Integer.MAX_VALUE;
//            int K = 1240;
            for(int i = 0 ; i < len ; i++){
                nums[i] = r.nextInt(100000) - 50000;
                sums[i + 1] = sums[i] + nums[i];
            }
            LeetCode862 lc = new LeetCode862();

            int index = lc.shortestSubarray(nums,K);
            for(int i = 0 ; i < sums.length ; i++){
                for(int j = i + 1 ; j < sums.length ; j++){
                    if(sums[j] - sums[i] >= K && j - i < min)
                        min = j - i;
                }
            }
            min = min == Integer.MAX_VALUE ? -1 : min;
//            System.out.println(min == index ? "ok" : "error");
            if(min != index){
                System.out.print("{");
                Arrays.stream(nums).forEach(n -> System.out.print(n + ","));
                System.out.println("}");
                System.out.println(K);
                break;
            }
        }


    }
}
