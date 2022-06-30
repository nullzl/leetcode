package com.nullzl.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Offer2_86 {

    List<String[]> ans = new LinkedList<>();

    private void dfs(String s,int idx,boolean[][] dp,List<String> list){
        if(idx == s.length()){
            ans.add(list.toArray(new String[0]));
            return;
        }
        for(int i = idx ; i < s.length() ; i++){
            if(!dp[idx][i])
                continue;
            list.add(s.substring(idx,i + 1));
            dfs(s,i + 1,dp,list);
            list.remove(list.size() - 1);
        }
    }

    private boolean isSame(String s, int i,int j){
        if((0 == (1 & i)) && (0 == (1 & j)))
            return true;
        if((0 == (1 & i)) || (0 == (1 & j)))
            return false;

        return s.charAt(i >> 1) == s.charAt(j >> 1);
    }

    private int[] getRadius(String s){
        int n = s.length();
        int[] radius = new int[(n << 1) + 1];
        radius[0] = 0;
        int c = 0;
        int l = 0;
        for(int i = 1 ; i < radius.length ; i++){
            int j = i >= l ? i + 1 : Math.min(l + 1, i + radius[(c << 1) - i] + 1);
            while(j < radius.length && ((i << 1) - j) >= 0 && isSame(s,j,((i << 1) - j))) j++;
            radius[i] = j - i - 1;
            if(c + radius[i] > l){
                c = i;
                l = c + radius[i];
            }
        }
        return radius;
    }

    public String[][] partition(String s) {
        int[] radius = getRadius(s);
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i = 0 ; i < radius.length ; i+=2){
            for(int k = 1 ; k <= radius[i]; k+=2){
                dp[(i - k) >> 1][(i + k) >> 1] = true;
            }
        }
        for(int i = 1 ; i < radius.length ; i += 2){
            for(int k = 0 ; k <= radius[i] ; k += 2){
                dp[(i - k) >> 1][(i + k) >> 1] = true;
            }
        }
        dfs(s,0,dp,new ArrayList<>());
        return ans.toArray(new String[0][]);
    }

    public static void main(String[] args){
        Random r = new Random();
        int len = r.nextInt(5) + 9;
        char[] arr = new char[len];
        for(int i = 0 ; i < len ; i++){
            arr[i] = (char)('a' + r.nextInt('d' - 'a' + 1));
        }
        System.out.println(new String(arr));
    }
}
