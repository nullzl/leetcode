package com.nullzl.leetcode1300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode1233 {

    class Node{
        Node[] children = new Node[27];
        boolean isFold = false;
    }

    public List<String> removeSubfolders(String[] folder) {
        Node root = new Node();
        List<String> ans = new ArrayList<>();
        Arrays.sort(folder,(op1,op2)->{
            return Integer.compare(op1.length(),op2.length());
        });
        for(String s : folder){
            char[] arr ;
            if(s.charAt(s.length() - 1) == '/')
                arr = s.toCharArray();
            else{
                arr = new char[s.length() + 1];
                System.arraycopy(s.toCharArray(),0,arr,0,s.length());
                arr[s.length()] = '/';
            }
            Node node = root;
            int i = 0;
            for(; i < arr.length; i++){
                int idx = arr[i] == '/' ? 26 : (arr[i] - 'a');
                Node next = node.children[idx];
                if(null == next)
                    break;
                node = next;
            }
            if(node.isFold)
                continue;
            for(;i < arr.length ; i++){
                int idx = arr[i] == '/' ? 26 : (arr[i] - 'a');
                node.children[idx] = new Node();
                node = node.children[idx];
            }
            node.isFold = true;
            ans.add(s);
        }
        return ans;
    }
}
