package com.nullzl.interview;

public class Interview0805 {



    public int multiply(int A, int B) {
        if(0 == B || 0 == A)
            return 0;

        int bit = 1;
        int i = 0;
        int rs = 0;
        for(; i < 31 && 0 != B ; i++,bit <<= 1){
            if(0 != (bit & B)){
                rs += (A << i);
                B -= bit;
            }
        }
        return rs;
    }
}
