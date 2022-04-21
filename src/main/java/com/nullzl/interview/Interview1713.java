package com.nullzl.interview;

import java.util.Arrays;

public class Interview1713 {

    class Node{
        Node[] children = new Node['z' - 'a' + 1];
        boolean isWord = false;
        int depth = 0;
    }

    public void addWrod(Node root,String word){
        Node node = root;
        char[] arr = word.toCharArray();
        for(char ch : arr){
            int index = ch - 'a';
            if(null == node.children[index]){
                node.children[index] = new Node();
                node.children[index].depth = node.depth + 1;
            }
            node = node.children[index];
        }
        node.isWord = true;
    }

    int minDeleted;

    private void dfs(int[][] dp,char[] arr,int i,Node root,Node node,int deleted){
        if(null == node || deleted >= minDeleted)
            return ;
        if(i == arr.length && node == root){
            minDeleted = deleted;
            return ;
        }
        if(deleted >= dp[i][node.depth])
            return ;
        else
            dp[i][node.depth] = deleted;
        if(i < arr.length) {
            int index = arr[i] - 'a';
            dfs(dp,arr, i + 1, root, node.children[index], deleted);
        }
        if(node.isWord)
            dfs(dp,arr,i,root,root,deleted);
        if(node == root)
            dfs(dp,arr,i + 1,root,root,deleted + 1);

    }

    public int respace(String[] dictionary, String sentence) {
        if(null == sentence || 0 == sentence.length())
            return 0;
        if(null == dictionary || 0 == dictionary.length)
            return sentence.length();
        Node root = new Node();
        int maxLen = 0;
        for(String s : dictionary){
            addWrod(root,s);
            maxLen = Math.max(maxLen,s.length());
        }
        int[][] dp = new int[sentence.length() + 1][maxLen + 1];
        for(int i = 0 ; i <= sentence.length() ; i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        minDeleted = sentence.length();
        char[] arr = sentence.toCharArray();
        dfs(dp,arr,0,root,root,0);
        return minDeleted;
    }
}
