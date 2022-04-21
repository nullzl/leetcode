package com.nullzl.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Interview1722 {

    private void addEdage(HashMap<String,List<String>> edges,String from,String to){
        List<String> list;
        list = edges.get(from);
        if(null == list) {
            list = new ArrayList<>();
            edges.put(from, list);
        }
        list.add(to);
    }

    private  boolean traverse(List<String> seq,String word,String endWord,
                              HashSet<String> visited,HashMap<String,List<String>> edges){
        if(visited.contains(word))
            return false;
        visited.add(word);
        seq.add(word);
        if(word.equals(endWord)){
            return true;
        }
        char[] arr = word.toCharArray();
        for(int i = 0 ; i < arr.length ; i++){
            char ch = arr[i];
            arr[i] = '*';
            List<String> next = edges.get(new String(arr));
            for(String to : next){
                if(traverse(seq,to,endWord,visited,edges))
                    return true;
            }
            arr[i] = ch;
        }
        seq.remove(seq.size() - 1);
        return false;
    }

    public List<String> findLadders(String beginWord, String endWord, List<String> wordList){
        HashSet<String> dic = new HashSet<>();
        for(String s : wordList){
            dic.add(s);
        }
        if(!dic.contains(beginWord))
            dic.add(beginWord);
        if(!dic.contains(endWord))
            return new ArrayList<>();

        HashMap<String,List<String>> edges = new HashMap<>();
        for(String s : dic){
            char[] arr = s.toCharArray();
            for(int i = 0 ; i < arr.length ; i++){
                char ch = arr[i];
                arr[i] = '*';
                addEdage(edges,new String(arr),s);
                arr[i] = ch;
            }
        }

        HashSet<String> visited = new HashSet<>();
        List<String> seq = new ArrayList<>();
        traverse(seq,beginWord,endWord,visited,edges);
        return seq;
    }

    private boolean edge(String a, String b){
        if(a.length() != b.length())
            return false;
        int count = 0;
        for(int i = 0 ; count < 2 && i < a.length() ; i++){
            if(a.charAt(i) != b.charAt(i))
                count++;
        }
        return 1 == count;
    }

    public boolean dfs(String word,List<String> path,boolean[] visited,
                       HashMap<String,Integer> map,boolean[][] edges,
                       String[] strs,String endWord){
        int index = map.get(word);
        if(visited[index])
            return false;
        path.add(word);
        visited[index] = true;
        if(word.equals(endWord))
            return true;
        for(int i = 0 ; i < visited.length ; i++){
            if(edges[index][i] && !visited[i] && dfs(strs[i],path,visited,map,edges,strs,endWord))
                return true;
        }
        path.remove(path.size() - 1);
        return false;
    }

    public List<String> findLadders1(String beginWord, String endWord, List<String> wordList) {
        assert (null != beginWord && null != endWord && null != wordList);
        List<String> list = new ArrayList<>(wordList.size());
        if(0 == wordList.size())
            return list;

        HashMap<String,Integer> map = new HashMap<>();

        for(int i = 0 ; i < wordList.size() ; i++)
            map.put(wordList.get(i),i);
        String[] strs ;
        if(-1 == map.getOrDefault(beginWord,-1)){
            strs = new String[wordList.size() + 1];
            System.arraycopy(wordList.toArray(new String[0]),0,strs,0,strs.length - 1);
            strs[strs.length - 1] = beginWord;
            map.put(beginWord,strs.length - 1);
        }else
            strs = wordList.toArray(new String[0]);


        if(-1 == map.getOrDefault(endWord,-1))
            return list;

        boolean[][] edges = new boolean[strs.length][strs.length];
        for(int i = 0 ; i < strs.length ; i++){
            for(int j = i + 1 ; j < strs.length ; j++){
                edges[i][j] = edge(strs[i],strs[j]);
                edges[j][i] = edges[i][j];
            }
        }
        boolean[] visited = new boolean[strs.length];
        dfs(beginWord,list,visited,map,edges,strs,endWord);
        return list;
    }

    public static void main(String[] args){
        Semaphore sem = new Semaphore(-1);
        new Thread(){
            @Override
            public void run(){
                try {
                    sem.acquire();
                    System.out.println("ok");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }.start();
        new Thread(){
            @Override
            public void run(){
                    System.out.println("1");
                    sem.release();


            }
        }.start();
        new Thread(){
            @Override
            public void run(){
                System.out.println("2");
                sem.release();

            }
        }.start();
    }
}
