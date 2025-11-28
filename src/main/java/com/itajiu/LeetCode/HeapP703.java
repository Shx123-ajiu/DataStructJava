package com.itajiu.LeetCode;

import com.itajiu.Heap.MinHeap;

/**
 * @author ${阿鸠}
 * @Date ${2025/11/11} ${23.59}
 * @package
 * @Description:本人所著，未经许可，不得转发，否则追究法律责任
 */

//寻找数据流中的第K大元素
public class HeapP703 {

    private MinHeap heap;

    public HeapP703(int k, int[] nums) {
        heap = new MinHeap(k);
        for (int num : nums) {
            add(num);
        }

    }

    //此方法不会被调用，用来模拟数据流中新来的元素
    public int add(int val) {
        if (!heap.isFull()) {
            heap.offer(val);
        } else if (val > heap.peek()) {
            heap.replace(val);
        }
        return heap.peek();
    }


    public static void main(String[] args) {
        HeapP703 test = new HeapP703(3, new int[]{4, 5, 8, 2});

        test.add(3);
        test.add(5);
        test.add(10);
        test.add(9);
        test.add(4);
    }

}
