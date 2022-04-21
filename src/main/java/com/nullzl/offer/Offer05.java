package com.nullzl.offer;

import java.util.Arrays;

public class Offer05 {
    public String replaceSpace(String s) {
        if(null == s)
            return "";

        char[] arr = s.toCharArray();
        char[] rs = new char[arr.length * 3];
        int size = 0;
        for(int i = 0; i < arr.length ; i++){
            if(' ' == arr[i]){
                rs[size++] = '%';
                rs[size++] = '2';
                rs[size++] = '0';
            }else
                rs[size++] = arr[i];
        }
        return new String(Arrays.copyOf(rs,size));
    }
}
