package com.nullzl.LeetCode1300;

public class LeetCode1240 {

    int min = Integer.MAX_VALUE;

    private  void getRect(boolean[][] area,int i , int j,int count){

        if(count >= min)
            return;

        while(i < area.length){
            while(j < area[0].length && area[i][j])
                j++;
            if(j == area[0].length){
                i++;
                j = 0;
            }else
                break;
        }

        if(i == area.length) {
            min = Math.min(min, count);
            return ;
        }

        int k = j + 1;
        while(k < area[0].length && !area[i][k])
            k++;
        int len = Math.min(k - j , area.length - i);
        count++;
        for(int x = 1; x <= len ; x++){
            //i to i + x    j to j + x
            for(int m = i ; m < i + x - 1 ; m++)
                area[m][j+x-1] = true;

            for(int m = j ; m < j + x ; m++)
                area[i + x - 1][m] = true;

            getRect(area,i,j,count);
        }
        for(int m = i ; m < i + len ; m++){
            for(int n = j ; n < j + len ; n++)
                area[m][n] = false;
        }
    }

    public int tilingRectangle(int n, int m) {
        boolean[][] area = new boolean[n][m];
        getRect(area,0,0,0);
        return min;
    }

    public static void main(String[] args){
        LeetCode1240 l = new LeetCode1240();
        System.out.println(l.tilingRectangle(12,13));
    }
}
