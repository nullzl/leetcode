package com.nullzl.offer;

import java.util.Random;

public class Offer2_117 {

    boolean isSimilar(String s , String t){
        if(s.length() != t.length())
            return false;
        int count = 0;
        for(int i = 0 ; i < s.length() && count < 3 ; i++){
            if(s.charAt(i) != t.charAt(i))
                count++;
        }
        return 0 == count || 2 == count;
    }

    void visit(int idx,boolean[][] edges,boolean[] visited){
        if(visited[idx])
            return ;
        visited[idx] = true;
        for(int i = 0 ; i < edges.length ; i++){
            if(edges[idx][i])
                visit(i,edges,visited);
        }
    }

    public int numSimilarGroups(String[] strs) {

        boolean[][] edges = new boolean[strs.length][strs.length];

        for(int i = 0 ; i < strs.length ; i++){
            for(int j = i + 1 ; j < strs.length; j++){
                if(isSimilar(strs[i],strs[j])){
                    edges[i][j] = true;
                    edges[j][i] = true;
                }
            }
        }

        boolean[] visited = new boolean[strs.length];
        int count = 0;
        while(true){

            int i = 0 ;
            for(; i < strs.length && visited[i] ; i++);
            if(i < strs.length){
                count++;
                visit(i,edges,visited);
            }else{
                break;
            }

        }
        return count;
    }

    public static void main(String[] args){
        StringBuilder s = new StringBuilder();
        Random r = new Random();
        int len = r.nextInt(50) + 10;
        for(int i = 0 ;i < len ; i++){
            char ch = (char)('a' + r.nextInt('z' - 'a' + 1));
            s.append(ch);
        }

        int len2 = r.nextInt(200) + 100;
        System.out.print("[\"" + s.toString() + "\"");
        for(int i = 0 ;i < len2 ; i++){
            int k = s.length();
            StringBuilder x = new StringBuilder(s);
            for(int j = k - 1 ; j > 0 ; j--){
                int t = r.nextInt(k);
                char temp = x.charAt(j);
                x.setCharAt(j,x.charAt(t));
                x.setCharAt(t,temp);
            }
            System.out.print(",\"" + x.toString() + "\"");
        }
        System.out.println("]");
    }
}
