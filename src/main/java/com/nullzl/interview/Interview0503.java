package com.nullzl.interview;

public class Interview0503 {

    public int reverseBits(int num) {

        int sum = 0;
        int right = 0;
        int bit = 1;
        int count = 0;
        for(int i = 0 ; i < 32 ; i++){
            int n = num & bit;
            if(0 == n){
                sum = sum - right + 1;
                right = sum;
            }else{
                sum++;
            }
            bit <<= 1;
            count = Math.max(count , sum);
        }
        return count;
    }
}
