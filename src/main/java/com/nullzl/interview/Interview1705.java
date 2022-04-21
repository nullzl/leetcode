package com.nullzl.interview;

import java.util.Arrays;

public class Interview1705 {

    public String[] findLongestSubarray(String[] array) {
        if(null == array || 0 == array.length)
            return new String[0];
        int max = 100000;
        int[] map = new int[(max << 1) + 1];
        Arrays.fill(map,-2);
        map[max] = -1;
        int sum = 0;
        int s = -1;
        int e = -2;
        for(int i = 0 ; i < array.length ; i++){
            char ch = array[i].charAt(0);
            int num = 1;
            if(ch >= '0' && ch <= '9')
                num = -1;
            sum += num;
            int index = sum + max;
            if(-2 == map[index]){
                map[index] = i;
            }else if(i - map[index] > e - s + 1){
                s = map[index] + 1;
                e = i;
            }
        }
        return -1 == s ? new String[0] : Arrays.copyOfRange(array,s,e + 1);
    }
}
