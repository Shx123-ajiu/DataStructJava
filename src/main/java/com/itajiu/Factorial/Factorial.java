/**
 * @discription 阿鸠本人所著，未经许可，不得转发，否则追求法律责任
 * @author 阿鸠
 * @date 2025/11/24 19:57
 * @param null
 * @return {@code null}
 **/

package com.itajiu.Factorial;

public class Factorial {
    public static void main(String[] args) {
        int f = f(5);
        System.out.println(f);
        reverse(0, "abcde");
    }

    //阶乘
    public static int f(int n) {
        if (n == 1) {
            return 1;
        }
        return n * f(n - 1);
    }

    //递归实现反转字符串
    public static void reverse(int n, String str) {
        if (n == str.length()) {
            return;
        }
        System.out.print(str.charAt(n));    //递归调用开始，开始打印，所以说正向打印
        reverse(n + 1, str);
        System.out.print(str.charAt(n));    //递归调用结束，开始返回,所以是反转的
    }
}
