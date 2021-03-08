package com.nullzl.leetcode200;

import java.util.HashMap;

public class LeetCode166 {

    public String fractionToDecimal(int numerator, int denominator) {
        long num1 = numerator;
        long num2 = denominator;

        if(0 == num2)
            return "";
        if(0 == num1)
            return "0";

        StringBuffer rs = new StringBuffer();

        if(num1 < 0){
            num1 = Math.abs(num1);
            if(num2 < 0){
                num2 = Math.abs(num2);
            }else{
                rs.append('-');
            }
        }else{
            if(num2 < 0){
                num2 = Math.abs(num2);
                rs.append('-');
            }
        }

        rs = rs.append(num1 / num2);
        num1 = num1 % num2;
        if(0 != num1)
            rs.append('.');
        HashMap<Long,Integer> map = new HashMap<>();
        while(0 != num1){
            num1 *= 10;
            int offset = map.getOrDefault(num1,-1);
            if(-1 != offset){
                rs.insert(offset,'(');
                rs.append(')');
                break;
            }
            map.put(num1,rs.length());
            rs.append(num1 / num2);
            num1 = num1 % num2;
        }
        return rs.toString();
    }

    public static void main(String[] args){
        System.out.println(new LeetCode166().fractionToDecimal(-1,-2147483648));
    }
}
