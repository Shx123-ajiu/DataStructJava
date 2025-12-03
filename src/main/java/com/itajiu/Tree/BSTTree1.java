package com.itajiu.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ${阿鸠}
 * @Date ${2025/11/11} ${23.59}
 * @package
 * @Description:本人所著，未经许可，不得转发，否则追究法律责任
 */


//二叉搜索树
//Binary Search Tree
public class BSTTree1 {

    //根节点
    BSTNode root;

    static class BSTNode {
        int key;
        Object value;
        BSTNode left;
        BSTNode right;

        public BSTNode(int key) {
            this.key = key;
        }

        public BSTNode(int key, Object value) {
            this.key = key;
            this.value = value;
        }

        public BSTNode(int key, Object value, BSTNode left, BSTNode right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }


    /**
     * @param key-关键字
     * @return {@code 关键字对应的值}
     * @discription 查找关键字对应的值
     * @author 阿鸠
     * @date 2025/12/1 10:24
     **/

    //递归方法
    public Object get(int key) {
        return doGet(root, key);
    }

    //专门用来做递归的方法
    public Object doGet(BSTNode node, int key) {
        if (node == null) {
            return null;    //找不到
        }
        if (key < node.key) {
            return doGet(node.left, key);   //向左找
        } else if (key > node.key) {
            return doGet(node.right, key);  //向右找
        } else {
            return node.value;  //找到
        }
    }


    //非递归方法
    /*
    public Object get(int key) {
        BSTNode node = root;
        while (node != null) {
            if (key < node.key) {
                node = node.left;
            } else if (key > node.key) {
                node = node.right;
            } else {
                return node.value;
            }
        }
        return null;
    }
     */

    /**
     * @return {@code 关键字对应的值}
     * @discription 查找最小关键字对应的值
     * @author 阿鸠
     * @date 2025/12/1 10:28
     **/

    //递归方法
    public Object min() {
        return doMin(root);
    }

    //专门用来做递归的方法
    public Object doMin(BSTNode node) {
        if (node == null) {
            return null;
        }
        if (node.left == null) {
            return node.value;
        }
        return doMin(node.left);
    }

    //非递归方法
    /*
    public Object min() {
        if (root == null) {
            return null;
        }
        BSTNode p = root;
        while (p.left != null) {
            p = p.left;
        }
        return p.value;
    }
     */


    /**
     * @return {@code 关键字对应的值}
     * @discription 查找最大关键字对应的值
     * @author 阿鸠
     * @date 2025/12/1 10:31
     **/

    //递归方法
    public Object max() {
        return doMax(root);
    }

    //专门用来做递归的方法
    public Object doMax(BSTNode node) {
        if (node == null) {
            return null;
        }
        if (node.right == null) {
            return node.value;
        }
        return doMax(node.right);
    }

    //非递归方法
    /*
    public Object max() {
        if (node == null) {
            return null;
        }
        BSTNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        return p.value;
    }
     */

    /**
     * @return {@code 关键字对应的值}
     * @discription 存储关键字和对应值
     * @author 阿鸠
     * @date 2025/12/1 10:32
     **/
    public void put(int key, Object value) {
        //1. key 有 更新
        //2. key 没有 新增
        BSTNode node = root;
        BSTNode parent = null;  //更新前的那个节点是null
        while (node != null) {
            //每次开始时 先把每个节点存到parent中 做为临时节点  但是更新前结束while后是更新不到null的
            parent = node;
            if (key < node.key) {
                node = node.left;
            } else if (key > node.key) {
                node = node.right;
            } else {
                //找到了
                node.value = value;
                return;
            }
        }


        //找不到 做新增
        //如果树为空的话 新增节点作为父节点
        if (parent == null) {
            root = new BSTNode(key, value);
            return;
        }
        //树不为空的话 更新新增节点
        if (key < parent.key) {
            parent.left = new BSTNode(key, value);
        } else if (key > parent.key) {
            parent.right = new BSTNode(key, value);
        }
    }

    /**
     * @return {@code 前驱值}
     * @discription 查找关键字前驱值
     * @author 阿鸠
     * @date 2025/12/1 10:33
     **/
    public Object predecessor(int key) {
        BSTNode p = root;
        BSTNode ancestorFromLeft = null;
        while (p != null) {
            if (key < p.key) {
                p = p.left;
            } else if (key > p.key) {
                ancestorFromLeft = p;
                p = p.right;
            } else {
                break;
            }
        }

        //情况1 节点有左子树，此时前任就是左子树最大值
        if (p == null) {
            return null;
        }
        if (p.left != null) {
            return max(p.left);
        }

        //情况2 节点没有左子树，离他最近的，自左而来的祖先就是前任
        return ancestorFromLeft != null ? ancestorFromLeft.value : null;
    }

    //用来找最大值的
    private Object max(BSTNode node) {
        if (node == null) {
            return null;
        }
        BSTNode p = node;
        while (p.right != null) {
            p = p.right;
        }
        return p.value;
    }

    /**
     * @return {@code 后继值}
     * @discription 查找关键字后继值
     * @author 阿鸠
     * @date 2025/12/1 10:34
     **/

    public Object successor(int key) {
        BSTNode p = root;
        BSTNode ancestorFromRight = null;
        while (p != null) {
            if (key < p.key) {
                ancestorFromRight = p;
                p = p.left;
            } else if (key > p.key) {
                p = p.right;
            } else {
                break;
            }
        }
        //情况1 节点有右子树，此时后任就是右子树最小值
        if (p == null) {
            return null;
        }
        if (p.right != null) {
            return min(p.right);
        }
        //情况2 节点没有右子树，离他最近的，自右而来的祖先就是后任
        return ancestorFromRight != null ? ancestorFromRight.value : null;
    }

    //用来找最小值的
    private Object min(BSTNode node) {
        if (node == null) {
            return null;
        }
        BSTNode p = node;
        while (p.left != null) {
            p = p.left;
        }
        return p.value;
    }

    /**
     * @return {@code 被删除关键字的对应值}
     * @discription 删除关键字
     * @author 阿鸠
     * @date 2025/12/1 10:35
     **/

    //递归方法
//    public Object delete(int key) {
//        BSTNode p = root;
//        BSTNode parent = null;  //待删节点的父亲节点
//        while (p != null) {
//            if (key < p.key) {
//                p = p.left;
//            } else if (key > p.key) {
//                parent = p;
//                p = p.right;
//            } else {
//                break;
//            }
//        }
//
//        if (p == null) {
//            return null;
//        }
//
//        //情况1 删除节点没有左孩子，将右孩子托孤给Parent
//        if (p.left == null) {
//            shift(parent, p, p.right);
//        }
//
//        //情况2 删除节点没有右孩子，将左孩子托孤给Parent
//        else if (p.right == null) {
//            shift(parent, p, p.left);
//        }
//        //情况3 删除节点左右孩子都没有，已经涵盖在情况1和情况2中，把null托孤给Parent，所以不用写了
//
//        //情况4 删除节点左右孩子都有 可以将它的后继节点（成为S），托孤给Parent，在称S的父亲为SP，此时又分两种情况
//        //4.1 SP就是被删除节点，此时D与S紧邻，只需要将S托孤给Parent
//        //4.2 SP不是被删除节点，此时D与S不相邻，此时需要将S的后代托孤给SP，再将S托孤给Parent
//        else {
//            //被删除节点找后继节点 s
//            BSTNode s = p.right;
//            BSTNode sParent = p;    //后继节点的父节点
//            while(s.left != null){
//                sParent = s;
//                s = s.left;
//            }
//            if(sParent != p){
//                shift(sParent, s, s.right);
//                s.right = p.right;
//            }
//            shift(parent, p, s);
//            s.left = p.left;
//        }
//        return p.value;
//    }


    /**
     * @param parent  被删除节点的父节点
     * @param deleted 被删除节点
     * @param child   被删除节点的子节点
     *                return  void
     * @discription 托孤方法
     **/
    private void shift(BSTNode parent, BSTNode deleted, BSTNode child) {
        if (parent == null) {
            root = child;
        } else if (deleted == parent.left) {
            parent.left = child;
        } else if (deleted == parent.right) {
            parent.right = child;
        }
    }


    //非递归方法
    public Object delete(int key) {
        ArrayList<Object> result = new ArrayList<>();
        root = doDelete(root, key, result);
        return null;
    }

    private BSTNode doDelete(BSTNode node, int key, ArrayList<Object> result) {
        if (node == null) {
            return null;
        }
        if (key < node.key) {
            node.left = doDelete(node.left, key, result);
            return node;
        }
        if (key > node.key) {
            node.right = doDelete(node.right, key, result);
            return node;
        }
        result.add(node.value);
        //情况1 只有右孩子
        if (node.left == null) {
            return node.right;
        }
        //情况2 只有左孩子
        if (node.right == null) {
            return node.left;
        }
        //情况3 左右孩子都有
        BSTNode s = node.right;
        while (s.left != null) {
            s = s.left;
        }
        s.right = doDelete(node.right, s.key, new ArrayList<>());
        s.left = node.left;
        return s;

    }

    //找 < key 的所有value值
    public List<Object> less(int key) {
        ArrayList<Object> result = new ArrayList<>();
        BSTNode p = root;
        LinkedList<BSTNode> stack = new LinkedList<>();
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                BSTNode pop = stack.pop();
                if (pop.key < key) {
                    result.add(pop.value);
                } else {
                    break;
                }
                p = pop.right;
            }
        }
        return result;
    }

    //找 > key 的所有value值
    public List<Object> greater(int key) {
        ArrayList<Object> result = new ArrayList<>();
        BSTNode p = root;
        LinkedList<BSTNode> stack = new LinkedList<>();
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.right;
            } else {
                BSTNode pop = stack.pop();
                if (pop.key > key) {
                    result.add(pop.value);
                } else {
                    break;
                }
                p = pop.left;
            }
        }
        return result;
    }

    //找 >= key1 && <= key2 的所有value值
    public List<Object> between(int key1, int key2) {
        ArrayList<Object> result = new ArrayList<>();
        BSTNode p = root;
        LinkedList<BSTNode> stack = new LinkedList<>();
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                BSTNode pop = stack.pop();
                if (pop.key >= key1 && pop.key <= key2) {
                    result.add(pop.value);
                }
                pop = pop.right;
            }
        }
        return result;
    }

}
