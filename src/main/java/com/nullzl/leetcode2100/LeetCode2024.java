package com.nullzl.leetcode2100;

public class LeetCode2024 {

    private int search(int[] nums,int s ,int e,int target){
        while(s <= e){
            int mid = s + ((e - s) >> 1);
            if(nums[mid] >= target)
                e = mid - 1;
            else
                s = mid + 1;
        }
        return s;
    }

    public int maxConsecutiveAnswers(String answerKey, int k) {
        char[] arr = answerKey.toCharArray();
        int[] tidx = new int[arr.length + 1];
        int[] tcount = new int[arr.length + 1];
        int[] fidx = new int[arr.length + 1];
        int[] fcount = new int[arr.length + 1];
        int tcur = 1, fcur = 1;
        int max = 0;
        tidx[0] = fidx[0] = -1;
        tcount[0] = fcount[0] = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if('T' == arr[i]){
                tidx[tcur] = i;
                tcount[tcur] = tcount[tcur - 1] + 1;
                tcur++;
            }else{
                fidx[fcur] = i;
                fcount[fcur] = fcount[fcur - 1] + 1;
                fcur++;
            }
            int target = fcount[fcur - 1] - k;
            int idx = search(fcount,0,fcur - 1,target);
            max = Math.max(max,i - fidx[idx]);
            target = tcount[tcur - 1] - k;
            idx = search(tcount,0,tcur - 1,target);
            max = Math.max(max,i - tidx[idx]);
        }
        return max;
    }

    public int maxConsecutiveAnswers1(String answerKey, int k) {
        int max = 0;
        char[] arr = answerKey.toCharArray();
        int[][] dp = new int[k + 1][2];
        dp[0] = new int[]{-1,-1};
        for(int i = 1 ; i <= k ; i++){
            dp[i] = new int[]{0,0};
        }

        for(int i = 0 ; i < arr.length ; i++){
            for(int j = k ; j > 0 ; j--){
                char ch = arr[j - 1];
                if('T' == ch){
                    dp[j][0] += 1;
                    dp[j][1] = dp[j-1][1] + 1;
                }else{
                    dp[j][0] = dp[j-1][0] + 1;
                    dp[j][1] += 1;
                }
                max = Math.max(dp[j][0],max);
                max = Math.max(dp[j][1],max);
            }
        }
        return max;
    }
}
