package com.nullzl.interview;

import com.nullzl.util.TreeNode;

public class Interview0405 {

    TreeNode node = null;

    public boolean isValidBST(TreeNode root) {
        if(null == root)
            return true;
        if(!isValidBST(root.left))
            return false;
        if(null != node && root.val <= node.val)
            return false;
        node = root;
        return isValidBST(root.right);
    }
}
