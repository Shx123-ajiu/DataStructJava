package com.itajiu.Queue;

import com.itajiu.LeetCode.ListNode;

import java.util.List;


/**
 * @author ${阿鸠}
 * @Date ${2025/11/11} ${23.59}
 * @package
 * @Description:本人所著，未经许可，不得转发，否则追究法律责任
 */

//堆实现
//小顶堆：父节点小于子节点
public class MinHeapP23 {
    ListNode[] array;
    int size;

    public MinHeapP23(int capacity) {
        array = new ListNode[capacity];
    }

    public boolean offer(ListNode offered) {
        if (isFull()) {
            return false;
        }
        int child = size;
        size++;
        int parent = (child - 1) / 2;
        while (child > 0 && offered.val < array[parent].val) {
            array[child] = array[parent];
            child = parent;
            parent = (child - 1) / 2;
        }
        array[child] = offered;
        return true;
    }

    public ListNode poll() {
        if (isEmpty()) {
            return null;
        }
        //上浮
        swap(0, size - 1);
        size--;
        ListNode e = array[size];
        array[size] = null;     //help GC

        //下潜
        down(0);
        return e;
    }

    private void down(int parent) {
        int left = parent * 2 + 1;
        int right = parent * 2 + 2;
        int min = parent;   //假设父元素优先级最高
        if (left < size && array[left].val < array[min].val) {
            min = left;
        }
        if (right < size && array[right].val < array[min].val) {
            min = right;
        }
        if (min != parent) {    //父元素优先级低于子元素，则交换位置
            swap(min, parent);
            down(min);
        }
    }


    private void swap(int i, int j) {
        ListNode temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == array.length;
    }
}
