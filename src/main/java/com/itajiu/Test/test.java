package com.itajiu.Test;

import java.util.Scanner;

public class test {

    /**
     * 约瑟夫问题迭代解法
     * @param n 总人数
     * @param m 报数间隔
     * @return 最后一个被淘汰的人的编号
     */
    public static int josephus(int n, int m) {
        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = (result + m) % i;
        }
        return result + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入总人数 n: ");
        int n = scanner.nextInt();

        System.out.print("请输入报数间隔 m: ");
        int m = scanner.nextInt();

        int lastPerson = josephus(n, m);
        System.out.println("最后被淘汰的人的编号是: " + lastPerson);

        scanner.close();
    }
}
