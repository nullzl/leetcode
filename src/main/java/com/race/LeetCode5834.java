package com.race;

public class LeetCode5834 {

    public int minTimeToType(String word) {

        char ch = 'a';
        char[] arr = word.toCharArray();
        int count = 0;
        for(char s : arr){
            int step = 0;
            if(s == ch){
                step = 1;
            }else if(s < ch){
                step = Math.min(ch - s,'z' - ch + 1 + s - 'a') + 1;
            }else{
                step = Math.min(s - ch , ch - 'a' + 1 + 'z' - s) + 1;
            }
            ch = s;
            count += step;
        }
        return count;
    }

    public static void main(String[] args){
        System.out.println(new LeetCode5834().minTimeToType("zjpc"));
    }
}
