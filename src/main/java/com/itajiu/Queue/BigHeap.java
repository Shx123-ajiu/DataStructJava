package com.itajiu.Queue;

/**
 * @author ${阿鸠}
 * @Date ${2025/11/11} ${23.59}
 * @package
 * @Description:本人所著，未经许可，不得转发，否则追究法律责任
 */

//用堆实现优先级队列
//大顶堆：父节点大于子节点  //如果父节点小于子节点，则交换位置，向下移
//小顶堆：父节点小于子节点
public class BigHeap<E extends Priority> implements Queue<E> {

    Priority[] array;
    int size;

    public BigHeap(int capacity) {
        array = new Priority[capacity];
    }

    @Override
    public boolean offer(E offered) {
        if (isFull()) {
            return false;
        }
        int child = size;
        size++;
        int parent = (child - 1) / 2;   //父节点在孩子节点上面，两个孩子节点间隔为一个单位，所以父节点索引为（child-1）/2
        while (child > 0 && offered.priority() > array[parent].priority()) {
            array[child] = array[parent];
            child = parent;
            parent = (child - 1) / 2;
        }
        array[child] = offered;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        //上浮
        swap(0, size - 1);
        size--;
        Priority e = array[size];
        array[size] = null;     //help GC

        //下潜
        down(0);
        return (E) e;
    }

    private void down(int parent) {
        int left = parent * 2 + 1;
        int right = parent * 2 + 2;
        int max = parent;   //假设父元素优先级最高
        if (left < size && array[left].priority() > array[max].priority()) {
            max = left;
        }
        if (right < size && array[right].priority() > array[max].priority()) {
            max = right;
        }
        if (max != parent) {    //父元素优先级低于子元素，则交换位置
            swap(max, parent);
            down(max);
        }
    }


    private void swap(int i, int j) {
        Priority temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return (E) array[0];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == array.length;
    }
}
