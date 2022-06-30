package com.nullzl.offer;

public class Offer2_20 {
    public int countSubstrings(String s) {
        char[] arr = s.toCharArray();
        int count = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if(i - 1 >= 0 && arr[i] == arr[i-1])
                continue;
            int x = i - 1, y = i + 1;
            while(x >= 0 && arr[x] == arr[i]) x--;
            while(y < arr.length && arr[y] == arr[i]) y++;
            int len = y - x - 1;
            count += ((len + 1) * len) / 2;
            while(x >= 0 && y < arr.length && arr[x] == arr[y]){
                x--;y++;
            }
            count += (y - x - 1 - len) / 2;
        }
        return count;
    }
}
