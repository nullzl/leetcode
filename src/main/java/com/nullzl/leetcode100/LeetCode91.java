package main.java.com.nullzl.leetcode100;

public class LeetCode91 {

    public int numDecodings(String s) {
        if(null ==  s || 0 == s.length())
            return 0;

        int num1 = 1;
        int num2 = 1;
        int num = 0;

        if(s.length() > 0){
            int code = s.charAt(s.length() - 1) - '0';
            num = code * 10;
            if(0 == code)
                num1 = 0;
        }

        for(int i = s.length() - 2; i >= 0 ; i--){
            int code = s.charAt(i) - '0';
            if(0 == code){
                num2 = num1;
                num1 = 0;
            }else{
                int size = num1;
                num = code * 10 + (num / 10);
                if(num >= 1 && num <= 26){
                    size += num2;
                }
                num2 = num1;
                num1 = size;
            }
        }
        return num1;
    }

    public static void main(String[] args){
        System.out.println(new LeetCode91().numDecodings("226"));
    }

}
