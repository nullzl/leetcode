package com.nullzl.offer;

public class Offer2_69 {

    public int peakIndexInMountainArray(int[] arr) {
        int s = 0 , e = arr.length - 1;
        while(s <= e){
            int mid = s + ((e - s) >> 1);
            if(mid + 1 >= arr.length || arr[mid] > arr[mid + 1])
                e = mid - 1;
            else
                s = mid + 1;
        }
        return s;
    }
}
