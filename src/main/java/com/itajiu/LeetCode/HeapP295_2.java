package com.itajiu.LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author ${阿鸠}
 * @Date ${2025/11/11} ${23.59}
 * @package
 * @Description:本人所著，未经许可，不得转发，否则追究法律责任
 */
public class HeapP295_2 {

    public void addNum(int num) {
        if (left.size() == right.size()) {
            right.offer(num);
            left.offer(right.poll());
        } else {
            left.offer(num);
            right.offer(left.poll());
        }

    }

    public double findMedian() {
        if (left.size() == right.size()) {
            return (left.peek() + right.peek()) >>> 1;
        } else {
            return left.peek();
        }
    }


    //大顶堆 用自带导包的优先级队列 比较器
    private PriorityQueue<Integer> left = new PriorityQueue<>(
            (a, b) -> Integer.compare(b, a)     //compare -1: b<a  0: b=a  1: b>a
    );

    //小顶堆 用自带导包的优先级队列 比较器
    private PriorityQueue<Integer> right = new PriorityQueue<>(
            (a, b) -> Integer.compare(a, b)     //compare -1: a<b  0: a=b  1: a>b
    );


    public static void main(String[] args) {
        //小顶堆
        Comparator<Integer> cmp = (a, b) -> Integer.compare(a, b);
        //大顶堆
        //Comparator<Integer> cmp1 = (a, b) -> Integer.compare(b, a);
        int a = 10;
        int b = 5;
        if (cmp.compare(a, b) > 0) {
            System.out.println("上浮");
        } else {
            System.out.println("停止上浮");
        }
    }
}

