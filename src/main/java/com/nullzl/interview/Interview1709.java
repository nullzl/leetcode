package com.nullzl.interview;

public class Interview1709 {
    public int getKthMagicNumber(int k) {

        int[] nums = new int[k];
        nums[0] = 1;
        int pos3 = 0;
        int pos5 = 0;
        int pos7 = 0;


        for(int i = 1 ; i < k ; ){
            int num3,num5,num7,num;
            num3 = nums[pos3] * 3;
            num5 = nums[pos5] * 5;
            num7 = nums[pos7] * 7;
            if(num3 <= num5 && num3 <= num7){
                num = num3;
                pos3++;
            }else if(num5 <= num3 && num5 <= num7){
                num = num5;
                pos5++;
            }else{
                num = num7;
                pos7++;
            }
            if(num != nums[i - 1])
                nums[i++] = num;
        }
        return nums[k-1];
    }
}
