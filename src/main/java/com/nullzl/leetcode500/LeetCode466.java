package com.nullzl.leetcode500;

import java.util.HashSet;
import java.util.Random;

public class LeetCode466 {

    private int[] get(int[][][] dp,String s1,String s2,int i ,int j){
        //完成了一次匹配
        if(j == s2.length())
            return new int[]{0,-1,i-1};

        if(i == s1.length()){
            int[] rs = get(dp,s1,s2,0,j);
            return new int[]{1 + rs[0],rs[1],rs[2]};
        }
        if(null != dp[i][j])
            return dp[i][j];


        int[] rs ;
        if(s1.charAt(i) == s2.charAt(j)){
            rs = get(dp,s1,s2,i + 1,j + 1);
            rs[1] = i;
        }else{
            rs = get(dp,s1,s2,i + 1,j);
        }
        dp[i][j] = rs;
        return rs;

    }

    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {

        //排除空串
        if(0 == n1)
            return 0;

        //排除s2中包含s1中没有的字符
        HashSet<Character> set = new HashSet<>();
        for(int i = 0 ; i < s1.length() ; i++){
            set.add(s1.charAt(i));
        }
        for(int i = 0 ; i < s2.length() ; i++){
            if(!set.contains(s2.charAt(i)))
                return 0;
        }

        //s1和s2的匹配，可贪心使用s1中第一个匹配到的字符，不会影响最终结果
        //定义
        //dp[i][j][0]  s1从位置i，s2从位置j开始，匹配完s2，需要的s1的位置
        //dp[i][j][1]  s1从位置i，s2从位置j开始,s1中匹配开始的位置
        //dp[i][j][2]  s1从位置i，s2从位置j开始,s1中匹配结束的位置
        //递推公式
        // count = (i==0 ? 1 : 0)
        //s1[i] == s2[j]
        //     dp[i][j][0] = count + dp[i+1][j+1][0]
        //     dp[i][j][1] = i
        //     dp[i][j][2] = dp[i+1][j+1][2]
        //s1[i] != s2[j]
        //     dp[i][j][0] = count + dp[i+1][j][0]
        //     dp[i][j][1] = dp[i+1][j][1]
        //     dp[i][j][2] = dp[i+1][j+1][2]
        int[][][] dp = new int[s1.length()][s2.length()][];
        int key = s1.length();
        int count0 = 0;
        int count1 = 0;
        int interval = 0;
        int[][] count = new int[s1.length()][];
        while(n1 != 0){

            int[] tmp = get(dp,s1,s2,key,0);
            key = tmp[1];

            //找到循环位
            if(null != count[key]){
                count0 -= count[key][0];
                interval = count1 - count[key][1];
                break;
            }

            if(n1 >= tmp[0]){
                count[key] = new int[]{count0,count1};
                count0 += tmp[0];
                count1++;
                key = (tmp[2] + 1) % s1.length();
                n1 -= tmp[0];
            }else{
                n1 = 0;
            }
        }

        if( 0 != n1 / count0){
            count1 += ((n1 / count0) * interval);
            n1 %= count0;
        }

        while(0 != n1){
            int[] tmp = get(dp,s1,s2,key,0);
            if(n1 > tmp[0]){
                n1 -= tmp[0];
                count1++;
            }else{
                n1 = 0;
            }
        }
        return count1 / n2;
    }

    public static void main(String[] args){

        "icqngiemnrjllfmdbssirehelfftsppqgfbgtdpnotamiiidbqlrgppjoegdhrqhfpprfhqtahlilgl"
        811307
        "afdgeedcccchbjfcggadbjcj"
        143


        Random r = new Random();
        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();
        int len1 = r.nextInt(100);
        int len2 = r.nextInt(50) + 1;
        for(int i = 0 ; i < len1 ; i++){
            s1.append((char)('a' + r.nextInt(20)));
        }

        for(int j = 0 ; j < len2 ; j++){
            s2.append((char)('a' + r.nextInt(10)));
        }

        System.out.println(
                "\"" + s1.toString() + "\"\r\n"
                +  (r.nextInt(1000000)) + "\r\n"
                + "\"" +  s2.toString() + "\"\r\n"
                + (r.nextInt(1000))
        );
    }

}
