package com.itajiu.LeetCode;

import com.itajiu.Stack.LinkedListStack;
import com.sun.source.tree.Tree;

import java.util.LinkedList;

/**
 * @author ${阿鸠}
 * @Date ${2025/11/11} ${23.59}
 * @package
 * @Description:本人所著，未经许可，不得转发，否则追究法律责任
 */
public class TreeP104_2 {

    //后序遍历
    public int maxDepth(Tree_Node root) {
        Tree_Node curr = root;
        Tree_Node pop = null;
        LinkedList<Tree_Node> stack = new LinkedList<>();
        int max = 0; //最大深度
        while (curr != null && !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                int size = stack.size();
                if (size > max) {
                    max = size;
                }
                curr = curr.left;
            } else {
                Tree_Node peek = stack.peek();
                if (peek.right == null || peek.right == pop) {
                    pop = stack.pop();
                } else {
                    curr = peek.right;
                }
            }
        }
        return max;
    }
}
