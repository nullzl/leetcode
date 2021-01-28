package com.nullzl.leetcode1100;

public class LeetCode1013 {

    public boolean canThreePartsEqualSum(int[] A) {

        if(null == A || A.length < 3)
            return false;
        int i;
        for(i = 1 ; i < A.length ; i++)
            A[i] += A[i-1];
        if(0 != A[A.length - 1] % 3)
            return false;
        int partSum = A[A.length - 1] / 3;
        for(i = 0 ;i < A.length-2 ; i++){
            if(partSum == A[i])
                break;
        }
        if(i == A.length - 2)
            return false;
        partSum = partSum << 1;
        for(i++ ; i < A.length - 1 ; i++){
            if(partSum == A[i])
                return true;
        }
        return false;
    }
    public static void main(String[] args){
        System.out.print(new LeetCode1013().canThreePartsEqualSum(
                new int[] {18,12,-18,18,-19,-1,10,10}
        ));
    }
}
