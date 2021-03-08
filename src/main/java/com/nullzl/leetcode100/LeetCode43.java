package com.nullzl.leetcode100;

public class LeetCode43 {

    private StringBuilder add(StringBuilder num1,StringBuilder num2){

        if(num1.length() < num2.length()){
            return add(num2,num1);
        }
        int add = 0;
        int i ;
        StringBuilder rs = new StringBuilder(num1);
        for(i = 0 ; i < num2.length() ;i++){
            int sum = rs.charAt(i) - '0' + num2.charAt(i) - '0' + add;
            rs.setCharAt(i,(char)((sum % 10) + '0'));
            add = sum / 10;
        }
        while(i < rs.length() && 0 != add){
            int sum = rs.charAt(i) - '0' + add;
            rs.setCharAt(i,(char)((sum % 10) + '0'));
            add = sum / 10;
            i++;
        }
        while(0 != add){
            rs.append(add % 10);
            add = add / 10;
        }
        return rs;
    }

    public String multiply(String num1, String num2) {

        if(null == num1 || null == num2 || 0 == num1.length() || 0 == num2.length())
            return "0";

        if(num2.length() < num1.length())
            return multiply(num2,num1);
        StringBuilder[] rsCache = new StringBuilder[10];
        rsCache[0] = new StringBuilder("0");
        rsCache[1] = new StringBuilder((num2)).reverse();
        for(int i = 2 ;i < 10 ; i++){
            rsCache[i] = new StringBuilder(rsCache[i-1]);
            rsCache[i] = add(rsCache[i],rsCache[1]);
        }

        StringBuilder sum = new StringBuilder("0");
        StringBuilder prefix = new StringBuilder("");
        for(int i = num1.length() - 1 ; i >= 0 ; i--){
            int index = num1.charAt(i) - '0';
            StringBuilder rs = new StringBuilder(prefix);
            rs.append(rsCache[index]);
            sum = add(sum,rs);
            prefix.append('0');
        }
        return sum.reverse().toString();
    }

    public static void main(String[] args){
        new LeetCode43().multiply("123","456");
    }
}
