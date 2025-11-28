package com.itajiu.LeetCode;

import com.itajiu.Tree.TreeNode;

/**
 * @author ${阿鸠}
 * @Date ${2025/11/11} ${23.59}
 * @package
 * @Description:本人所著，未经许可，不得转发，否则追究法律责任
 */

//对称二叉树
public class TreeP101 {

    public boolean isSymmetric(Tree_Node root) {
        return check(root.left, root.right);
    }

    private boolean check(Tree_Node left, Tree_Node right) {
        if (left == null && right == null) {
            return true;
        }
        if (left != null && right == null || left == null && right != null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return check(left.left, right.right) && check(left.right, right.left);
    }
}
