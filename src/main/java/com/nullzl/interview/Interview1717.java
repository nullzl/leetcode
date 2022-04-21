package com.nullzl.interview;

import java.util.ArrayList;

public class Interview1717 {

    class Node{
        Node[] children = new Node['z' - 'a' + 1];
        int index = -1;
    }

    public void addWord(Node root,String word,int j){
        if(null == word || 0 == word.length() || null == root)
            return ;

        Node node = root;
        for(int i = 0 ; i < word.length() ; i++){
            int index = word.charAt(i) - 'a';
            if(null == node.children[index])
                node.children[index] = new Node();
            node = node.children[index];
        }
        node.index = j;
    }

    public int[][] multiSearch(String big, String[] smalls) {
        Node root = new Node();
        for(int i = 0 ; i < smalls.length ; i++)
            addWord(root,smalls[i],i);
        ArrayList<Integer> list[] = new ArrayList[smalls.length];
        for(int i = 0 ; i < list.length ; i++)
            list[i] = new ArrayList<>();
        for(int i = 0 ; i < big.length() ; i++){
            Node node = root;
            for(int j = i ; null != node && j < big.length() ; j++){
                int index = big.charAt(j) - 'a';
                Node tmp = node.children[index];
                if(null != tmp && -1 != tmp.index)
                    list[tmp.index].add(i);
                node = tmp;
            }
        }
        int[][] rs = new int[smalls.length][];
        for(int i = 0 ; i < rs.length ; i++){
            rs[i] = new int[list[i].size()];
            for(int j = 0 ; j < list[i].size() ; j++){
                rs[i][j] = list[i].get(j);
            }
        }
        return rs;
    }
}
