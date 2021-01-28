package main.java.com.nullzl.leetcode100;

public class LeetCode08 {

    public int myAtoi(String str) {

        if(null == str || 0 == str.length())
            return 0;
        int i;
        int sign = 1;
        long result = 0;
        char ch ;
        for(i = 0 ; i < str.length() ; i++){
            if(' ' != str.charAt(i))
                break;
        }

        if(i == str.length())
            return 0;

        if('+' == str.charAt(i)){
            i++;
        }else if('-' == str.charAt(i)){
            sign = -1;
            i++;
        }

        for(; i < str.length() ; i++){
            ch = str.charAt(i);
            if(ch >= '0' && ch <= '9'){
                result = result * 10  + (ch - '0');
            }else
                break;
            if(sign * result < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
            if(sign * result > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
        }
        return (int)(sign * result);

    }

    public static void main(String[] args){
        System.out.println(new LeetCode08().myAtoi("4193 with words"));
    }
}
