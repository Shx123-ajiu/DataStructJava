/**
 * @discription 阿鸠本人所著，未经许可，不得转发，否则追求法律责任
 * @author 阿鸠
 * @date 2025/11/24 19:57
 * @param null
 * @return {@code null}
 **/

package com.itajiu.Array;

import java.util.Arrays;

public class BubbleSort {

    //实现冒泡排序
    public static void sort(int[] a) {
        bubble(a, a.length - 1);
    }

    //工具方法 冒泡排序
    //right代表未排序区域的右边界
    private static void bubble(int[] a, int right) {
        if (right == 0) {
            return;
        }
        for (int i = 0; i < right; i++) {
            if (a[i] > a[i + 1]) {
                int temp = a[i];
                a[i] = a[i + 1];
                a[i + 1] = temp;
            }
        }
        bubble(a, right - 1);
    }

    public static void main(String[] args) {
        int[] a = {5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(a));
        bubble(a, a.length - 1);
        System.out.println(Arrays.toString(a));

    }
}
