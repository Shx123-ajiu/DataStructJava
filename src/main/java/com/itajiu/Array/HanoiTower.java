/**
 * @discription 阿鸠本人所著，未经许可，不得转发，否则追求法律责任
 * @author 阿鸠
 * @date 2025/11/24 19:57
 * @param null
 * @return {@code null}
 **/

package com.itajiu.Array;

import java.util.LinkedList;

//汉诺塔
public class HanoiTower {

    static LinkedList<Integer> a = new LinkedList<>();
    static LinkedList<Integer> b = new LinkedList<>();
    static LinkedList<Integer> c = new LinkedList<>();

    static void init(int n) {
        for (int i = n; i >= 1; i--) {
            a.addLast(i);
        }
    }

    private static void print() {
        System.out.println("==============================");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

    //汉诺塔
    //首先先把 n-1个盘子从a移动到b（a借助c移动到b）
    //然后把 第n个盘子从a移动到c（a移动到c）
    //最后把 n-1个盘子从b移动到c（b借助a移动到c）
    private static void move(int n, LinkedList<Integer> a, LinkedList<Integer> b, LinkedList<Integer> c) {
        if (n == 0) {
            return;
        }
        move(n - 1, a, c, b);
        c.addLast(a.removeLast());
        print();
        move(n - 1, b, a, c);
    }

    public static void main(String[] args) {
        init(3);
        print();
        move(3, a, b, c);
    }


}
