package com.itajiu.Queue;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ${阿鸠}
 * @Date ${2025/11/11} ${23.59}
 * @package
 * @Description:本人所著，未经许可，不得转发，否则追究法律责任
 */

//1.synchronized 关键字，功能少
//2.ReentrantLock 可重入锁，功能多

public class TestThreadUnsafe {
    private final String[] array = new String[10];
    private int tail = 0;
    private int size = 0;
    ReentrantLock lock = new ReentrantLock();   //锁对象
    Condition tailWaits = lock.newCondition();  //条件变量对象 队列为空时，等待


    public void offer(String e) throws InterruptedException {
//        lock.lock();    //加锁
        lock.lockInterruptibly();   //加锁（可以在阻塞状态时随时打断）
        try {
            while (isFull()) {
                //当前线程加入tailWait 并且让此线程阻塞时 等待
                tailWaits.await();
            }
            array[tail] = e;
            if (++tail == array.length) {
                tail = 0;
            }
            size++;
        } finally {
            lock.unlock();  //解锁
        }

    }

    private boolean isFull() {
        return size == array.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    public static void main(String[] args) throws InterruptedException {
        TestThreadUnsafe queue = new TestThreadUnsafe();
        for (int i = 0; i < 10; i++) {
            queue.offer("e" + i);
        }
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "添加元素之前");
                queue.offer("e10");
                System.out.println(Thread.currentThread().getName() + "添加元素成功");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "t1").start();

        new Thread(() -> {
            System.out.println("开始唤醒");
            try {
                queue.lock.lockInterruptibly(); //加锁
                queue.tailWaits.signal();   //唤醒
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                queue.lock.unlock();
            }
        }, "t2").start();
    }
}
