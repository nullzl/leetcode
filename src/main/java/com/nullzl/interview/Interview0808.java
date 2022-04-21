package com.nullzl.interview;

import java.util.ArrayList;
import java.util.List;

public class Interview0808 {

    private void swapChar(char[] arr,int i , int j){
        if(i != j){
            arr[i] = (char)((int)arr[i] ^ (int)arr[j]);
            arr[j] = (char)((int)arr[i] ^ (int)arr[j]);
            arr[i] = (char)((int)arr[i] ^ (int)arr[j]);
        }
    }

    private void dfs(List<String> lists,char[] str,char[] arr,int[] map,int size,int i,int j){
        if(i == arr.length){
            lists.add(new String(str));
            return;
        }

        for(int k = j ; k < size ; k++){
            str[i] = arr[k];
            map[str[i]]--;
            if(0 ==map[str[i]]){
                swapChar(arr,j,k);
            }
            dfs(lists,str,arr,map,size,i + 1,0 == map[str[i]] ? j + 1 : j);
            if(0 ==map[str[i]]){
                swapChar(arr,k,j);
            }
            map[str[i]]++;
        }
    }

    public String[] permutation(String S) {
        if(null == S || 0 == S.length())
            return new String[0];
        int[] map = new int[256];
        char[] arr  = S.toCharArray();
        for(char ch : arr)
            map[ch]++;

        int size = 0;
        for(int i = 0 ; i < 256 ; i++){
            if(0 != map[i]){
                arr[size++] = (char)i;
            }
        }

        List<String> lists = new ArrayList<>();
        char[] str = new char[arr.length];
        dfs(lists,str,arr,map,size,0,0);
        return lists.toArray(new String[0]);
    }
}
