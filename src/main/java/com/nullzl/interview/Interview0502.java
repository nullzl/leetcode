package com.nullzl.interview;

public class Interview0502 {

    public String printBin(double num) {
        char[] arr = new char[32];
        arr[0] = '0';arr[1] = '.';
        int size = 2;

        while (size < arr.length && 0 != num){
            num *= 2;
            if(num >= 1){
                arr[size++] = '1';
                num -= 1;
            }else{
                arr[size++] = '0';
            }
        }
        return 0 == num ? new String(arr,0,size) : "ERROR";
    }
}
