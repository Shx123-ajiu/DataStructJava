package com.itajiu.Queue;

/**
 * @author ${阿鸠}
 * @Date ${2025/11/11} ${23.59}
 * @package
 * @Description:本人所著，未经许可，不得转发，否则追究法律责任
 */

//双端队列
public interface CustomDeque<E> {

    /**
     * 向队头添加元素
     * Params:value  -待添加的元素
     * Returns:插入成功返回true,否则返回false
     */
    boolean offerFirst(E e);


    /**
     * 向队尾添加元素
     * Params:value  -待添加的元素
     * Returns:插入成功返回true,否则返回false
     */
    boolean offerLast(E e);


    /**
     * 从队列头获取元素，并移除
     * Returns:队列头元素，如果队列为空则返回null
     */
    E pollFirst();

    /**
     * 从队列尾获取元素，并移除
     * Returns:队列尾元素，如果队列为空则返回null
     */
    E pollLast();


    /**
     * 从队列头获取值，不移除
     * Returns:队列头元素，如果队列为空则返回null
     */
    E peekFirst();


    /**
     * 从队列尾获取值，不移除
     * Returns:队列尾元素，如果队列为空则返回null
     */
    E peekLast();


    /**
     * 检查队列是否为空
     * Returns:队列为空返回true,否则返回false
     */
    boolean isEmpty();


    /**
     * 检查队列是否已满
     * Returns:满返回true ，否则返回false
     */
    boolean isFull();
}
