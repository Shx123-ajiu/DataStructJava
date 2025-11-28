package com.itajiu.Heap;

import java.util.Arrays;

/**
 * @author ${阿鸠}
 * @Date ${2025/11/11} ${23.59}
 * @package
 * @Description:本人所著，未经许可，不得转发，否则追究法律责任
 */

//大顶堆
//建堆 ： 父节点大于子节点
public class MaxHeap {
    int[] array;
    int size;

    public MaxHeap(int capacity) {
        array = new int[capacity];
    }

    //建堆
    private void heapify() {
        //最后一个非叶子节点公式
        for (int i = (size >> 1) - 1; i >= 0; i--) {
            down(i);
        }
    }


    /**
     * 获取堆顶元素
     *
     * @return 返回堆顶元素
     */
    public int peek() {
        if (size == 0) {
            return -1;
        }
        return array[0];
    }


    /**
     * 删除堆顶元素
     *
     * @return 删除堆顶元素
     */
    public int poll() {
        if (size == 0) {
            return -1;
        }
        int top = array[0];
        swap(0, size - 1);
        size--;
        down(0);
        return top;
    }


    /**
     * description: 删除指定索引位置的元素
     * Params: index  -待删除的元素索引
     */
    public int poll(int index) {
        if (size == 0) {
            return -1;
        }
        int deleted = array[index];
        swap(index, size - 1);
        size--;
        down(index);
        return deleted;
    }

    /**
     * description: 替换堆顶元素
     * Params: index  -新元素
     */
    public void replace(int replaced) {
        array[0] = replaced;
        down(0);
    }

    /**
     * description: 堆的尾部添加元素
     * Params: inserted  -被添加的元素值
     * return : 是否添加成功
     */
    public boolean offer(int inserted) {
        if (size == array.length) {
            return false;
        }
        up(size);
        size++;
        return true;
    }

    //将inserted 元素上浮 直到offered小于父元素或堆顶
    private void up(int offered) {
        int child = size;
        while (child > 0) {
            int parent = (child - 1) / 2;
            if (array[child] > array[parent]) {
                array[child] = array[parent];
            } else {
                break;
            }
            child = parent;
        }
        array[child] = offered;
    }

    public MaxHeap(int[] array) {
        this.array = array;
        size = array.length;
        heapify();
    }

    //将parent 索引处的元素下潜 与两个孩子较大者交换，直至没有孩子或孩子没他大
    private void down(int parent) {
        int left = parent * 2 + 1;
        int right = parent * 2 + 2;
        //假设父元素的值最大，优先级最高
        int max = parent;
        if (left < size && array[left] > array[max]) {
            max = left;
        }
        if (right < size && array[right] > array[max]) {
            max = right;
        }
        //当max已经不是父亲了 的确找到了孩子比父亲大的值
        if (max != parent) {
            swap(max, parent);
            down(max);
        }

    }

    //交换两个索引处的元素
    private void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        MaxHeap maxHeap = new MaxHeap(array);
        System.out.println(Arrays.toString(maxHeap.array));

        while (maxHeap.size > 0) {
            maxHeap.swap(0, maxHeap.size - 1);
            maxHeap.size--;
            maxHeap.down(0);
        }
        System.out.println(Arrays.toString(maxHeap.array));
    }
}
