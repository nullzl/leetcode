package com.race;

public class LeetCode1897 {

    public boolean makeEqual(String[] words) {

        int[] map = new int['z' - 'a' + 1];
        for(String s : words){
            for(int i = 0 ; i < s.length() ; i++){
                map[s.charAt(i) - 'a']++;
            }
        }
        for(int i = 0 ; i < map.length ; i++){
            if(0 != map[i] % words.length)
                return false;
        }
        return true;
    }


}
