package com.nullzl.offer;

public class Offer2_75 {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        int max = 0;
        for(int num : arr1){
            max = Math.max(max,num);
        }

        int[] count = new int[max + 1];
        for(int num : arr1)
            count[num]++;
        int i = 0;
        for(int num : arr2){
            while(count[num] > 0){
                arr1[i++] = num;
                count[num]--;
            }
        }

        for(int j = 0 ; j < count.length ; j++){
            while(count[j] > 0){
                arr1[i++] = j;
                count[j]--;
            }
        }
        return arr1;
    }


}
