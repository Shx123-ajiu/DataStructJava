package com.itajiu.LeetCode;

/**
 * @author ${阿鸠}
 * @Date ${2025/11/11} ${23.59}
 * @package
 * @Description:本人所著，未经许可，不得转发，否则追究法律责任
 */

//反转二叉树
public class TreeP226 {
    public Tree_Node inverTree(Tree_Node root) {
        fn(root);
        return root;
    }


    public static void fn(Tree_Node node) {
        if (node == null) {
            return;
        }

        Tree_Node t = node.left;
        node.left = node.right;
        node.right = t;

        fn(node.left);
        fn(node.right);
    }

}
