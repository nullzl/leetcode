package com.nullzl.offer;

import com.nullzl.util.TreeNode;

public class Offer2_56 {

    int delta = 10000;

    private boolean traverse(boolean[] map,TreeNode node,int k){
        if(null == node)
            return false;
        if(traverse(map,node.left,k))
            return true;
        int key = k - node.val + delta;
        if(key >= 0 && key < map.length && map[key])
            return true;
        map[node.val + delta] = true;
        return traverse(map,node.right,k);
    }

    public boolean findTarget(TreeNode root, int k) {

        boolean[] map = new boolean[(delta << 1)  + 1];
        return traverse(map,root,k);
    }
}
