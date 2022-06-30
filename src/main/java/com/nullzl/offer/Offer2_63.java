package com.nullzl.offer;

import java.util.List;

public class Offer2_63 {

    class Node{
        Node[] children = new Node[26];
        boolean isWord = false;
    }

    public String replaceWords(List<String> dictionary, String sentence) {

        Node root = new Node();
        for(String s : dictionary){
            char[] arr = s.toCharArray();
            Node node = root;
            for(char ch : arr){
                int idx = ch - 'a';
                if(null == node.children[idx]){
                    node.children[idx] = new Node();
                }
                node = node.children[idx];
            }
            node.isWord = true;
        }

        String[] strs = sentence.split("[ ]+");
        StringBuilder builder = new StringBuilder();
        for(String s : strs){
            char[] arr = s.toCharArray();
            Node node = root;
            for(char ch : arr){
                builder.append(ch);
                node = node == null ? null : node.children[ch - 'a'];
                if(null != node && node.isWord)
                    break;
            }
            builder.append(' ');
        }
        builder.delete(builder.length() - 1 , builder.length());
        return builder.toString();
    }
}
