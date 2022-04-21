package com.nullzl.interview;

public class Interview1706 {

    public int numberOf2sInRange(int n) {
        int left = n / 10;
        int cur = n % 10;
        int right = 0;
        int k = 1;
        int count = 0;
        while(0 != left || 0 != cur){
            if(cur < 2){
                count += (left * k);
            }else if(cur == 2){
                count += (left * k + right + 1);
            }else{
                count += (left + 1) * k;
            }
            right += cur * k;
            k *= 10;
            cur = left % 10;
            left = left / 10;
        }
        return count;
    }
}
