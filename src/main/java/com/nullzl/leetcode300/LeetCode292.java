package main.java.com.nullzl.leetcode300;

public class LeetCode292 {

    public boolean canWinNim1(int n) {

        if(1 == n || 2 == n || 3 == n)
            return true;

        return !canWinNim1(n-1) ||
                !canWinNim1(n-2) ||
                !canWinNim1(n-3);


    }

    public boolean canWinNim2(int n) {
        boolean nim1 = true;
        boolean nim2 = true;
        boolean nim3 = true;
        if(n <= 3)
            return true;
        for(int i = 4 ; i <= n ; i++){
            boolean temp = nim3;
            nim3 = !nim1 || !nim2 || !nim3;
            nim1 = nim2;
            nim2 = temp;
        }
        return nim3;
    }

    public boolean canWinNim(int n){
        if(0 == n % 4)
            return false;
        return true;
    }
}
