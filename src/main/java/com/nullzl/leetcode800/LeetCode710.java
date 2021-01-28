package com.nullzl.leetcode800;

import java.util.Arrays;
import java.util.Random;

public class LeetCode710 {


    //思路2：将max-arr.len中黑名单中的数映射到max-arr.len到N的没有在黑名单中的数。

    private int max;
    private int[] arr;
    Random random;

    public LeetCode710(int N, int[] blacklist) {
        max = N - blacklist.length;
        arr = blacklist;
        random =new Random();
        if(0 != arr.length)
            Arrays.sort(arr);
        for(int i = 0 ; i < arr.length ; i++)
            arr[i] -= (i + 1);
    }

    private int search(int[] arr,int key){
        if(arr[0] > key)
            return key;

        int s = 0;
        int e = arr.length - 1;
        while(s <= e){
            int mid = s + ((e - s) >> 1);
            if(arr[mid] >= key)
                e = mid - 1;
            else
                s = mid + 1;
        }
        return key + s ;
    }

    public int pick() {
        int tmp = random.nextInt(max);
        if(0 == arr.length)
            return tmp;
        return search(arr,tmp);
    }


}
