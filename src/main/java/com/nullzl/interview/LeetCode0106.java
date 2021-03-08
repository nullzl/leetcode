package com.nullzl.interview;

public class LeetCode0106 {
    public String compressString(String S) {

        if(null == S || 0 == S.length() )
            return S;

        char[] str = S.toCharArray();
        StringBuffer rs = new StringBuffer();
        int count = 1;
        rs.append(str[0]);
        char preChar = str[0];
        for(int i = 1 ; i < str.length ; i++){
            char ch = str[i];
            if(ch == preChar){
                count++;
            }else{
                rs.append(count);
                count = 1;
                rs.append(ch);
                preChar = ch;
            }
        }
        rs.append(count);
        if(rs.length() >= S.length())
            return S;
        return rs.toString();
    }
}
