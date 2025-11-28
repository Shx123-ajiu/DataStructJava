package com.itajiu.Queue;

/**
 * @author ${阿鸠}
 * @Date ${2025/11/11} ${23.59}
 * @package
 * @Description:本人所著，未经许可，不得转发，否则追究法律责任
 */

//基于有序数组实现优先级队列     元素越大优先级越高 越排在上面
public class PriorityQueue2 <E extends Priority> implements Queue<E>{

    Priority[] array;
    int size;

    public PriorityQueue2(int capacity) {
        array = new Priority[capacity];
    }

    @Override
    public boolean offer(E e) {
        if(isFull()){
            return false;
        }
        insert(e);
        size++;
        return true;
    }

    //插入元素
    private void insert(E e) {
        int i = size - 1;
        while (i >= 0 && array[i].priority() < e.priority()) {
            array[i + 1] = array[i];
            i--;
        }
        array[i + 1] = e;
    }

    @Override
    public E poll() {
        if(isEmpty()){
            return null;
        }
        E e = (E) array[size - 1];
        size--;
        array[size] = null;
        return e;
    }

    @Override
    public E peek() {
        if(isEmpty()){
            return null;
        }
        return (E) array[size - 1];
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
