/**
 * @discription 阿鸠本人所著，未经许可，不得转发，否则追求法律责任
 * @author 阿鸠
 * @date 2025/11/24 19:57
 * @param null
 * @return {@code null}
 **/

package com.itajiu.Queue;

public interface Queue<E> {

    /**
     * 向队尾添加元素
     * Params:value  -待添加的元素
     * Returns:插入成功返回true,否则返回false
     */
    boolean offer(E e);

    /**
     * 从队列头获取元素，并移除
     * Returns:队列头元素，如果队列为空则返回null
     */
    E poll();

    /**
     * 从队列头获取值，不移除
     * Returns:队列头元素，如果队列为空则返回null
     */
    E peek();

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
