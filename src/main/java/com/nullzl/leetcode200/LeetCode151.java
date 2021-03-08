package com.nullzl.leetcode200;

public class LeetCode151 {

    private void reverse(StringBuffer str,int s,int e){
        while(s < e){
            char ch = str.charAt(s);
            str.setCharAt(s,str.charAt(e));
            str.setCharAt(e,ch);
            s++;
            e--;
        }
    }

    public String reverseWords1(String s) {

        if(null == s || 0 == s.length())
            return s;

        StringBuffer str = new StringBuffer(s);
        reverse(str,0,str.length() - 1);
        int b = -1;
        for(int i = 0 ; i < str.length() ; i++){
            char ch = str.charAt(i);
            if(' ' == ch && -1 != b){
                reverse(str,b,i-1);
                b = -1;
            }else if(' ' != ch && -1 == b){
                b = i;
            }
        }
        if(-1 != b)
            reverse(str,b,str.length() - 1);
        int i = 0;
        int index = 0;
        boolean hasBlank = false;
        while(i < str.length() && ' ' == str.charAt(i))
            i++;
        for(; i < str.length() ; i++){
            if(' ' != str.charAt(i)){
                if(hasBlank)
                    hasBlank = false;
                if(index++ != i)
                    str.setCharAt(index+-1,str.charAt(i));
            }else if(!hasBlank){
                if(index++ != i)
                    str.setCharAt(index-1,' ');
                hasBlank = true;
            }
        }
        if(index > 0 && ' ' == str.charAt(index - 1))
            index--;
        return str.substring(0,index).toString();
    }

    public String reverseWords2(String s) {

        if(null == s || 0 == s.length())
            return s;

        int e = s.length() - 1;
        int b = 0;
        while(e >= 0 && ' ' == s.charAt(e))
            e--;
        while(b < s.length() && ' ' == s.charAt(b))
            b++;
        int k = -1;
        if(e >= b)
            k = e;
        else
            return "";
        StringBuffer rs = new StringBuffer(e-b+1);
        for(; e >= b ; e--){
            if(' ' == s.charAt(e)){
                if(-1 != k){
                    for(int j = e + 1 ; j <= k ; j++){
                        rs.append(s.charAt(j));
                    }
                    rs.append(' ');
                    k = -1;
                }
            }else if(' ' != s.charAt(e) && -1 == k){
                k = e;
            }
        }
        if(-1 != k){
            for(int j = e + 1 ; j <= k ; j++){
                rs.append(s.charAt(j));
            }
        }
        return rs.toString();

    }

    public String reverseWords(String s) {

        if(null == s || 0 == s.length())
            return s;

        int e = s.length() - 1;
        int b = 0;
        while(e >= 0 && ' ' == s.charAt(e))
            e--;
        while(b < s.length() && ' ' == s.charAt(b))
            b++;
        int k = -1;
        if(e >= b)
            k = e;
        else
            return "";
        StringBuffer rs = new StringBuffer(e-b+1);
        for(; e >= b ; e--){
            if(' ' == s.charAt(e)){
                if(-1 != k){
                    rs.append(' ');
                    k = -1;
                }
            }else if(' ' != s.charAt(e) && -1 == k){
                k = e;
            }
        }
        if(-1 != k){
            for(int j = e + 1 ; j <= k ; j++){
                rs.append(s.charAt(j));
            }
        }
        return rs.toString();

    }
    public static void main(String[] args){
        System.out.print(new LeetCode151().reverseWords("   jdlsjf     abs yui   "));
        System.out.print("***");
    }
}
