package com.itajiu.LeetCode;

/**
 * @author ${阿鸠}
 * @Date ${2025/11/11} ${23.59}
 * @package
 * @Description:本人所著，未经许可，不得转发，否则追究法律责任
 */
public class Tree_Node {

    public int val;
    public Tree_Node left;
    public Tree_Node right;

    public Tree_Node(int val) {
        this.val = val;
    }

    public Tree_Node(Tree_Node left, int val, Tree_Node right) {
        this.left = left;
        this.val = val;
        this.right = right;
    }


    @Override
    public String toString() {
        return String.valueOf(this.val);
    }
}
