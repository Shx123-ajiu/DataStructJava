package com.itajiu.Tree;

/**
 * @author ${阿鸠}
 * @Date ${2025/11/11} ${23.59}
 * @package
 * @Description:本人所著，未经许可，不得转发，否则追究法律责任
 */


//二叉搜索树 泛型
//Binary Search Tree
public class BSTTree2<T extends Comparable<T>> {


    //根节点
    BSTNode<T> root;

    static class BSTNode<T> {
        T key;
        Object value;
        BSTNode<T> left;
        BSTNode<T> right;

        public BSTNode(T key) {
            this.key = key;
        }

        public BSTNode(T key, Object value) {
            this.key = key;
            this.value = value;
        }

        public BSTNode(T key, Object value, BSTNode<T> left, BSTNode<T> right) {
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

    //泛型 非递归
    public Object get(T key) {
        BSTNode<T> p = root;
        while (p != null) {
            /*
               如果compareTo()返回0，  key = p.key
               如果compareTo()返回正数，key > p.key
               如果compareTo()返回负数，key < p.key
             */
            if (key.compareTo(p.key) < 0) {
                p = p.left;
            } else if (key.compareTo(p.key) > 0) {
                p = p.right;
            } else {
                return p.value;
            }
        }
        return null;
    }









}

