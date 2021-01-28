package main.java.com.nullzl.leetcode800;

public class LeetCode739 {

    public int[] dailyTemperatures(int[] T) {

        int[] flag = new int[71];
        int[] rs = new int[T.length];
        int pos;
        for(int i = 0 ; i < 71 ; i++)
            flag[i] = -1;
        for(int i= T.length - 1; i >= 0 ; i--){
            pos = T[i] - 30;
            if(-1 == flag[pos])
                rs[i] = 0;
            else if(T[flag[pos]] - 30 == pos){
                if(pos + 1 > 70)
                    rs[i]  = 0;
                else if(-1 == flag[pos + 1]){
                    rs[i] = 0;
                }else{
                    rs[i] = flag[pos + 1] - i;
                }
            }else{
                rs[i] = flag[pos] - i;
            }
            flag[pos] = i;
            pos--;
            while(pos >= 0){
                flag[pos] = i;
                pos--;
            }
        }
        return rs;
    }
}
