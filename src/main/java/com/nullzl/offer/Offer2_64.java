package com.nullzl.offer;





public class Offer2_64 {

    class Node{
        Node[] children = new Node[26];
        boolean isWord = false;
    }
    class MagicDictionary {


        private Node root = new Node();

        /** Initialize your data structure here. */
        public MagicDictionary() {

        }

        public void buildDict(String[] dictionary) {
            for(String s : dictionary){
                char[] arr = s.toCharArray();
                Node node = root;
                for(char ch : arr){
                    int idx = ch - 'a';
                    if(null == node.children[idx])
                        node.children[idx] = new Node();
                    node = node.children[idx];
                }
                node.isWord = true;
            }
        }

        private boolean traverse(char[] arr,int idx,Node node,int count){
            if(null == node)
                return false;
            if(idx == arr.length && node.isWord && 1 == count)
                return true;
            if(count > 1 || idx == arr.length)
                return false;
            boolean rs = false;
            rs |= traverse(arr,idx + 1,node.children[arr[idx] - 'a'],count);
            for(int i = 0 ; i < node.children.length && !rs ; i++){
                if('a' + i == arr[idx])
                    continue;
                rs |= traverse(arr,idx + 1, node.children[i],count + 1);
            }
            return rs;
        }

        public boolean search(String searchWord) {
            char[] arr = searchWord.toCharArray();
            return traverse(arr,0,root,0);
        }
    }
}
