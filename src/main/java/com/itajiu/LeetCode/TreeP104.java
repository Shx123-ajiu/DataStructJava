package com.itajiu.LeetCode;

/**
 * @author ${阿鸠}
 * @Date ${2025/11/11} ${23.59}
 * @package
 * @Description:本人所著，未经许可，不得转发，否则追究法律责任
 */


//leetcode 的题目要求深度的数量加一
//递归
public class TreeP104 {
    public int maxDepth(Tree_Node node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        int d1 = maxDepth(node.left);
        int d2 = maxDepth(node.right);

        return Integer.max(d1, d2) + 1;
    }
}
