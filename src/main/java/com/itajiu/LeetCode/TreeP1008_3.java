package com.itajiu.LeetCode;

/**
 * @author ${阿鸠}
 * @Date ${2025/11/11} ${23.59}
 * @package
 * @Description:本人所著，未经许可，不得转发，否则追究法律责任
 */

//根据前序遍历构造二叉搜索树
//分支法
public class TreeP1008_3 {

    // 8 5 1 7 10 12
    // 8 是 跟
    // 5根 1 左 7 右
    // 10 根 null 左 12 右
    public Tree_Node bstFromPreorder(int[] preorder) {
        return partition(preorder, 0, preorder.length - 1);
    }

    private Tree_Node partition(int[] preorder, int start, int end) {
        if (start > end) {
            return null;
        }
        Tree_Node root = new Tree_Node(preorder[start]);
        int index = start + 1;
        while (index <= end) {
            if(preorder[index] > preorder[start]){
                break;
            }
            index++;
        }
        //退出循环时，index就是右子树的起点
        root.left = partition(preorder, start + 1, index - 1);
        root.right = partition(preorder, index, end);
        return root;
    }

}
