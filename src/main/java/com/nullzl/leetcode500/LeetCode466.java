package com.nullzl.leetcode500;

import java.util.HashMap;
import java.util.Random;

public class LeetCode466 {

    private int[] get(int[][][] dp,String s1,String s2,int i ,int j){
        //完成了一次匹配
        if(j == s2.length())
            return new int[]{0,i-1};

        if(null != dp[i][j])
            return dp[i][j];

        int[] rs ;
        if(i == s1.length()){
            rs = get(dp,s1,s2,0,j);
            dp[i][j] = new int[]{rs[0] + 1, rs[1]};
        }else if(s1.charAt(i) == s2.charAt(j)){
            rs = get(dp,s1,s2,i+1,j+1);
            dp[i][j] = new int[]{rs[0], rs[1]};
        }else{
            rs = get(dp,s1,s2,i+1,j);
            dp[i][j] = new int[]{rs[0], rs[1]};
        }
        return dp[i][j];
    }

    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {

        //排除空串
        if(0 == n1)
            return 0;

        //排除s2中包含s1中没有的字符
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0 ; i < s1.length() ; i++){
            map.put(s1.charAt(i),map.getOrDefault(s1.charAt(i),0) + 1);
        }
        for(int i = 0 ; i < s2.length() ; i++){
            if(-1 == map.getOrDefault(s2.charAt(i),-1))
                return 0;
        }

        //s1和s2的匹配，可贪心使用s1中第一个匹配到的字符，不会影响最终结果
        //定义
        //dp[i][j][0]  s1从位置i，s2从位置j开始，匹配完一个s2，还需要s1的数量（当前s1不参与计数）
        //dp[i][j][1]  s1从位置i，s2从位置j开始,匹配结束位置

        //递推公式

        //每次匹配完一个s2，位于s1的位置k，继续从k+1匹配s2.假设s1中为s2[0]的索引为a1，a2，...,ak
        //那么匹配的序列应该是dp[a1][0],dp[ax][0],...，值共有k个所以一定会有循环
        //初始状态为dp[s1.length][0]，表示匹配到s1的结尾。
        int[] next = new int[s1.length() + 1];
        int cur = s1.length();
        next[s1.length()] = cur;
        for(int i = s1.length() - 1; i >= 0 ; i--){
            if(s1.charAt(i) == s2.charAt(0))
                cur = i;
            next[i] = cur;
        }
        int[][][] dp = new int[s1.length() + 1][s2.length()][];
        int key = s1.length();
        int count0 = 0;     //s1计数
        int count1 = 0;     //s2计数
        int interval = 0;
        //辅助数组，找循环点
        int[][] count = new int[s1.length() + 1][];
        count[s1.length()] = new int[]{0,0};

        while(true){
            int[] tmp = get(dp,s1,s2,key,0);
            count0 += tmp[0];
            if(count0 > n1)
                return count1 / n2;
            count1++;
            key = next[tmp[1] + 1];
            if(null != count[key]){
                break;
            }
            count[key] = new int[]{count0,count1};
        }
        n1 -= count0;
        interval = count0 - count[key][0];
        int k = n1 / interval;
        if( 0 != k){
            count1 += (k * (count1 - count[key][1]));
            n1 %= interval;
        }

        while(true){
            int[] tmp = get(dp,s1,s2,key,0);
            if(n1 >= tmp[0]){
                n1 -= tmp[0];
                count1++;
                key = next[tmp[1] + 1];
            }else{
                break;
            }
        }
        return count1 / n2;
    }

    public static void main(String[] args){



//        String s1 = "cgejfdbeeffgfbgdadbgjegdffag";
//        String s2 = "aad";
//        HashSet<Character> set = new HashSet<>();
//        for(int i =0 ;  i < s2.length() ; i++){
//            set.add(s2.charAt(i));
//        }
//        StringBuffer str = new StringBuffer();
//        for(int i = 0 ;i  < s1.length() ;  i++){
//            if(set.contains(s1.charAt(i))){
//                str.append(s1.charAt(i));
//            }
//        }
//        System.out.println(str.toString());


        Random r = new Random();
        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();
        int len1 = r.nextInt(100);
        int len2 = r.nextInt(50) + 1;
        for(int i = 0 ; i < len1 ; i++){
            s1.append((char)('a' + r.nextInt(10)));
        }

        for(int j = 0 ; j < len2 ; j++){
            s2.append((char)('a' + r.nextInt(5)));
        }

        System.out.println(
                "\"" + s1.toString() + "\"\r\n"
                +  (r.nextInt(1000000)) + "\r\n"
                + "\"" +  s2.toString() + "\"\r\n"
                + (r.nextInt(1000))
        );
    }

}
