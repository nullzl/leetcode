package com.nullzl.offer;

import com.nullzl.util.TreeNode;

public class Offer26 {

    public boolean equals(TreeNode A, TreeNode B){
        if(null == B)
            return true;

        if(null == A)
            return false;

        return A.val == B.val && equals(A.left,B.left) && equals(A.right,B.right);
    }


    public boolean isSubStructure(TreeNode A, TreeNode B) {

        if(null == B || null == A)
            return false;

        return equals(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B);
    }

}
