package com.itajiu.LeetCode;

/**
 * @author ${阿鸠}
 * @Date ${2025/11/11} ${23.59}
 * @package
 * @Description:本人所著，未经许可，不得转发，否则追究法律责任
 */
public class TreeP101_1 {

    //二叉树最小深度
    public int minDepth(Tree_Node node) {
        if (node == null) {
            return 0;
        }
        int d1 = minDepth(node.left);
        int d2 = minDepth(node.right);
        if(d2 == 0){    //当右子树为null
            return d1 + 1;
        }
        if(d1 == 0){    //当左子树为null
            return d2 + 1;
        }
        return Integer.min(d1, d2) + 1;     //左右子树都不为null
    }


}
