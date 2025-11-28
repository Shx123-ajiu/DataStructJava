/**
 * @discription 阿鸠本人所著，未经许可，不得转发，否则追求法律责任
 * @author 阿鸠
 * @date 2025/11/24 19:57
 * @param null
 * @return {@code null}
 **/


package com.itajiu.LeetCode;

import com.itajiu.Queue.ArrayQueue3;

public class StackP225 {
    ArrayQueue3<Integer> queue = new ArrayQueue3<>(100);
    private int size = 0;

    public void push(int x){
        queue.offer(x);
        for (int i = 0; i < size; i++) {
            queue.offer(queue.poll());
        }
        size++;
    }

    public int pop(){
        size--;
        return queue.poll();
    }

    public int top(){
        return queue.peek();
    }

    public boolean empty(){
        return queue.isEmpty();
    }
}
