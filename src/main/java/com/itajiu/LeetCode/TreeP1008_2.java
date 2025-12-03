package com.itajiu.LeetCode;

/**
 * @author ${阿鸠}
 * @Date ${2025/11/11} ${23.59}
 * @package
 * @Description:本人所著，未经许可，不得转发，否则追究法律责任
 */

//根据前序遍历构造二叉搜索树
public class TreeP1008_2 {

    public Tree_Node bstFromPreorder(int[] preorder) {
        return insert(preorder, Integer.MAX_VALUE);
    }

    int i = 0;
    private Tree_Node insert(int[] preorder, int max) {
        if (i == preorder.length) {
            return null;
        }
        int val = preorder[i];
        if (val > max) {
            return null;
        }
        Tree_Node node = new Tree_Node(val);
        i++;
        node.left = insert(preorder, val);
        node.right = insert(preorder, max);
        return node;
    }
}
