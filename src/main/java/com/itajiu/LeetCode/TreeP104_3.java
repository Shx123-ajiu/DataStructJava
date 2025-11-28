package com.itajiu.LeetCode;

import java.util.Queue;

import java.util.LinkedList;

/**
 * @author ${阿鸠}
 * @Date ${2025/11/11} ${23.59}
 * @package
 * @Description:本人所著，未经许可，不得转发，否则追究法律责任
 */
public class TreeP104_3 {

    //层序遍历
    public int maxDepth(Tree_Node root) {
        Queue<Tree_Node> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        //int c1 = 1; //当前层节点数
        while (!queue.isEmpty()) {
            //int c2 = 0; //下一层节点数
            //for (int i = 0; i < c1; i++) {
            int size = queue.size();    //当前层节点数
            for (int i = 0; i < size; i++) {
                Tree_Node poll = queue.poll();
                //System.out.print(poll.val + "\t");
                if (poll.left != null) {
                    queue.offer(poll.left);
                    //c2++;
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                    //c2++;
                }
            }
            //c1 = c2;
            System.out.println();
            depth++;
        }
        return depth;
    }

    public static void main(String[] args) {
        Tree_Node root = new Tree_Node(
                new Tree_Node(new Tree_Node(4), 2, new Tree_Node(new Tree_Node(7), 5, null)),
                1,
                new Tree_Node(null, 3, new Tree_Node(6))
        );
        new TreeP104_3().maxDepth(root);
    }
}
