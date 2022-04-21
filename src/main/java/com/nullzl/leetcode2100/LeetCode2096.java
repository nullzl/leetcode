package com.nullzl.leetcode2100;

import com.nullzl.util.TreeNode;

public class LeetCode2096 {

    char[][] chs = new char[][]{{'U','U'},{'L','R'}};
    private int traverse(TreeNode root,StringBuilder[] strs,int s,int e){
        if(null == root)
            return -1;
        int rs = root.val == s ? 0 : (root.val == e ? 1 : -1);
        int count = -1 == rs ? 0 : 1;
        int left = traverse(root.left,strs,s,e);
        count = -1 == left ? count : (2 == left ? 2 : count + 1);
        rs = -1 != left ? left : rs;
        int right = 2 == count ? -1 : traverse(root.right,strs,s,e);
        count = -1 == right ? count : (2 == right ? 2 : count + 1);
        rs = -1 != right ? right : rs;
        if(left == 0 || left == 1)
            strs[left].append(chs[left][0]);
        if(right == 0 || right == 1)
            strs[right].append(chs[right][1]);
        return 2 == count ? 2 : rs;

    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder[] strs = new StringBuilder[]{new StringBuilder(),new StringBuilder()};
        traverse(root,strs,startValue,destValue);
        strs[0].append(strs[1].reverse());
        return strs[0].toString();
    }
}
