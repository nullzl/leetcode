package com.nullzl.interview;

public class Interview0506 {

    public int convertInteger(int A, int B) {
        int num = A ^ B;

        int count = 0;
        while(0 != num){
            count++;
            num = num & (num - 1);
        }
        return count;
    }
}
