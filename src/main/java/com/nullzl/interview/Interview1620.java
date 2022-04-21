package com.nullzl.interview;

import java.util.ArrayList;
import java.util.List;

public class Interview1620 {

    private char index(char ch){
        int num = ch - 'a';
        if(num <= 14)
            return (char)('0' + (2 + num/3));
        else if(num <= 18)
            return (char)('0' + 7);
        else if(num <= 21)
            return (char)('0' + 8);
        return (char)('0' + 9);
    }


    public List<String> getValidT9Words(String num, String[] words) {
        List<String> list = new ArrayList<>();
        if(null == num || 0 == num.length() || null == words || 0 == words.length)
            return list;

        char[] chs = num.toCharArray();
        for(String s : words){
            if(s.length() != chs.length)
                continue;
            char[] ws = s.toCharArray();
            int i = 0 ;
            for(; i < ws.length && chs[i] == index(ws[i]) ; i++);
            if(i == ws.length)
                list.add(s);
        }
        return list;
    }
}
