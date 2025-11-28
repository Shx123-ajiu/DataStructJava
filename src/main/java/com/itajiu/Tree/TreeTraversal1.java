package com.itajiu.Tree;
import com.itajiu.Tree.TreeNode;
import com.itajiu.Stack.LinkedListStack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ${阿鸠}
 * @Date ${2025/11/11} ${23.59}
 * @package
 * @Description:本人所著，未经许可，不得转发，否则追究法律责任
 */

//不用递归
public class TreeTraversal1 {
    /*
             1
            / \
           2   3
          /   / \
         4   5   6
     */
    public List<Integer> preorderTrabersal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        return result;
    }

    //不用递归
    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                new TreeNode(new TreeNode(4), 2, null),
                1,
                new TreeNode(new TreeNode(5), 3, new TreeNode(6))
        );


        LinkedListStack<TreeNode> stack = new LinkedListStack<>(10);

        TreeNode curr = root; // 当前节点
        TreeNode pop = null;   //最近一次弹栈的元素
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                colorPrint("去 :" + curr.val, 31);   //前序遍历代码
                stack.push(curr);   // 入栈 就是为了回溯 访问右子树
                curr = curr.left;
            }


//            else {
//                TreeNode pop = stack.pop();
//                colorPrint("回 :" + pop.val, 34);    //中序遍历代码
//                curr = pop.right;
//            }


            else {
                TreeNode peek = stack.peek();
                if (peek.right == null || peek.right == pop) {
                    pop = stack.pop() ;
                    colorPrint("回 :" + pop.val, 34);    //后序遍历代码
                }else{
                    curr = peek.right;
                }
            }

        }
    }

    private static void colorPrint(String origin, int color) {
        System.out.printf("\033[%dm%s\033[0m%n", color, origin);
    }
}

