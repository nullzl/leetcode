package com.nullzl.interview;

public class Interview0507 {

    public int exchangeBits(int num) {
        int even = 0x55555555;
        int odd = 0xAAAAAAAA;

        odd |= num;
        even |= num;

        return (odd >>> 1) | (even << 1);
    }
}
