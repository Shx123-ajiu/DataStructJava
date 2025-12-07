package com.itajiu.RedBlackTree;

import static com.itajiu.RedBlackTree.RedBlackTree.Color.RED;
import static com.itajiu.RedBlackTree.RedBlackTree.Color.BLACK;

@SuppressWarnings("all")
/**
 *@author 阿鸠
 *@Date 2025/12/4  11:48
 *@package com.itajiu.RedBlackTree
 *@Description:本人所著，未经许可，不得转发，否则追究法律责任
 */


/*
 *   红黑树特性
 *   所有null视为黑色
 *   红色节点不能相邻
 *   根节点是黑色
 *   从根到任意一个叶子节点，路径中的黑色节点数一样（黑色完美平衡）
 *
 */



/*
 *                                    b
 *                                  /   \
 *                                 r      b
 *                                / \    / \
 *                               b   b  r   r
 *                              / \   \
 *                             r   r   r
 */

public class RedBlackTree {

    enum Color {
        RED, BLACK
    }

    private Node root;

    private static class Node {
        int key;
        Object value;
        Node left;
        Node right;
        Node parent;    //父节点
        Color color = RED;    //颜色

        public Node(int key, Object value) {
            this.key = key;
            this.value = value;
        }

        //是否是左孩子
        boolean isLeftChild() {
            return parent != null && parent.left == this;
        }

        //叔叔
        Node uncle() {
            if (parent == null || parent.parent == null) {
                return null;
            }
            if (parent.isLeftChild()) {
                return parent.parent.right;
            } else {
                return parent.parent.left;
            }
        }

        //兄弟
        Node sibling() {
            if (parent == null) {
                return null;
            }
            if (this.isLeftChild()) {
                return parent.right;
            } else {
                return parent.left;
            }
        }


    }

    //判断红色
    private boolean isRed(Node node) {
        return node != null && node.color == RED;
    }

    //判断黑色
    private boolean isBlack(Node node) {
        return node == null || node.color == BLACK;
    }

    /*
     *                  p                               y
     *                 / \                               \
     *                y             ====>                 p
     *                 \                                 /
     *                  g                               g
     */

    //右旋
    private void rightRotate(Node pink) {
        Node parent = pink.parent;
        Node yellow = pink.left;
        Node green = yellow.right;
        if (green != null) {
            green.parent = pink;
        }
        yellow.right = pink;
        yellow.parent = parent;
        pink.left = green;
        pink.parent = yellow;
        if (parent == null) {
            root = yellow;
        } else if (parent.left == pink) {
            parent.left = yellow;
        } else {
            parent.right = yellow;
        }
    }

    /*
     *                  p                               y
     *                 / \                             /
     *                y       =====>                  p
     *               / \                               \
     *              g                                 g
     */
    // 左旋
    private void leftRotate(Node pink) {
        Node parent = pink.parent;
        Node yellow = pink.right;   // 获取右子节点作为新的根节点
        Node green = yellow.left;   // 获取新根节点的左子树
        if (green != null) {
            green.parent = pink;
        }
        yellow.parent = parent;
        pink.right = green;
        pink.parent = yellow;
        if (parent == null) {
            root = yellow;
        } else if (parent.left == pink) {
            parent.left = yellow;
        } else {
            parent.right = yellow;
        }
    }

    /**
     * @param Key - 键 value - 值
     * @discription 新增或更新
     **/

    public void put(int key, Object value) {
        Node p = root;
        Node parent = null;
        while (p != null) {
            parent = p;
            if (key < p.key) {
                p = p.left;
            } else if (key > p.key) {
                p = p.right;
            } else {
                p.value = value;
                return;
            }
        }
        Node inserted = new Node(key, value);
        if (parent == null) {
            root = inserted;
        } else if (key < parent.key) {
            parent.left = inserted;
            inserted.parent = parent;
        } else {
            parent.right = inserted;
            inserted.parent = parent;
        }
        fixRedRed(inserted);
    }


    void fixRedRed(Node x) {
        // case1 插入节点是根节点，变黑即可
        if (x == root) {
            x.color = BLACK;
            return;
        }
        // case2 插入节点的父节点是黑色，不用处理
        if (isBlack(x.parent)) {
            return;
        }

        // case3 插入节点的父节点是红色
        Node parent = x.parent;
        Node uncle = x.uncle();
        Node grandparent = parent.parent;
        if (isRed(uncle)) {
            parent.color = BLACK;
            uncle.color = BLACK;
            grandparent.color = RED;
            fixRedRed(grandparent);
            return;
        }

        // case4 插入节点的父节点是红色，叔叔节点是黑色
        if (parent.isLeftChild() && x.isLeftChild()) {
            parent.color = BLACK;
            grandparent.color = RED;
            rightRotate(grandparent);
        } else if (parent.isLeftChild() && x.isLeftChild()) {
            leftRotate(parent);
            x.color = BLACK;
            grandparent.color = RED;
            rightRotate(grandparent);
        } else if (parent.isLeftChild() && x.isLeftChild()) {
            parent.color = BLACK;
            grandparent.color = RED;
            leftRotate(grandparent);
        } else {
            rightRotate(parent);
            x.color = BLACK;
            grandparent.color = RED;
            leftRotate(grandparent);
        }
    }


    /**
     * @param Key - 键
     * @discription 删除 正常删 会用到李代桃僵技巧，遇到黑黑不平衡进行调整
     **/

    public void remove(int key) {
        Node deleted = find(key);
        if (deleted == null) {
            return;
        }
        doRemove(deleted);
    }

    private void fixDoubleBlack(Node x) {
        if (x == root) {
            return;
        }
        Node parent = x.parent;
        Node sibling = x.sibling();
        if (isRed(sibling)) {
            if (x.isLeftChild()) {
                leftRotate(parent);
            } else {
                rightRotate(parent);
            }
            parent.color = RED;
            sibling.color = BLACK;
            fixDoubleBlack(x);
            return;
        }
        if (sibling != null) {
            if (isBlack(sibling.left) && isBlack(sibling.right)) {
                sibling.color = RED;
                if (isRed(parent)) {
                    parent.color = BLACK;
                } else {
                    fixDoubleBlack(parent);
                }
            } else {
                if (sibling.isLeftChild() && isRed(sibling.left)) {
                    rightRotate(parent);
                    sibling.left.color = BLACK;
                    parent.color = parent.color;
                    parent.color = BLACK;
                } else if (sibling.isLeftChild() && isRed(sibling.right)) {
                    leftRotate(sibling);
                    rightRotate(parent);
                    sibling.right.color = parent.color;
                    parent.color = BLACK;
                }
            }

        } else {
            fixDoubleBlack(parent);
        }

    }

    private void doRemove(Node deleted) {
        Node replaced = findReplace(deleted);
        Node parent = deleted.parent;
        if (replaced == null) {
            return;
        } else {
            if (isBlack(deleted)) {
                fixDoubleBlack(deleted);
            } else {
                // 删除红色节点不会影响红黑树性质，无需额外处理
            }
            if (deleted.isLeftChild()) {
                parent.left = null;
            } else {
                parent.right = null;
            }
            deleted.parent = null;
        }
        // 只有一个子节点
        if (deleted.left == null || deleted.right == null) {
            if (deleted == root) {
                root.key = replaced.key;
                root.value = replaced.value;
                root.left = root.right = null;
            } else {
                if (deleted.isLeftChild()) {
                    parent.left = replaced;
                } else {
                    parent.right = replaced;
                }
                replaced.parent = parent;
                deleted.left = deleted.right = deleted.parent = null;
                if (isBlack(deleted) && isBlack(replaced)) {
                    fixDoubleBlack(replaced);
                } else {

                }
            }
            return;
        }
        // 两个子节点
        else {
            int t = deleted.key;
            deleted.key = replaced.key;
            replaced.key = t;
            Object v = replaced.value;
            deleted.value = replaced.value;
            replaced.value = v;
            doRemove(replaced);
        }
    }

    // 查找删除节点
    Node find(int key) {
        Node p = root;
        while (p != null) {
            if (key < p.key) {
                p = p.left;
            } else if (key > p.key) {
                p = p.right;
            } else {
                return p;
            }
        }
        return null;
    }

    // 查找剩余节点
    Node findReplace(Node deleted) {
        if (deleted.left != null && deleted.right != null) {
            return null;
        }
        if (deleted.left != null) {
            return deleted.right;
        }
        if (deleted.right != null) {
            return deleted.left;
        }
        Node s = deleted.right;
        while (s.left != null) {
            s = s.left;
        }
        return s;
    }

}
