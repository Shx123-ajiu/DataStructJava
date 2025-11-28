/**
 * @discription 阿鸠本人所著，未经许可，不得转发，否则追求法律责任
 * @author 阿鸠
 * @date 2025/11/24 19:57
 * @param null
 * @return {@code null}
 **/


package com.itajiu.Queue;

import java.util.Iterator;

public class ArrayQueue3<E> implements Queue<E>, Iterable<E> {

    private final E[] array;
    private int head = 0;
    private int tail = 0;

    @SuppressWarnings("all")
    public ArrayQueue3(int capacity) {
        array = (E[]) new Object[capacity];
    }


    @Override
    public boolean offer(E value) {
        if (isFull()) {
            return false;
        }
        array[(int) (Integer.toUnsignedLong(tail) % array.length)] = value;
        tail++;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        E value = array[(int) (Integer.toUnsignedLong(head) % array.length)];
        head++;
        return value;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return array[(int) (Integer.toUnsignedLong(head) % array.length)];
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean isFull() {
        return tail - head == array.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int p = head;

            @Override
            public boolean hasNext() {
                return p != tail;
            }

            @Override
            public E next() {
                E value = array[(int) (Integer.toUnsignedLong(p) % array.length)];
                p++;
                return value;
            }
        };
    }
}
