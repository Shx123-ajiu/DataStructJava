package com.itajiu.LeetCode;

/**
 * @author ${阿鸠}
 * @Date ${2025/11/11} ${23.59}
 * @package
 * @Description:本人所著，未经许可，不得转发，否则追究法律责任
 */
public class HeapP295 {

    private Heap left = new Heap(10, true);
    private Heap right = new Heap(10, true);

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
}
