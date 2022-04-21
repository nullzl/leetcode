package com.nullzl.interview;

public class Interview1616 {

    public int[] subSort(int[] array) {
        if(null == array || 0 == array.length)
            return new int[]{-1,-1};

        int left,right,min,max;
        max = array[0];
        left = array.length;
        right = -1;
        for(int i = 1 ; i < array.length ; i++){
            if(array[i] >= max){
                max = array[i];
            }else{
                right = i;
            }
        }
        if(-1 == right)
            return new int[]{-1,-1};
        min = array[right];
        for(int i = right ; i >= 0 ; i--){
            if(array[i] <= min)
                min = array[i];
            else{
                left = i;
            }
        }
        return  new int[]{left,right};


    }
}
