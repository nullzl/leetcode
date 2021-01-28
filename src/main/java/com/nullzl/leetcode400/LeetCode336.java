package com.nullzl.leetcode400;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LeetCode336 {

    private void swap(int[] seq,int i , int j){
        if(i != j){
            seq[i] = seq[i] ^ seq[j];
            seq[j] = seq[i] ^ seq[j];
            seq[i] = seq[i] ^ seq[j];
        }
    }

    private int partition(String[] words,int[] seq,int s,int e){
        int k = s - 1;
        for(int i = s; i < e ; i++){
            if(words[seq[i]].length() >= words[seq[e]].length()){
                swap(seq,++k,i);
            }
        }
        swap(seq,++k,e);
        return k;
    }
    private void quickSort(String[] words,int[] seq,int s,int e){
        if(s >= e)
            return ;
        int k = partition(words,seq,s,e);
        quickSort(words,seq,s,k-1);
        quickSort(words,seq,k+1,e);
    }

    private boolean isPalindrome(String words,int s,int e){
        while(s < e){
            if(words.charAt(s++) != words.charAt(e--))
                return false;
        }
        return true;
    }

    public List<List<Integer>> palindromePairs(String[] words) {

        List<List<Integer>> rs = new LinkedList<>();
        if(null == words)
            return rs;

        int[] seq = new int[words.length];
        for(int i = 0 ; i < words.length ; i++)
            seq[i] = i;
        quickSort(words,seq,0,seq.length - 1);
        String[] reverse = new String[words.length];
        for(int i = 0 ;i < words.length ; i++)
            reverse[i] = new StringBuffer(words[i]).reverse().toString();
        for(int i = 0 ; i < seq.length ; i++){
            for(int j = i + 1 ; j < seq.length ; j++){
                if(reverse[seq[i]].startsWith(words[seq[j]]) &&
                isPalindrome(words[seq[i]],0,words[seq[i]].length() - words[seq[j]].length() - 1)){
                    List<Integer> list = new ArrayList<>(2);
                    list.add(seq[j]);
                    list.add(seq[i]);
                    rs.add(list);
                }
                if(words[seq[i]].startsWith(reverse[seq[j]]) &&
                isPalindrome(words[seq[i]],words[seq[j]].length(),words[seq[i]].length() - 1)){
                    List<Integer> list = new ArrayList<>(2);
                    list.add(seq[i]);
                    list.add(seq[j]);
                    rs.add(list);
                }
            }
        }
        return rs;
    }

    public static void main(String[] args){
        new LeetCode336().palindromePairs(new String[] {"bat","tab","cat"}).stream()
                .forEach(list -> {
                    list.stream().forEach(num -> System.out.print(num + "\t"));
                    System.out.println();
                });
    }
}
