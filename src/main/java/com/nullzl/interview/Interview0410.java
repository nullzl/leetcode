package com.nullzl.interview;

import com.nullzl.util.TreeNode;

public class Interview0410 {

    public boolean isSame(TreeNode t1,TreeNode t2){
        if(null == t1 && null == t2)
            return true;
        if(null == t1 || null == t2)
            return false;
        return t1.val == t2.val && isSame(t1.left,t2.left) && isSame(t1.right,t2.right);
    }

    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if(null == t1)
            return false;
        return isSame(t1,t2) || checkSubTree(t1.left,t2) || checkSubTree(t1.right,t2);

    }
}
