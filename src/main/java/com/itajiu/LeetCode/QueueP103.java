package com.itajiu.LeetCode;

import com.itajiu.Queue.LinkedListQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ${阿鸠}
 * @Date ${2025/11/11} ${23.59}
 * @package
 * @Description:本人所著，未经许可，不得转发，否则追究法律责任
 */
public class QueueP103 {
    //二叉树z字层序遍历
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedListQueue<TreeNode> queue = new LinkedListQueue<>();
        queue.offer(root);
        int c1 = 1; // 当前层节点数
        boolean odd = true; // 奇数层为true，偶数层为false
        while (!queue.isEmpty()) {
            LinkedList<Integer> level = new LinkedList<>();
            int c2 = 0; // 下一层节点数
            for (int i = 0; i < c1; i++) {
                TreeNode n = queue.poll();
                if (odd) {
                    level.addLast(n.val);
                } else {
                    level.addFirst(n.val);
                }
                if (n.left != null) {
                    queue.offer(n.left);
                    c2++; //如果发现有左孩子，则下一层节点数加1
                }
                if (n.right != null) {
                    queue.offer(n.right);
                    c2++; //如果发现有右孩子，则下一层节点数加1
                }
            }
            odd = !odd;
            result.add(level);
            c1 = c2;
        }
        return result;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                1,
                new TreeNode(
                        2,
                        new TreeNode(4),
                        new TreeNode(5)
                ),
                new TreeNode(
                        3,
                        new TreeNode(6),
                        new TreeNode(7)
                )
        );

        // 使用zigzagLevelOrder方法进行Z字形遍历
        QueueP103 solution = new QueueP103();
        List<List<Integer>> result = solution.zigzagLevelOrder(root);
        for (List<Integer> level : result) {
            System.out.println(level);
        }
    }
}
