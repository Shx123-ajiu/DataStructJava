package com.itajiu.LeetCode;

/**
 * @author ${阿鸠}
 * @Date ${2025/11/11} ${23.59}
 * @package
 * @Description:本人所著，未经许可，不得转发，否则追究法律责任
 */
public class TreeP1008 {

    //根据前序遍历构造二叉搜索树
    public Tree_Node bstFromPreorder(int[] preorder) {
        Tree_Node root = new Tree_Node(preorder[0]);
        for (int i = 1; i < preorder.length; i++) {
            insert(root, preorder[i]);
        }
        return root;
    }

    private Tree_Node insert(Tree_Node node, int val) {
        if (node == null) {
            return new Tree_Node(val);
        } else if (val < node.val) {
            node.left = insert(node.left, val);
        } else if (val > node.val) {
            node.right = insert(node.right, val);
        }
        return node;
    }

}
