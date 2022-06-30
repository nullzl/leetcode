package com.nullzl.offer;

public class Offer2_65 {

    class Node{

        Node[] children = new Node['z' - 'a' + 1];
        boolean isLeaf = false;
    }

    public int minimumLengthEncoding(String[] words) {
        Node root = new Node();
        root.isLeaf = true;
        int count = 1;
        for(String w : words){
            char[] arr = w.toCharArray();
            Node node = root;
            int idx = arr.length - 1;
            while(idx >= 0 && null != node.children[arr[idx] - 'a']){
                node = node.children[arr[idx--] - 'a'];
            }
            if(idx >= 0){
                if(!node.isLeaf){
                    count += (arr.length + 1) ;
                }else{
                    count += (idx + 1);
                    node.isLeaf = false;
                }
                while(idx >= 0){
                    int j = arr[idx--] - 'a';
                    node.children[j] = new Node();
                    node = node.children[j];
                }
                node.isLeaf = true;
            }
        }

        return count ;
    }
}
