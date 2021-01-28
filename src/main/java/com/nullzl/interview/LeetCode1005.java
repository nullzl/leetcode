package com.nullzl.interview;

public class LeetCode1005 {

    private int binarySearch(String[] words,String key, int s ,int e){
        if(s > e)
            return -1;
        int mid = s + ((e - s) >> 1);

        if(key.equals(words[mid]))
            return mid;

        if("".equals(words[mid])){
            int pos = binarySearch(words,key,s,mid - 1);
            return pos == -1 ? binarySearch(words,key,mid + 1 ,e) : pos;
        }

        if(words[mid].compareTo(key) > 0){
            return binarySearch(words,key,s,mid - 1);
        }

        return binarySearch(words,key,mid + 1,e);
    }

    public int findString(String[] words, String s) {

        if(null == words || 0 == words.length || null == s || "".equals(s))
            return -1;

        return binarySearch(words,s,0,words.length - 1);
    }

    public static void main(String[] args){
        String[] words = new String[]{
                "at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""
        };
        System.out.println(new LeetCode1005().findString(words,"ba"));
    }
}
