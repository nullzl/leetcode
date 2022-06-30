package com.nullzl.offer;

public class Offer2_5 {

    public int maxProduct(String[] words) {

        int[] sets = new int[words.length];
        for(int i = 0 ;i < words.length ; i++){
            char[] arr = words[i].toCharArray();
            for(char ch : arr){
                sets[i] |= (1 << (ch - 'a'));
            }
        }
        int max = 0;
        for(int i = 0 ; i < words.length ; i++){
            for(int j = i + 1; j < words.length ; j++){
                if(0 == (sets[i] & sets[j])){
                    max = Math.max(max,words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }
}
