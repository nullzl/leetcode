package com.race;

public class LeetCode1900 {
    int max = 0;
    int min = Integer.MAX_VALUE;

    private void swap(int[] nums,int m ,int n){
        nums[m] = nums[m] ^ nums[n];
        nums[n] = nums[m] ^ nums[n];
        nums[m] = nums[m] ^ nums[n];
    }

    public void race(int[] nums, int k,int first,int sec, int m,int n){
        if(m >= n){
            race(nums,k+1,first,sec,0,n);
            return ;
        }
        if((nums[m] == first || nums[m] == sec) && (nums[n] == first || nums[n] == sec)){
            max = Math.max(k,max);
            min = Math.min(k,min);
        }else if(nums[m] == first || nums[m] == sec){
            race(nums,k,first,sec,m + 1,n-1);
        }else if(nums[n] == first || nums[n] == sec){
            swap(nums,m,n);
            race(nums,k,first,sec,m+1,n-1);
            swap(nums,m,n);
        }else{
            race(nums,k,first,sec,m + 1,n-1);
            swap(nums,m,n);
            race(nums,k,first,sec,m+1,n-1);
            swap(nums,m,n);
        }
    }



    public int[] race(int[][][][] dp,int i,int j,int k){
        if(i > j){
            return race(dp,j,i,k);
        }
        if(0 != dp[i][j][k][0])
            return dp[i][j][k];
        int mid = (k >>> 1);

        if(k == i + j){
            dp[i][j][k][0] = 1;
            dp[i][j][k][1] = 1;
        }else{
            int a,b,c,d;
            if(j <= mid){
                a = 0;
                b = i;
                c = 1;
                d = j - i;
            }else if(i <= mid){
                a = 0;
                b = i - (k - j < i ? 1 : 0);
                c = k - i < j ? mid - i + 1 : mid - k + j + 1;
                d = k - i < j ? mid + j - k : mid - i + 1;
            }else{
                a = (0 == (k & 1) ? 1 : 0) + i - mid - 1;
                b = mid - 1;
                c = 1;
                d = j - i;
            }

            dp[i][j][k][0] = Integer.MAX_VALUE;
            for(int x = a ; x <= b ; x++){
                for(int y = x + c ; y <= mid && y <= x + d ; y++){
                    int[] tmp = race(dp,x,y,mid);
                    dp[i][j][k][0] = Math.min(dp[i][j][k][0],tmp[0] + 1);
                    dp[i][j][k][1] = Math.max(dp[i][j][k][1],tmp[1] + 1);
                }
            }
            System.out.println(i + "\t" + j + "\t" + k + "\t" + dp[i][j][k][0]);
        }
        return dp[i][j][k];
    }


    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        int[][][][] dp = new int[n][n][n][2];
        return race(dp,firstPlayer-1,secondPlayer-1,n-1);
    }

    public static void main(String[] args){

        int[] nums = new LeetCode1900().earliestAndLatest(12,8,12);
        System.out.println(nums[0]);
        System.out.println(nums[1]);
    }
}
