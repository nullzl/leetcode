package com.nullzl.offer;

public class Offer2_66 {

    class Node{
        Node[] children = new Node['z' - 'a' + 1];
        int val = 0;
    }

    class MapSum {

        Node root;

        /** Initialize your data structure here. */
        public MapSum() {
            root = new Node();
        }

        public void insert(String key, int val) {
            Node node = root;
            char[] arr = key.toCharArray();
            for(int  i = 0 ; i < arr.length ; i++){
                int idx = arr[i] - 'a';
                Node temp = node.children[idx];
                if(null == temp){
                    temp = new Node();
                    node.children[idx] = temp;
                }
                node = temp;
            }
            node.val = val;
        }

        private int traverse(Node node){
            if(null == node)
                return 0;
            int sum = 0;
            sum += node.val;
            for(Node n : node.children){
                sum += traverse(n);
            }
            return sum;
        }

        public int sum(String prefix) {
            Node node = root;
            char[] arr = prefix.toCharArray();
            for(int i = 0 ;i < arr.length && null != node ; i++){
                node = node.children[arr[i] - 'a'];
            }
            return traverse(node);
        }
    }
}
