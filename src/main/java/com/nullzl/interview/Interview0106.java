package com.nullzl.interview;

public class Interview0106 {

    public String compressString(String S) {
        if(null == S || 0 == S.length())
            return "";
        char[] arr = S.toCharArray();
        StringBuilder rs = new StringBuilder();
        char ch  = arr[0];
        int count = 1;
        int j = 0;
        for(int i = 1 ; i < arr.length ; i++){
            if(arr[i] == ch)
                count++;
            else{
                rs.append(ch);
                rs.append(count);
                ch = arr[i];
                count = 1;
                if(rs.length() >= S.length())
                    return S;
            }
        }
        rs.append(ch);
        rs.append(count);
        return rs.length() >= S.length() ? S : rs.toString();
    }
}
