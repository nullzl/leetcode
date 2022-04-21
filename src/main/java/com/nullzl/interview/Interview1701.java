package com.nullzl.interview;

public class Interview1701 {

    public int add(int a, int b) {
        if(0 == a)
            return b;
        if(0 == b)
            return a;

        int c = a ^ b;
        int d = (a & b) << 1;
        return add(c,d);
    }
}
