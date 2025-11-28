package com.itajiu.Queue;

/**
 * @author ${阿鸠}
 * @Date ${2025/11/11} ${23.59}
 * @package
 * @Description:本人所著，未经许可，不得转发，否则追究法律责任
 */

//阻塞队列
//分离生产者和消费者，由不同线程来担当
//队列为空，在之前的实现里会返回null，如果就是硬要拿到一个元素呢？只能不断循环尝试
//队列为满，在之前的实现里会返回false，如果就是硬要塞一个元素呢？只能不断循环尝试
public interface BlockingQueue<E> {
    void offer(E e) throws InterruptedException;

    boolean offer(E e, long timeout) throws InterruptedException;

    E poll() throws InterruptedException;
}
