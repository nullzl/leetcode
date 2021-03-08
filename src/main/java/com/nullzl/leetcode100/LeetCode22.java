package com.nullzl.leetcode100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode22 {


    private void generate(List<String> rs,int[] num){
        StringBuilder str = new StringBuilder("(");
        int sum = 0;
        for(int i = 0 ; i < num.length; i++){
            for(int j = 0 ; j < num[i] ; j++){
                str.append(")");
            }
            sum += num[i];
            str.append("(");
        }
        int len = num.length + 1 - sum;
        for(int j = 0 ; j < len ; j++ )
            str.append(")");
        rs.add(str.toString());
    }

    public List<String> generateParenthesis1(int n) {

        LinkedList<String> rs = new LinkedList<String>();
        if(n <= 0)
            return rs;
        if(1 == n){
            rs.add("()");
            return rs;
        }
        int[] num = new int[n-1];
        int sum = 0;
        generate(rs,num);
        while(true){
            int curSum = sum;
            int add = 1;
            for(int i = num.length - 1 ; i >= 0 && 0 != add ; i--){
                int max = i + 2;
                int preNum = num[i];
                num[i] = num[i] + add;
                add = num[i] / max;
                num[i] = num[i] % (max);
                sum += (num[i] - preNum);
                curSum += (num[i] - preNum);
                if(sum >= n || curSum > i + 1){
                    add = 1;
                    sum -= num[i];
                    curSum -= num[i];
                    num[i] = 0;
                }else{
                    curSum = curSum - num[i];
                }
            }
            if(1 == add){
                break;
            }
            generate(rs,num);
        }
        return rs;
    }

    private List<String> generate(int n,LinkedList<String>[] cache){
        if(null != cache[n])
            return cache[n];
        if(0 == n){
            LinkedList<String> list = new LinkedList<String>();
            list.add("");
            cache[0] = list;
            return list;
        }
        LinkedList<String> list = new LinkedList<String>();
        for(int i = 0 ; i < n ; i++){
            List<String> leftList = generate(i,cache);
            List<String> rightList = generate(n-1-i,cache);
            for(String left : leftList){
                for(String right : rightList){
                    list.add(new StringBuilder("(").append(left).append(")").append(right).toString());
                }
            }
        }
        cache[n] = list;
        return list;
    }

    public List<String> generateParenthesis(int n) {
        LinkedList<String>[] cache = new LinkedList[n+1];
        return generate(n,cache);
    }
}
