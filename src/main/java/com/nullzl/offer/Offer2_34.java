package com.nullzl.offer;

public class Offer2_34 {

    public boolean isAlienSorted(String[] words, String order) {

        int[] map = new int[26];
        char[] ord = order.toCharArray();
        for(int i = 0 ;i < ord.length ; i++){
            map[ord[i] - 'a'] = i;
        }
        char[] arr1 = words[0].toCharArray();
        char[] arr2 ;
        int i,j;
        for(i = 1 ; i < words.length ; i++){
            arr2 = words[i].toCharArray();
            for(j = 0 ; j < arr1.length && j < arr2.length ; j++){
                if(map[arr1[j] - 'a'] > map[arr2[j] - 'a'])
                    return false;
                else if(map[arr1[j] - 'a'] < map[arr2[j] - 'a'])
                    break;
            }
            if(j == arr2.length && arr1.length > arr2.length)
                return false;
            arr1 = arr2;
        }
        return true;
    }
}
