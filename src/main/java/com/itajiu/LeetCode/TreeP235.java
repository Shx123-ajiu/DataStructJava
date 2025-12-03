package com.itajiu.LeetCode;

/**
 * @author ${阿鸠}
 * @Date ${2025/11/11} ${23.59}
 * @package
 * @Description:本人所著，未经许可，不得转发，否则追究法律责任
 */


//求二叉搜索树最近公共祖先（祖先也包括自己）
//前提
//1.节点值唯一
//2.p和q都存在
public class TreeP235 {
    public Tree_Node lowestCommonAncestor(Tree_Node root, Tree_Node p, Tree_Node q) {
       Tree_Node a = root;
       //在同一侧，要么全是左边，要么全是右边
       while(p.val < a.val && q.val < a.val || a.val > p.val && a.val > q.val){
           if(p.val < a.val && q.val < a.val){
               a = a.left;
           }else{
               a = a.right;
           }
       }
       return a;
    }

}
