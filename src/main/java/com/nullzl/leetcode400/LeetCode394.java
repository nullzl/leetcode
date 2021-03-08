package com.nullzl.leetcode400;

public class LeetCode394 {

    private int decodeBracket(String s,int i , StringBuffer rs){
        while(i < s.length() && s.charAt(i) != ']'){
            char ch = s.charAt(i);
            if(ch >= '0' && ch <= '9'){
                i = decodeNumber(s,i,rs);
            }else{
                rs.append(ch);
                i++;
            }
        }
        return i + 1;
    }

    private int decodeNumber(String s, int i ,StringBuffer rs){

        if(i >= s.length() )
            return s.length();
        int j = i;
        while(j < s.length() && s.charAt(j) != '[')
            j++;
        int num = Integer.parseInt(s.substring(i,j));
        StringBuffer brackString = new StringBuffer();
        int next = decodeBracket(s,j  + 1,brackString);
        String str = brackString.toString();
        for(int k = 0 ; k < num;  k++){
            rs.append(str);
        }
        return next;
    }

    public String decodeString(String s) {
        if(null == s || 0 == s.length())
            return "";

        StringBuffer rs = new StringBuffer();
        decodeBracket(s,0,rs);
        return rs.toString();
    }

    public static void main(String[] args){
        System.out.print(new LeetCode394().decodeString("[a]2[abc]3[cd]ef"));
    }
}
