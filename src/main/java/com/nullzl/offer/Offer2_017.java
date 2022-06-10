package com.nullzl.offer;

import java.util.Random;

public class Offer2_017 {

    public String minWindow(String s, String t) {

        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        if(arr2.length > arr1.length)
            return "";
        char minChr = 'a' > 'A' ? 'A' : 'a';
        char maxChr = 'z' > 'Z' ? 'z' : 'Z';
        int[] map = new int[maxChr - minChr + 1];
        int count = 0;
        int m = 0 ;
        int minLen = Integer.MAX_VALUE;
        int minM = -1, minN = -1;
        for(int i = 0 ; i < arr2.length ; i++){
            map[arr2[i] - minChr]++;
        }
        for(int i = 0 ; i < arr1.length ; i++){
            if(--map[arr1[i] - minChr] >= 0)
                count++;

            while(arr2.length == count && map[arr1[m] - minChr] + 1 <= 0)
                map[arr1[m++] - minChr]++;

            if(arr2.length == count && i - m + 1 < minLen){
                minM = m;
                minN = i;
                minLen = i - m + 1;
            }

        }
        if(-1 != minM){
            return s.substring(minM,minN + 1);
        }
        return "";
    }

    public static void main(String[] args){
        int max = 'z' - 'a' + 1;
        Random r = new Random();
        int len1 = r.nextInt(1000) + 5000;
        int len2 = r.nextInt(1000) + 500;
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        for(int i= 0 ;i < len1 ; i++){
            char ch = (char)(r.nextInt(max) + 'a');
            s1.append(ch);
        }
        for(int i= 0 ;i < len2 ; i++){
            char ch = (char)(r.nextInt(max) + 'a');
            s2.append(ch);
        }
        System.out.print(
                "\"" + s1.toString() + "\"\r\n" +
                        "\"" + s2.toString() + "\"\r\n"
        );

    }
}
