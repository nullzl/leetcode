package com.nullzl.offer;

import java.util.Iterator;
import java.util.List;

public class Offer2_111 {

    private void dfs(double[][] edges,boolean[] visited,int[] path,int size,int n){
        if(visited[n])
            return ;
        path[size++] = n;
        visited[n] = true;
        double temp = 1.0;
        for(int j = size - 2 ;  j >= 0 ; j--){
            temp *= edges[path[j]][path[j+1]] * temp;
            edges[path[j]][n] = temp;
            System.out.println((char)(path[j] + 'a') + "\t" + (char)(n + 'a') + "\t" + edges[path[j]][n]);
        }
        for(int j = 0; j < edges[n].length ; j++){
            if(0 == edges[n][j])
                continue;
            dfs(edges,visited,path,size,j);
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        int len = 'z' - 'a' + 1;
        int[] path = new int[len];
        double[][] edges = new double[len][len];
        int size = 0;
        boolean[] visited = new boolean[len];
        double[] rs = new double[queries.size()];

        int idx = 0;
        Iterator<List<String>> iterator = equations.iterator();
        while(iterator.hasNext()){
            double val = values[idx++];
            List<String> list = iterator.next();
            int ch1 = list.get(0).charAt(0) - 'a';
            int ch2 = list.get(1).charAt(0) - 'a';
            edges[ch1][ch2] = val;
            edges[ch1][ch1] = 1.0;
            edges[ch2][ch2] = 1.0;
        }

        iterator = queries.iterator();
        while(iterator.hasNext()){
            List<String> list = iterator.next();
            int ch1 = list.get(0).charAt(0) - 'a';
            int ch2 = list.get(1).charAt(0) - 'a';
            dfs(edges,visited,path,0,ch1);
            rs[size++] = 0 == edges[ch1][ch2] ? -1.0 : edges[ch1][ch2];
        }
        return rs;
    }
}
