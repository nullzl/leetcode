package com.nullzl.interview;

public class Interview1618 {

    private boolean match(int i,int j,String a,String b,char[] pattern,char[] arr,int ca,int cb){
        if(null != a && null != b && a.equals(b))
            return false;
        if((null == a ? 0 : a.length()) * ca  + (null == b ? 0 : b.length()) * cb > arr.length)
            return false;

        if(i == pattern.length && j == arr.length)
            return true;
        if(i == pattern.length)
            return false;

        char ch = pattern[i];
        String m = ch == 'a' ? a : b;
        int s = 0;
        if(null == m){
            for(; s <= arr.length - j &&
                    !match(i + 1,j + s,
                            (ch == 'a' ? new String(arr,j,s) : a),
                            (ch == 'a' ? b : new String(arr,j,s))
                            ,pattern,arr,ca,cb)
                    ; s++);
            return !(s == arr.length - j + 1);
        }else{
            for(; s < m.length() ; s++){
                if(j + s >= arr.length || m.charAt(s) != arr[j + s])
                    return false;
            }
            return match(i + 1, j + s,a,b,pattern,arr,ca,cb);
        }


    }

    public boolean patternMatching(String pattern, String value) {
        int counta = 0,countb = 0;
        char[] pt = pattern.toCharArray();
        for(char ch :pt) {
            if (ch == 'a') {
                counta++;
            } else {
                countb++;
            }
        }
        return match(0,0,null,null,pt,value.toCharArray(),counta,countb);
    }

    public static void main(String[] args){
        System.out.println(new Interview1618().patternMatching("abba","dogcatcatdog"));
    }
}
