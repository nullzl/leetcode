package com.nullzl.leetcode2100;

import java.util.Arrays;

public class LeetCode2043 {
}

class Bank {

    private long[] accounts;

    public Bank(long[] balance) {
        this.accounts = Arrays.copyOf(balance,balance.length);
    }

    private boolean validateAccount(int idx){
        return idx >= 1 && idx <= this.accounts.length;
    }

    private boolean validateMoney(int idx,long money){
        return this.accounts[idx - 1] >= money;
    }

    public boolean transfer(int account1, int account2, long money) {
        if(!validateAccount(account1) || !validateAccount(account2)
                || !validateMoney(account1,money))
            return false;
        this.accounts[account1 - 1] -= money;
        this.accounts[account2 - 1] += money;
        return true;
    }

    public boolean deposit(int account, long money) {
        if(!validateAccount(account))
            return false;
        this.accounts[account - 1] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if(!validateAccount(account) || !validateMoney(account,money))
            return false;
        this.accounts[account - 1] -= money;
        return true;
    }
}
