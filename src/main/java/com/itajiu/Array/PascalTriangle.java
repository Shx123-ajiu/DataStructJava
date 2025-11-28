/**
 * @discription 阿鸠本人所著，未经许可，不得转发，否则追求法律责任
 * @author 阿鸠
 * @date 2025/11/24 19:57
 * @param null
 * @return {@code null}
 **/

package com.itajiu.Array;

public class PascalTriangle {
    //    1
//    1 1
//    1 2 1
//    1 3 3 1
//    1 4 6 4 1
    // 杨辉三角的元素
    private static int element(int i, int j) {
        if (j == 0 || j == i) {
            return 1;
        }
        return element(i - 1, j - 1) + element(i - 1, j);
    }

    // 打印空格
    private static void printspace(int n, int i) {
        int num = (n - 1 - i) * 2;
        for (int j = 0; j < num; j++) {
            System.out.print(" ");
        }
    }

    // 打印杨辉三角
    private static void print(int n) {
        for (int i = 0; i < n; i++) {
            printspace(n, i);
            for (int j = 0; j <= i; j++) {
                System.out.printf("%-4d", element(i, j));
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        print(5);
    }
}
