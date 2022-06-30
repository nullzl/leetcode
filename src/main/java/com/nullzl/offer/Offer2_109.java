package com.nullzl.offer;

public class Offer2_109 {

    private int visit(boolean[] map,boolean[] dead,int[] set,int[] step,int e,int n,int k){
        if(dead[n] || map[n])
            return e;
        map[n] = true;
        set[e] = n;
        step[e++] = k;
        return e;
    }

    private int[] toArr(int n){
        int[] num = new int[4];
        for(int i = 0 ; i < 4 ; i++){
            num[i] = n % 10;
            n /= 10;
        }
        return num;
    }
    private int str2Num(String s){
        int num = 0;
        for(int i = s.length() - 1 ; i >= 0 ; i--){
            num = num * 10 + (s.charAt(i) - '0');
        }
        return num;
    }

    private int next(int[] num,int i,int t){
        int temp = 0;
        for(int j = 3 ; j >= 0; j--){
            temp = temp * 10 + (i == j ? (num[j] + t + 10) % 10 : num[j]);
        }
        return temp;
    }

    public int openLock(String[] deadends, String target) {
        int[] set = new int[10000];
        int[] step = new int[10000];
        boolean[] map = new boolean[10000];
        boolean[] dead = new boolean[10000];
        for(String d : deadends){
            dead[str2Num(d)] = true;
        }
        int t = str2Num(target);
        int s = 0, e = 0 ;
        e = visit(map,dead,set,step,e,0,0);
        if(0 == t)
            return 0;
        int[] delta = new int[]{1,-1};
        while(s < e){
            int num = set[s];
            int k = step[s++];
            int[] arr = toArr(num);
            for(int i = 0 ; i < 4; i++) {
                for (int j = 0; j < delta.length; j++) {
                    int next = next(arr, i, delta[j]);
                    if (next == t)
                        return k + 1;
                    e = visit(map, dead, set, step, e, next, k + 1);
                }
            }
        }
        return -1;
    }
}
