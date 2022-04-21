package com.nullzl.interview;

public class Interview0103 {

    public String replaceSpaces(String S, int length) {
        if(null == S)
            return "";
        char[] arr = S.toCharArray();
        int i = length - 1, j = arr.length - 1;
        for(; i >= 0 ; i--){
            if(' ' == arr[i]){
                arr[j--] = '0';
                arr[j--] = '2';
                arr[j--] = '%';
            }else
                arr[j--] = arr[i];
        }
        return new String(arr,j+1,arr.length - j - 1);
    }
}
