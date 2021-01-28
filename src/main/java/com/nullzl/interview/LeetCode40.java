package com.nullzl.interview;

import java.util.Arrays;

public class LeetCode40 {

    public int[] getLeastNumbers(int[] arr, int k) {
        if(null == arr || k > arr.length)
            throw new IllegalArgumentException();

        if(0 == k)
            return new int[0];
        if(k == arr.length)
            return arr;

        int[] map = new int[10001];
        int[] rs = new int[k];
        Arrays.stream(arr).forEach(num -> {
            map[num]++;
        });
        int count = k - 1;
        for(int i = 0 ; i < map.length && count >= 0 ; i++){
            while(map[i] > 0 && count >= 0){
                rs[count--] = i;
                map[i]--;
            }
        }
        return rs;
    }

    public static void main(String[] args){
        Arrays.stream(new LeetCode40().getLeastNumbers(
                new int[] {3,2,1,2},
                3
        )).forEach(num -> System.out.print(num + "\t"));
    }
}
