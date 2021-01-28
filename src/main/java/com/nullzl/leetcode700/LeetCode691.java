package com.nullzl.leetcode700;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class LeetCode691 {

    private int contains(int[][] words, int i , int j){
        int k = 0 ;
        while(k < words[i].length && words[i][k] == words[j][k])k++;
        if(k == words[i].length)
            return i;
        int x = k;
        while(x < words[i].length && words[i][x] >= words[j][x])x++;
        if(x == words[i].length)
            return i;
        if(x != k)
            return -1;
        while(x < words[i].length && words[i][x] <= words[j][x])x++;
        if(x == words[i].length)
            return j;
        else
            return -1;

    }



    private int next(int sum,int[][] num,int[][] words,int i){

        int tmp = sum;
        for(int k = 0 ; k < words[i].length ; k++){
            if(0 == words[i][k])
                continue;

            //words[i][k]表示的字符，最多还可加几个，前导位置置1
            int x = (num[k][num[k].length - 1] & tmp) ^ num[k][num[k].length - 1];
            int count = 0;
            while(x != 0 && count < words[i][k]){
                sum |= (((x - 1) ^ x) & x);
                x = x & (x - 1);
                count++;
            }
        }
        return sum == tmp ? -1 : sum;
    }

    public int minStickers(String[] stickers, String target) {

        int[][] amount = new int['z' - 'a' + 1][2];
        for(int i = 0 ; i < target.length() ; i++)
            amount[target.charAt(i) - 'a'][1]++;
        int size = 0;
        for(int i = 0 ; i < amount.length ; i++){
            amount[i][0] = amount[i][1] == 0 ? -1 : size++;
        }

        boolean[] exists = new boolean[size];
        int[][] words = new int[stickers.length][size];
        for(int i = 0 ; i < stickers.length ; i++){
            for(int j= 0 ; j < stickers[i].length() ; j++){
                int idx = stickers[i].charAt(j) - 'a';
                if(-1 != amount[idx][0] && words[i][amount[idx][0]] < amount[idx][1]) {
                    words[i][amount[idx][0]]++;
                    exists[amount[idx][0]] = true;
                }
            }
        }

        for(int i = 0 ; i < size; i++){
            if(!exists[i])
                return -1;
        }

        ArrayList<Integer> list = new ArrayList<>();
        int i,j;
        for(i = 0 ; i < words.length ; i++){
            for(j = 0 ; j < list.size() ; j++){
                int idx = contains(words,i,list.get(j));
                if(idx != -1){
                    list.set(j,idx);
                    break;
                }
            }
            if(j == list.size())
                list.add(i);
        }


        int[] tgt = new int[size];
        int[] code = new int[size];
        for(i = 0 ; i < amount.length ; i++){
            if(-1 != amount[i][0])
                tgt[amount[i][0]] = amount[i][1];
        }
        code[tgt.length - 1] = 0;
        for(i = tgt.length - 2 ; i >= 0 ; i--)
            code[i] = code[i+1] + tgt[i+1] ;

        int[][] num = new int[size][];
        for(i = 0 ; i < size ; i++){
            num[i] = new int[tgt[i] + 1];
            for(j = 1 ; j < num[i].length ; j++){
                num[i][j] = (1 << (j - 1 + code[i])) | num[i][j - 1];
            }
        }

        int[] dp = new int[1 << target.length()];
        int[] next = new int[1 << target.length()];
        j = 1;
        int nsize = 1;
        for(i = size - 1 ; i >= 0 ; i--){
            for(int k = 1 ; k < num[i].length ; k++){
                for(int x = 0 ; x < j ; x++){
                    next[nsize++] = num[i][k] | next[x];
                }
            }
            j = nsize;
        }
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(i = 0 ; i < list.size(); i++){
            int[] tmp = new int[1 << target.length()];
            Arrays.fill(tmp,Integer.MAX_VALUE);
            for(j = 0 ;j < (i == 0 ? 1 : nsize); j++){
                int idx = next[j];
                if(Integer.MAX_VALUE == dp[idx])
                    continue;
                tmp[idx] = Math.min(tmp[idx],dp[idx]);
                int count = 1;
                int sum = idx;
                while(-1 != (sum = next(sum,num,words,list.get(i)))){
                    tmp[sum] = Math.min(tmp[sum],count + dp[idx]);
                    count++;
                }
            }
            dp = tmp;
        }
        return dp[(1 << target.length()) - 1];
    }


    public static void main(String[] args){
//        int rs = new LeetCode691().minStickers(
//                new String[]{"with", "example", "science"},
//                "thehat"
//        );
//        System.out.println(rs);
        Random r = new Random();
        StringBuffer target = new StringBuffer();
        for(int i = 0 ; i < 15 ; i++)
            target.append((char)(r.nextInt('z'-'a' + 1) + 'a'));
        StringBuffer[] words = new StringBuffer[50];
        System.out.print("[");
        for(int i = 0 ; i < 10 ; i++){
            words[i] = new StringBuffer();
            for(int j = 0 ; j < 7 ; j++){
                words[i].append((char)(r.nextInt('z'-'a' + 1) + 'a'));
            }
            System.out.print( "\"" + words[i] + "\"" + ",");
        }
        System.out.println("]");
        System.out.println("\"" + target + "\"");

    }
}
