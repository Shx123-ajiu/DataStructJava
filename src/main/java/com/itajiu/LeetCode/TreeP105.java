package com.itajiu.LeetCode;

import java.util.Arrays;

/**
 * @author ${阿鸠}
 * @Date ${2025/11/11} ${23.59}
 * @package
 * @Description:本人所著，未经许可，不得转发，否则追究法律责任
 */


//二叉树给了你前序结果    preOrder = {1,2,4,3,6,7}
//二叉树给了你中序结果    inOrder = {4,2,1,6,3,7}

//根 1                   根 1
//左 2 4                 左 4 2
//右 3 6 7               右 6 3 7

//要求你进行树的构造，以及后序遍历
public class TreeP105 {

    public Tree_Node builderTree(int[] preOrder, int[] inOrder) {
        if (preOrder.length == 0 || inOrder.length == 0) {
            return null;
        }
        //创建根节点
        int rootValue = preOrder[0];
        Tree_Node root = new Tree_Node(rootValue);

        //区别左右子树 ， 找到了根节点，中序遍历根节点左边是左子树，右边是右子树
        for (int i = 0; i < inOrder.length; i++) {
            if (inOrder[i] == rootValue) {
                //0 - i-1 左子树
                //i+1 - inOrder.length-1 右子树
                int[] inLeft = Arrays.copyOfRange(inOrder, 0, i);//含头不含尾
                int[] inRight = Arrays.copyOfRange(inOrder, i + 1, inOrder.length);//含头不含尾

                int[] preLeft = Arrays.copyOfRange(preOrder, 0, i + 1);
                int[] preRight = Arrays.copyOfRange(preOrder, i + 1, preOrder.length);

                root.left = builderTree(preLeft, inLeft);
                root.right = builderTree(preRight, inRight);
            }
        }
        return root;
    }
}
