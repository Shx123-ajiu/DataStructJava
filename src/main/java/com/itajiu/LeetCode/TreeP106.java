package com.itajiu.LeetCode;

import java.util.Arrays;

/**
 * @author ${阿鸠}
 * @Date ${2025/11/11} ${23.59}
 * @package
 * @Description:本人所著，未经许可，不得转发，否则追究法律责任
 */

//二叉树给了你前序结果    inOrder = {4,2,1,6,3,7}
//二叉树给了后序结果    postOrder = {4,2,6,7,3,1}

public class TreeP106 {
    public Tree_Node builderTree(int[] inOrder, int[] postOrder) {
        if (inOrder.length == 0 || postOrder.length == 0) {
            return null;
        }

        //创建根节点
        int rootValue = postOrder[postOrder.length - 1];
        Tree_Node root = new Tree_Node(rootValue);
        for (int i = 0; i < inOrder.length; i++) {
            if (inOrder[i] == rootValue) {
                int[] inLeft = Arrays.copyOfRange(inOrder, 0, i);
                int[] inRight = Arrays.copyOfRange(inOrder, i + 1, inOrder.length);

                int[] postLeft = Arrays.copyOfRange(postOrder, 0, i);
                int[] postRight = Arrays.copyOfRange(postOrder, i, postOrder.length - 1);

                root.left = builderTree(inLeft, postLeft);
                root.right = builderTree(inRight, postRight);
            }
        }
        return root;
    }
}
