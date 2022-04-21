package com.nullzl.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Interview1725 {

    class Node{
        Node[] children = new Node['z' - 'a' + 1];
        boolean isWord = false;
        int depth = 0;
    }
    private void addWord(Node root,String word){
        Node node = root;
        node.depth = Math.max(node.depth,word.length());
        for(int i = 0 ; i < word.length() ; i++){
            int index = word.charAt(i) - 'a';
            if(null == node.children[index]){
                node.children[index] = new Node();
            }
            node = node.children[index];
            node.depth = Math.max(node.depth,word.length());
        }
        node.isWord = true;
    }

    int max = 0;
    ArrayList<String> maxList = new ArrayList<>() ;

    public void dfs(Node[] nodes, List<String> list,List<String> rs){
        boolean find = true;
        for(int i = 0 ; i < nodes.length ; i++){
            if(null == nodes[i])
                return ;
            if(nodes[i].depth * nodes.length <= max)
                return ;
            if(!nodes[i].isWord)
                find = false;
        }
        if(find && rs.size() * nodes.length > max){
            maxList = new ArrayList<>(rs);
        }

        Node[] to = new Node[nodes.length];
        for(String str : list){
            rs.add(str);
            for(int i = 0 ; i < nodes.length ; i++){
                int index = str.charAt(i) - 'a';
                to[i] = nodes[i].children[index];
            }
            dfs(to,list,rs);
            rs.remove(rs.size() - 1);
        }
    }

    public String[] maxRectangle(String[] words) {
        ArrayList<String>[] lists = new ArrayList[101];
        Node root = new Node();
        for(String s : words){
            addWord(root,s);
            if(null == lists[s.length()])
                lists[s.length()] = new ArrayList<>();
            lists[s.length()].add(s);
        }

        for(int i = lists.length - 1 ; i >= 1 ; i--){
            ArrayList<String> list = lists[i];
            ArrayList<String> rs = new ArrayList<>();
            if(null == list || 0 == list.size())
                continue;
            if(i * i <= max)
                break;
            Node[] nodes = new Node[i];
            Arrays.fill(nodes,root);
            dfs(nodes,list,rs);
        }
        return maxList.toArray(new String[0]);
    }
}
