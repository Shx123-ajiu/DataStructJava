package com.itajiu.LeetCode;

/**
 * @author ${阿鸠}
 * @Date ${2025/11/11} ${23.59}
 * @package
 * @Description:本人所著，未经许可，不得转发，否则追究法律责任
 */
public class Heap {
    private int[] data;
    private int size;
    private boolean isMaxHeap;

    public Heap(int capacity, boolean isMaxHeap) {
        this.data = new int[capacity];
        this.size = 0;
        this.isMaxHeap = isMaxHeap;
    }

    public void offer(int value) {
        if (size >= data.length) {
            // 扩容逻辑
            int[] newData = new int[data.length * 2];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
        }

        data[size] = value;
        heapifyUp(size);
        size++;
    }

    public int poll() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }

        int result = data[0];
        data[0] = data[size - 1];
        size--;
        heapifyDown(0);

        return result;
    }

    public int peek() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        return data[0];
    }

    public int size() {
        return size;
    }

    private void heapifyUp(int index) {
        int parentIndex = (index - 1) / 2;
        while (index > 0 && compare(data[index], data[parentIndex])) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    private void heapifyDown(int index) {
        while (true) {
            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;
            int targetIndex = (leftChild < size && compare(data[leftChild], data[index])) ?
                    ((rightChild < size && compare(data[rightChild], data[leftChild])) ? rightChild : leftChild) :
                    ((rightChild < size && compare(data[rightChild], data[index])) ? rightChild : index);

            if (targetIndex != index) {
                swap(index, targetIndex);
                index = targetIndex;
            } else {
                break;
            }
        }
    }

    private boolean compare(int child, int parent) {
        // 如果是最大堆，子节点大于父节点时需要交换
        // 如果是最小堆，子节点小于父节点时需要交换
        return isMaxHeap ? child > parent : child < parent;
    }

    private void swap(int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}

