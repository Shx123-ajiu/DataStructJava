/**
 * @discription 阿鸠本人所著，未经许可，不得转发，否则追求法律责任
 * @author 阿鸠
 * @date 2025/11/24 19:57
 * @param null
 * @return {@code null}
 **/

package com.itajiu.Factorial;

public class MidFactorial {

    public static int serach(int[] a, int target) {
        return f(a, target, 0, a.length - 1);
    }


    private static int f(int[] a, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) >>> 1;
        if (target < a[mid]) {
            return f(a, target, left, mid - 1);
        } else if (target > a[mid]) {
            return f(a, target, mid + 1, right);
        } else {
            return mid;
        }
    }
}
