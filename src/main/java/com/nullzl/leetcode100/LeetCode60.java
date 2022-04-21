package com.nullzl.leetcode100;

public class LeetCode60 {

    private char use(boolean[] used,int idx){
        int k = -1;
        int t = 0;
        for(int i = 1 ; i < used.length && k < idx ; i++){
            if(!used[i]){
                k++;
                t = i;
            }
        }
        used[t] = true;
        return (char)('0'+ t);
    }

    public String getPermutation(int n, int k) {
        boolean[] used = new boolean[n + 1];
        int[] nums = new int[n];
        nums[0] = 1;
        for(int i = 1 ; i < n; i++){
            nums[i] = nums[i-1] * i;
        }
        k -= 1;
        StringBuilder builder = new StringBuilder();
        for(int i = n ; i >= 1 ; i--){
            int idx = k / nums[i-1];
            k = k % nums[i-1];
            builder.append(use(used,idx));
        }
        return builder.toString();
    }


    public String getPermutation1(int n, int k) {
        if(n <= 0 || k <= 0)
            return "";

        int num = 1;
        for(int i = 2 ; i <= n ; i++){
            num *= i;
        }
        if(k > num)
            return "";
        int[] nums = new int[n+1];
        for(int i = 0 ; i <= n ; i++){
            nums[i] = i ;
        }
        StringBuilder rs = new StringBuilder();
        int i = 1;
        num = num / n;
        int j = n - 1;
        k = k - 1;
        while(0 != k){
            if(k < num){
                rs.append(nums[i++]);
                num = num / j--;
            }else{
                int x = k / num + i ; //计算需要交换到高位的数字
                int temp = nums[i];
                nums[i] = nums[x];
                for(int t = x - 1 ; t > i ; t--){
                    nums[t+1] = nums[t];
                }
                nums[i + 1] = temp;
                rs.append(nums[i++]);
                k = k % num ;
                num = num / j--;
            }
        }
        for(; i <= n ; i++)
            rs.append(nums[i]);
        return rs.toString();
    }
    public static void main(String[] args){
        System.out.println(new LeetCode60().getPermutation(4,9));
    }
}
