package com.nullzl.leetcode700;

import java.util.Random;

public class LeetCode639 {
    public int numDecodings(String s) {



        char preCh = s.charAt(0);
        if('0' == preCh)
            return 0;
        long pre1 = preCh == '*' ? 9 : 1;
        long pre2 = 1;
        long mod = 1000000007;

        for(int i = 1; i < s.length() ; i++){
            char ch = s.charAt(i);
            long count = 0;
            if('0' == ch){
                if('1' == preCh || '2' == preCh)
                    count = pre2;
                else if('*' == preCh)
                    count = (2 * pre2) % mod;
                else
                    return 0;
            }else if('0' == preCh){
                count = '*' == ch ? ((9*pre1)%mod) : pre1;
            }else if(preCh == '1'){
                if(ch != '*'){
                    count = (pre1 + pre2) % mod;
                }else{
                    count = (9 * (pre1 + pre2)) % mod;
                }
            }else if(preCh == '2'){
                if(ch == '*'){
                    count = (9 * pre1 + 6 * pre2) % mod;
                }else if(ch >= '1' && ch <= '6'){
                    count = (pre1 + pre2) % mod;
                }else{
                    count = pre1;
                }
            }else if(preCh >= '3' && preCh <= '9'){
                if(ch == '*'){
                    count = (9 * pre1) % mod;
                }else{
                    count = pre1;
                }
            }else if(preCh == '*'){
                if(ch == '*'){
                    count = (((9 * pre1) % mod) + ((15 * pre2) % mod)) % mod;
                }else if(ch >= '1' && ch <= '6'){
                    count = (pre1 + 2 * pre2) % mod;
                }else{
                    count = (pre1 + pre2) % mod;
                }
            }
            preCh = ch;
            pre2 = pre1;
            pre1 = count;
        }
        return (int)pre1;
    }

    public static void main(String[] args){
        Random r = new Random();
        StringBuffer s = new StringBuffer();
        int len = r.nextInt(10000) + 1;
        for(int i = 0 ; i < len ; i++){
            int k = r.nextInt(11);
            if(k == 0){
                s.append((char)(r.nextInt(2) + 1 + '0'));
                s.append('0');
            }else if(k < 10)
                s.append((char)(k + '0'));
            else
                s.append('*');
        }
        System.out.println(s.toString());
    }
}
