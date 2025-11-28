package com.itajiu.Tree;

import java.security.spec.RSAOtherPrimeInfo;
import java.sql.SQLOutput;

/**
 * @author ${阿鸠}
 * @Date ${2025/11/11} ${23.59}
 * @package
 * @Description:本人所著，未经许可，不得转发，否则追究法律责任
 */
public class TreeTraversal {
    //递归
    public static void main(String[] args) {


        /*
                 1
                / \
               2   3
              /   / \
             4   5   6
         */

        TreeNode root = new TreeNode(
                new TreeNode(new TreeNode(4), 2, null),
                1,
                new TreeNode(new TreeNode(5), 3, new TreeNode(6))
        );
        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
    }


    //前序遍历
    static void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + "\t");  //值
        preOrder(node.left);    //左
        preOrder(node.right);   //右
    }


    //中序遍历
    static void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);     //左
        System.out.print(node.val + "\t");  //值
        inOrder(node.right);    //右
    }


    //后序遍历
    static void postOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);       //左
        postOrder(node.right);      //右
        System.out.print(node.val + "\t");  //值
    }
}
