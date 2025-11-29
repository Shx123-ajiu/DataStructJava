package com.itajiu.LeetCode;

import java.util.LinkedList;

/**
 * @author ${阿鸠}
 * @Date ${2025/11/11} ${23.59}
 * @package ]
 * @Description:本人所著，未经许可，不得转发，否则追究法律责任
 */


public class TreeP08 {

    public Tree__Node constructExpressionTree(String[] tokens) {
        LinkedList<Tree__Node> stack = new LinkedList<>();
        for (String t : tokens) {
            switch (t) {
                case "+", "-", "*", "/" -> {
                    Tree__Node right = stack.pop();
                    Tree__Node left = stack.pop();
                    Tree__Node parent = new Tree__Node(t);
                    parent.left = left;
                    parent.right = right;
                    stack.push(parent);
                }
                default -> {
                    stack.push(new Tree__Node(t));
                }

            }

        }
        return stack.peek();
    }


    public class Tree__Node {

        public String val;
        public Tree__Node left;
        public Tree__Node right;

        public Tree__Node(String val) {
            this.val = val;
        }

        public Tree__Node(Tree__Node left, String val, Tree__Node right) {
            this.left = left;
            this.val = val;
            this.right = right;
        }


        @Override
        public String toString() {
            return String.valueOf(this.val);
        }
    }

}
