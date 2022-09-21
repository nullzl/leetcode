package com.nullzl.leetcode900;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LeetCode842 {

    private boolean valid(List<Integer> list,long num1,long num2,int s,char[] arr){
        if(s == arr.length)
            return -1 != num1 && -1 != num2 && list.size() > 2;
        if(-1 == num1 || -1 == num2){

            long num = arr[s++] - '0';
            while(num <= Integer.MAX_VALUE){
                list.add((int)num);
                long n1 = num1;
                long n2 = num2;
                if(-1 == n1)
                    n1 = num;
                else
                    n2 = num;
                if(!valid(list,n1,n2,s,arr)){
                    list.remove(list.size() - 1);
                }else
                    return true;
                num = (s == arr.length || 0 == num) ? Integer.MAX_VALUE + 1L : num * 10  + (arr[s++] - '0');
            }
            return false;
        }else{
            long num = num1 + num2;
            if(num > Integer.MAX_VALUE)
                return false;
            char[] sum = String.valueOf(num).toCharArray();
            for(int i = 0 ; i < sum.length ; i++,s++){
                if(s >= arr.length || arr[s] != sum[i])
                    return false;
            }
            list.add((int)num);
            num1 = num2;
            num2 = num;
            if(!valid(list,num1,num2,s,arr)){
                list.remove(list.size() - 1);
                return false;
            }else
                return true;
        }
    }

    public List<Integer> splitIntoFibonacci(String num) {
        List<Integer> ans = new ArrayList<>();
        valid(ans,-1,-1,0,num.toCharArray());
        return ans;
    }
    public static void main(String[] args){
        Random r = new Random();
        int num1 = r.nextInt(100);
        int num2 = r.nextInt(100);
        StringBuilder builder = new StringBuilder();
        builder.append(num1);
        builder.append(num2);
        for(int i = 0 ; i < 20 ; i ++){
            builder.append(num1 + num2);
            int num = num1 + num2;
            num1 = num2;
            num2 = num;
        }
        System.out.println(builder.toString());
    }
}
