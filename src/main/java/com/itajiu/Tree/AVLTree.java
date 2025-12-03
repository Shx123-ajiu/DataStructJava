package com.itajiu.Tree;

import javax.print.attribute.standard.PresentationDirection;
import java.util.Random;

/**
 * @author 阿鸠
 * @Date 03
 * @package com.itajiu.Tree
 * @Description:本人所著，未经许可，不得转发，否则追究法律责任
 */
//平衡二叉树
public class AVLTree {

    static class AVLNode {
        int key;
        Object value;
        AVLNode left;
        AVLNode right;
        int height = 1; // 节点高度

        public AVLNode(int key, Object value) {
            this.key = key;
            this.value = value;
        }

        public AVLNode(int key) {
            this.key = key;
        }

        public AVLNode(int key, Object value, AVLNode left, AVLNode right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    //获取节点高度
    private int height(AVLNode node) {
        return node == null ? 0 : node.height;
    }

    //更新节点高度（新增，删除，旋转）
    private void updateHeight(AVLNode node) {
        node.height = Integer.max(height(node.left), height(node.right)) + 1;
    }

    //平衡因子(balance factor) = 左子树高度 - 右子树高度
    private int bf(AVLNode node) {
        return height(node.left) - height(node.right);
    }

    // bf = 0 平衡
    // bf > 1 左边更高
    // bf < -1 右边更高


    // 右旋代码
    // 参数: 要旋转的节点
    // 返回值: 新的根节点

    /*
          r                                     y
         / \                                   / \
        y                   ====>           val   r
       / \                                       / \
     val  g                                     g   val

     */

    // RR
    private AVLNode rightRotate(AVLNode red) {
        //先定义
        AVLNode yellow = red.left;
        AVLNode green = yellow.right;
        //旋转
        yellow.right = red;  //上位
        red.left = green;    //换爹
        return yellow;
    }


    // 左旋代码
    // 参数: 要旋转的节点
    // 返回值: 新的根节点

    /*
          r                                     y
         / \                                   / \
       val  y                   ====>         r  val
           / \                               / \    \
          g  val                           val  g   val
               \
               val
     */

    // LL
    private AVLNode leftRotate(AVLNode red) {
        //先定义
        AVLNode yellow = red.right;
        AVLNode green = yellow.left;
        //旋转
        yellow.left = red;
        red.right = green;
        return yellow;
    }


    //先旋转左子树，再右旋根节点

    /*
         val                        val                              y
         / \                        / \                            /   \
        r  val      ====>          y  val           ====>        val    r
       / \                        / \                           / \    /  \
          y                      r  val                       val val g   val
         / \                    / \
        g  val               val   g

     */

    // LR
    private AVLNode leftRightRotate(AVLNode node) {
        leftRotate(node.left);
        return rightRotate(node);
    }


    //先旋转右子树，再左旋根节点

     /*
         val                        val                               y
         / \                        / \                             /   \
       val  r      ====>         val   y            ====>          r    val
           / \                        / \                         / \   / \
          y                          val r                      val  g val val
         / \                            / \
        g  val                         g  val

     */

    // RL
    private AVLNode rightLeftRotate(AVLNode node) {
        rightRotate(node.right);
        return leftRotate(node);
    }


    /*
    LL
      - 失衡节点的 bf>1，即左边更高
      - 失衡节点的左孩子的bf>=0,即左孩子这边是左边更高或等高

    LR
      - 失衡节点的bf>1，即左边更高
      - 失衡节点的左孩子的bf<0即左孩子这边是右边更高

    RL
      - 失衡节点的 bf<-1，即右边更高
      - 失衡节点的右孩子的bf>0，即右孩子这边是左边更高

    RR
      - 失衡节点的bf<-1，即右边更高
      - 失衡节点的右孩子的bf<=0，即右孩子这边是右边更高或等高

     */


}
