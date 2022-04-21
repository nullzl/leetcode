package com.nullzl.interview;

public class Interview0109 {

    public boolean isFlipedString(String s1, String s2) {
        if(s1.length() != s2.length())
            return false;
        String str = s1 + s1;
        return str.indexOf(s2) >= 0;

    }
}
