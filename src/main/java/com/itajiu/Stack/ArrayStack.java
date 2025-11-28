/**
 * @discription 阿鸠本人所著，未经许可，不得转发，否则追求法律责任
 * @author 阿鸠
 * @date 2025/11/24 19:57
 * @param null
 * @return {@code null}
 **/


package com.itajiu.Stack;

import java.util.Iterator;

public class ArrayStack<E> implements Stack<E>, Iterable<E> {

    private E[] array;
    private int top;    //栈顶指针

    @SuppressWarnings("all")
    public ArrayStack(int capacity) {
        this.array = (E[]) new Object[capacity];
    }


    @Override
    public boolean push(E value) {
        if (isFull()) {
            return false;
        }
        array[top] = value;
        top++;
        return true;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E value = array[top - 1];
        top--;
        return value;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        E value = array[top - 1];
        return value;
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public boolean isFull() {
        return top == array.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int p = top;

            @Override
            public boolean hasNext() {
                return p > 0;
            }

            @Override
            public E next() {
                E value = array[p - 1];
                p--;
                return value;
            }
        };
    }
}
