package com.nullzl.leetcode400;

import com.nullzl.util.TreeNode;

public class LeetCode337 {

    private int maxProfit(TreeNode root,boolean canRob){
        if(null == root)
            return 0;
        int profit = maxProfit(root.left,true)
                + maxProfit(root.right,true);
        if(canRob){
            profit = Math.max(profit,
                    maxProfit(root.left,false)
                    + maxProfit(root.right,false) + root.val);
        }
        return profit;
    }

    public int rob(TreeNode root) {

        return maxProfit(root,true);

    }
}
