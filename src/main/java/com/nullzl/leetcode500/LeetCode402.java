package com.nullzl.leetcode500;

import java.util.Random;

public class LeetCode402 {

    public String removeKdigits(String num, int k) {

        if(null == num || 0 == num.length() || k == num.length())
            return "0";
        if(0 == k)
            return num;

        StringBuffer sb = new StringBuffer();
        sb.append(num.charAt(0));
        int i = 1, size = 0;
        int len = num.length() - k;
        while( i < num.length() && size < k){
            if(num.charAt(i) >= sb.charAt(sb.length() - 1)) {
                sb.append(num.charAt(i++));
                continue;
            }
            while(size < k && sb.length() > 0 && sb.charAt(sb.length() - 1) > num.charAt(i)){
                sb.deleteCharAt(sb.length() - 1);
                size++;
            }
            sb.append(num.charAt(i++));
        }
        if(sb.length() < len)
            sb.append(num.substring(i,num.length()));
        while(sb.length() > len)
            sb.deleteCharAt(sb.length() - 1);

        while(sb.length() > 1 && sb.charAt(0) == '0')
            sb.deleteCharAt(0);
        return sb.toString();

    }

    private String test(String num ,int k ){
        StringBuffer sb = new StringBuffer(num);
        for(int i = 0 ; i < k ; i++){
            int j = 0;
            int len = sb.length();
            for(; j < len - 1 ; j++){
                if(sb.charAt(j) > sb.charAt(j + 1)) {
                    sb.deleteCharAt(j);
                    break;
                }
            }
            if(j == len - 1)
                sb.deleteCharAt(j);
        }
        while(sb.length() > 1 && sb.charAt(0) == '0')
            sb.deleteCharAt(0);
        if(sb.length() == 0)
            return "0";
        return sb.toString();
    }

    public static void main(String[] args){
        Random r = new Random();
        LeetCode402 lc = new LeetCode402();
        for(int s = 0 ; s < 1000 ; s++){
            int len = r.nextInt(10003) + 1;
            int k = r.nextInt(len + 1);
            StringBuffer sb = new StringBuffer();
            sb.append((char)('1' + r.nextInt(8)));
            for(int i =  1 ; i < len ; i++){
                sb.append((char)('0' + r.nextInt(9)));
            }
            String num = sb.toString();
            String s1 = lc.removeKdigits(num,k);
            String s2 = lc.test(num,k);
            if(!s1.equals(s2)){
                System.out.println(len + "\t" + k);
                System.out.println(num);
                System.out.println(s1);
                System.out.println(s2);
                break;
            }
        }
    }
}
