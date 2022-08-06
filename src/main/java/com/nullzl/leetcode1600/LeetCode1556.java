package com.nullzl.leetcode1600;

public class LeetCode1556 {

    public String thousandSeparator(int n) {
        int i = 1;
        StringBuilder str = new StringBuilder();
        str.append((char)(n % 10 + '0'));
        n /= 10;
        for( ; n > 0 ; n /= 10,i++){
            char ch = (char)(n % 10 + '0');
            if(0 == i % 3)
                str.append('.');
            str.append(ch);
        }
        return str.reverse().toString();
    }
}
