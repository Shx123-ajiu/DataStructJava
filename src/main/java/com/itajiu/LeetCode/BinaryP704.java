/**
 * @discription 阿鸠本人所著，未经许可，不得转发，否则追求法律责任
 * @author 阿鸠
 * @date 2025/11/24 19:57
 * @param null
 * @return {@code null}
 **/

package com.itajiu.LeetCode;

public class BinaryP704 {

    // 平衡版
    public int search1(int[] a, int target) {
        int i = 0, j = a.length;
        while (1 < j - i) {
            int m = (i + j) >>> 1;
            if (target < a[m]) { // 左
                j = m;
            } else {            // 右, 或 m
                i = m;
            }
        }
        return (a[i] == target) ? i : -1;
    }

    // 改进版
    public int search2(int[] a, int target) {
        int i = 0, j = a.length;             // 1
        while (i < j) {                      // 3
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m;                       // 2
            } else if (a[m] < target) {
                i = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }

    // 基础版
    public int search3(int[] a, int target) {
        int i = 0, j = a.length - 1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m - 1;
            } else if (a[m] < target) {
                i = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }
}
