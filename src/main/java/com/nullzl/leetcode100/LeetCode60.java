package main.java.com.nullzl.leetcode100;

public class LeetCode60 {
    public String getPermutation(int n, int k) {
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
