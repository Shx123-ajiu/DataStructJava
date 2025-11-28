package com.itajiu.LeetCode;

import com.itajiu.Heap.MinHeap;

import java.util.Arrays;

/**
 * @author ${阿鸠}
 * @Date ${2025/11/11} ${23.59}
 * @package
 * @Description:本人所著，未经许可，不得转发，否则追究法律责任
 */

//215. 数组中的第K个最大元素
public class HeapP215 {
    public int findKthLargest(int[] nums, int k) {
        MinHeap minHeap = new MinHeap(nums);
        for (int i = 0; i < k; i++) {
            minHeap.offer(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }
        return minHeap.peek();
    }


    public static void main(String[] args) {
        //应为5
        System.out.println(new HeapP215().findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        //应为4
        System.out.println(new HeapP215().findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }
}
