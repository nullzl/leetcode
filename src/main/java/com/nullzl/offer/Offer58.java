package com.nullzl.offer;

public class Offer58 {



    public String reverseWords(String s) {
        if(null == s || 0 == s.length())
            return "";
        char[] arr = s.toCharArray();
        char[] cp = new char[arr.length];
        int i = 0 ,j = 0;
        while(i < arr.length && arr[i] == ' ') i++;
        while(i < arr.length) {
            if(' ' == arr[i] && ' ' == arr[i - 1])
                i++;
            else
                cp[j++] = arr[i++];
        }
        if(j > 0 && ' ' == cp[j - 1]) j--;
        int low = -1;
        for(i = 0 ; i < j ; i++){
            if(' ' != cp[i] && -1 == low){
                low = i;
            }else if(' ' == cp[i] && -1 != low){
                reverse(cp,low,i - 1);
                low = -1;
            }
        }
        if(-1 != low)
            reverse(cp,low,j - 1);
        reverse(cp,0,j - 1);
        return new String(cp,0,j);
    }

    private void reverse(char[] arr,int s ,int e){
        while(s < e){
            char t = arr[s];
            arr[s] = arr[e];
            arr[e] = t;
            s++;e--;
        }
    }

    public String reverseLeftWords(String s, int n) {
        if(0 == n || null == s || 0 == s.length() || n == s.length())
            return s;

        char[] arr = s.toCharArray();
        reverse(arr,0,n - 1);
        reverse(arr,n,arr.length - 1);
        reverse(arr,0,arr.length - 1);

        return new String(arr);
    }
}
