package com.nullzl.leetcode500;

import java.util.Random;

public class LeetCode413 {

    private int get(int[] num,int size,int k){
        k = k - 3;
        if(k < size)
            return size;

        if(0 == size)
            num[size++] = 1;

        while(size <= k){
            num[size] = num[size - 1] + ++size;
        }
        return size;
    }

    public int numberOfArithmeticSlices(int[] A) {

        if(null == A || A.length < 3)
            return 0;

        long pre = (long)A[1] - A[0];
        int size = 0;
        int s = 0;
        int amount = 0;
        int i ;
        for(i = 2 ; i < A.length ; i++){
            long diff = (long)A[i] - A[i - 1];
            if(diff != pre){
                if(i - s > 2){
                    size = get(A,size,i-s);
                    amount += A[i - s - 3];
                }
                pre = diff;
                s = i - 1;
            }
        }
        if(i - s > 2){
            size = get(A,size,i-s);
            amount += A[i - s - 3];
        }
        return amount;
    }

    public static void main(String[] args){
        Random r = new Random();
        int len = r.nextInt(1000) + 500;
        System.out.print("[" + (r.nextInt(20) - 10));
        for(int i = 0 ; i < len  ; i++){
            System.out.print("," + (r.nextInt(20) - 10));
        }
        System.out.println("]");
    }
}
