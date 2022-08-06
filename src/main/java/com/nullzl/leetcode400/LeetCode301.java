package com.nullzl.leetcode400;

import java.util.*;

public class LeetCode301 {

    int lmax = 0;
    int rmax = 0;
    int ldel = 0;
    int rdel = 0;
    StringBuilder str = new StringBuilder();
    List<String> ans = new LinkedList<>();
    HashSet<String> set = new HashSet<>();

    private void visit(char[] arr,int idx,int left,int right){
        if(idx == arr.length){
            String s = str.toString();
            if(left == right && !set.contains(s)) {
                ans.add(s);
                set.add(s);
            }
            return ;
        }
        if(left < right || ldel > lmax || rdel > rmax)
            return ;

        if(arr[idx] == '(' || arr[idx] == ')'){
            ldel = arr[idx] == '(' ? ldel + 1 : ldel;
            rdel = arr[idx] == ')' ? rdel + 1 : rdel;
            visit(arr,idx + 1,left,right);
            ldel = arr[idx] == '(' ? ldel - 1 : ldel;
            rdel = arr[idx] == ')' ? rdel - 1 : rdel;
        }

        str.append(arr[idx]);
        if(arr[idx] == '(')
            left++;
        else if(arr[idx] == ')')
            right++;
        visit(arr,idx + 1,left ,right);
        str.deleteCharAt(str.length() - 1);

    }

    public List<String> removeInvalidParentheses(String s) {
        char[] arr = s.toCharArray();
        int left = 0 , right = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] == '(')
                left++;
            else if(arr[i] == ')')
                right++;
            if(right > left) {
                rmax += (right - left);
                left = 0;
                right = 0;
            }
        }
        lmax += (left - right);
        left = 0 ;
        right = 0;
        visit(arr,0,0,0);
        return ans;
    }

    public static void main(String[] args){
        StringBuilder str = new StringBuilder();
        char[] arr = new char[25];
        Arrays.fill(arr,'*');
        Random r = new Random();
        for(int i = 0 ; i < 5 ; i++){
            int j = r.nextInt(25);
            arr[j] = 'h';
        }
        for(int i = 0 ; i < 25 ; i ++){
            if('*' == arr[i]){
                int j = r.nextInt(2);
                if(0 == j)
                    arr[i] = '(';
                else
                    arr[i] = ')';
            }
        }
        System.out.println(new String(arr));
    }
}
