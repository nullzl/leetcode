package com.nullzl.leetcode200;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class LeetCode139 {

    private boolean findWord(String s, int index, HashSet<String> set,int maxLen,HashMap<Integer,Boolean> cache){

        if(cache.keySet().contains(index))
            return cache.get(index);

        if(index == s.length()) {
            cache.put(index,true);
            return true;
        }

        for(int i = index + 1 ; i <= s.length() ; i++){
            if(i - index > maxLen) {
                cache.put(index,false);
                return false;
            }
            String str = s.substring(index,i);
            if(set.contains(str)){
                if(findWord(s,i,set,maxLen,cache)) {
                    cache.put(index,true);
                    return true;
                }
            }
        }
        cache.put(index,false);
        return false;
    }

    public boolean wordBreak1(String s, List<String> wordDict) {

        Iterator<String> iterator = wordDict.iterator();
        HashSet<String> set = new HashSet<>();
        int maxLen = 0;
        while(iterator.hasNext()){
            String str = iterator.next();
            if(str.length() > maxLen)
                maxLen = str.length();
            set.add(str);
        }

        HashMap<Integer,Boolean> cache = new HashMap<>();

        return findWord(s,0,set,maxLen,cache);

    }

    class Node{
        Node[] children = new Node[26];
        boolean isWord = false;
    }

    private void addWord(Node root,String word){
        Node node = root;
        char[] arr = word.toCharArray();
        int i = 0 ;
        while(i < arr.length && null != node.children[arr[i] - 'a'])
            node = node.children[arr[i++] - 'a'];
        for(; i < arr.length ; i++){
            node.children[arr[i] - 'a'] = new Node();
            node = node.children[arr[i] - 'a'];
        }
        node.isWord = true;
    }

    private boolean match(Node node,char[] arr,int idx,int[] match,Node root){
        if(null == node)
            return false;
        if(idx == arr.length)
            return node.isWord;
        if(0 != match[idx] && node == root)
            return match[idx] == 1 ;
        boolean rs = false;
        if(node.isWord){
            match[idx] = match(root,arr,idx,match,root) ? 1 : -1;
            rs = rs || (match[idx] == 1);
        }
        if(!rs)
            rs = rs || match(node.children[arr[idx] - 'a'],arr,idx + 1,match,root);
        return rs;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Node root = new Node();
        for(String word : wordDict){
            addWord(root,word);
        }
        int[] match = new int[s.length()];
        return match(root,s.toCharArray(),0,match,root);
    }
}
