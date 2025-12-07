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
        updateHeight(red);
        updateHeight(yellow);
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
        updateHeight(red);
        updateHeight(yellow);
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

    //检查节点是否失衡，重新平衡代码
    private AVLNode balance(AVLNode node) {
        if (node == null) {
            return null;
        }
        int bf = bf(node);
        // 0 1 -1 是正常
        //LL
        if (bf > 1 && bf(node.left) >= 0) {
            return rightRotate(node);
        }
        //LR
        else if (bf > -1 && bf(node.left) < 0) {
            return leftRightRotate(node);
        }
        //RL
        else if (bf < -1 && bf(node.right) > 0) {
            return rightLeftRotate(node);
        }
        //RR
        else if (bf < 1 && bf(node.right) <= 0) {
            return leftRotate(node);
        }
        return node;
    }


    //新增 更新
    AVLNode root;

    public void put(int key, Object value) {
        root = doPut(root, key, value);
    }

    //新增更新
    public AVLNode doPut(AVLNode node, int key, Object value) {
        //1. 找到空位，创建新节点
        if (node == null) {
            return new AVLNode(key, value);
        }
        //2. key 已存在，更新
        if (key == node.key) {
            node.value = value;
            return node;
        }
        //3. 继续查找
        if (key < node.key) {
            node.left = doPut(node.left, key, value);  //向左
        } else {
            node.right = doPut(node.right, key, value); //向右
        }
        updateHeight(node);
        return balance(node);
    }


    public void remove(int key) {
        root = doRemove(root, key);
    }


    private AVLNode doRemove(AVLNode node, int key) {
        //1. node为空
        if (node == null) {
            return null;
        }
        //2. 没找到key

        if (key < node.key) {
            node.left = doRemove(node.left, key);
        } else if (key > node.key) {
            node.right = doRemove(node.right, key);
        } else {
            //3. 没找到key 1.没有 2.只有一个孩子 3.有两个孩子
            if (node.left == null && node.right == null) {
                return null;
            } else if (node.left == null) {
                node = node.right;
            } else if (node.right == null) {
                node = node.left;
            } else {
                AVLNode s = node.right;
                while (s.left != null) {
                    s = s.left;
                }
                // s 后继节点
                s.right = doRemove(node.right, s.key);
                s.left = node.left;
                node = s;
            }
        }

        //4. 更新高度
        updateHeight(node);
        //5. balance
        return balance(node);
    }
}
