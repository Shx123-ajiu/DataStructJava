package com.itajiu.Test;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        //人生没有唯一解
        switch (choice) {
            case 1:
                System.out.println("向左走，有繁花");
                break;
            case 2:
                System.out.println("向右走，有星光");
                break;
            default:
                System.out.println("向前走，一片光芒");
        }
    }
}
