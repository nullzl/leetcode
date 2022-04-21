package com.nullzl.leetcode800;

public class LeetCode767 {

    public String reorganizeString(String s) {

        int[] map = new int['z' - 'a' + 1];
        char[] arr = s.toCharArray();
        int max = 0;
        int j = -1;
        int i ;
        for(i = 0 ; i < arr.length; i++){
            map[arr[i] - 'a']++;
        }
        for(i = 0 ; i < map.length ; i++){
            if(map[i] > max){
                max = map[i];
                j = i;
            }
        }
        if(map[j] > (arr.length >> 1) + (arr.length & 1))
            return "";
        char[] ans= new char[arr.length];
        for(i = 0 ; i < arr.length && map[j] > 0 ; i+=2){
            ans[i] = (char)('a' + j);
            map[j]--;
        }
        j = 0;
        for( ; i < ans.length ; i+=2){
            while(j < map.length && map[j] <= 0) j++;
            ans[i] = (char)('a' + j);
            map[j]--;
        }
        for(i = 1 ; i < ans.length ; i+=2){
            while(j < map.length && map[j] <= 0) j++;
            ans[i] = (char)('a' + j);
            map[j]--;
        }
        return new String(ans);

    }
}
