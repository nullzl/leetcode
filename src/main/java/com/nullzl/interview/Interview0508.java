package com.nullzl.interview;

public class Interview0508 {

    public int[] drawLine(int length, int w, int x1, int x2, int y) {
        if(x2 < x1){
            return drawLine(length,w,x2,x1,y);
        }
        int[] rs = new int[length];
        int m1 = (y * w + x1) / 32;
        int n1 = (y * w + x1) % 32;
        int m2 = (y * w + x2) / 32;
        int n2 = (y * w + x2) % 32;

        int count = (m1 != m2 ? 32 : n2 + 1) - n1;
        int num = 0;
        int bit = 1;
        for(int i = 0 ; i < count ; i++){
            num |= bit;
            bit <<= 1;
        }
        rs[m1] = num;
        for(int i = m1 + 1 ; i < rs.length && i < m2 ; i++)
            rs[i] = -1;
        count = n2 + 1;
        num = 0;
        bit = 0x80000000;
        for(int i = (m1 == m2 ? count : 0) ;i < count ; i++){
            num |= bit;
            bit >>>= 1;
        }
        rs[m2] = m1 == m2 ? rs[m2] : num;
        return rs;
    }
}
