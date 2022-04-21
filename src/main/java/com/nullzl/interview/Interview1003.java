package com.nullzl.interview;

public class Interview1003 {




    public int search1(int[] arr, int target) {

        if(null == arr || 0 == arr.length)
            return -1;

        int s = 0, e = arr.length - 1;
        while(s < e){
            if(arr[s] == target)
                return s;
            int mid = s + ((e - s) >>> 1);
            if(arr[e] == arr[mid])
                e--;
            else if(arr[e] < arr[mid]){
                if(target >= arr[s] && target <= arr[mid])
                    e = mid;
                else
                    s = mid + 1;
            }else{
                if(target > arr[mid] && target <= arr[e])
                    s = mid + 1;
                else
                    e = mid;
            }
        }
        return arr[s] == target ? s : -1;
    }
}
