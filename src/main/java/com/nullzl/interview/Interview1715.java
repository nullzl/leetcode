package com.nullzl.interview;

public class Interview1715 {

    class Node{
        Node[] children = new Node['z' - 'a' + 1];
        int count = 0;
        int depth = 0;
    }

    private void addWord(Node root,char[] arr){
        if(null == arr || 0 == arr.length)
            return ;
        Node node = root;
        for(int i = 0; i < arr.length ; i++){
            int index = arr[i] - 'a';
            if(null != node.children[index])
                node = node.children[index];
            else{
                Node temp = new Node();
                temp.depth = node.depth + 1;
                node.children[index] = temp;
                node = temp;
            }
            node.count++;
        }
    }

    public boolean findWord(Node root,Node node,char[] arr,int index){
        if(null == node)
            return false;
        if(index == arr.length){
            return node.count > 0 && node.depth != arr.length;
        }
        boolean exist = false;
        if(node.count > 0){
            //此题字符串可重复使用
            //node.count--;
            exist = findWord(root,root,arr,index);
            //node.count++;
        }
        return exist || findWord(root,node.children[arr[index] - 'a'],arr,index + 1);
    }


    public String longestWord(String[] words) {
        Node root = new Node();
        char[][] arrs = new char[words.length][];
        for(int i = 0 ;i < words.length ; i++){
            arrs[i] = words[i].toCharArray();
            addWord(root,arrs[i]);
        }

        String rs = "";
        for(int i = 0 ;i < arrs.length ; i++){
            if(arrs[i].length < rs.length()
            || (arrs[i].length == rs.length() && words[i].compareTo(rs) >= 0))
                continue;

            if(findWord(root,root,arrs[i],0)){
                rs = words[i];
            }
        }
        return rs;
    }
}
