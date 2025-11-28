/**
 * @discription 阿鸠本人所著，未经许可，不得转发，否则追求法律责任
 * @author 阿鸠
 * @date 2025/11/24 19:57
 * @param null
 * @return {@code null}
 **/

package com.itajiu.Stack;

public interface Stack <E>{
    /**
     * 向栈顶压入元素
     * @param value - 待压入值
     * @return 压入成功返回true，否则返回false
     */
    boolean push(E value);

    /**
     * 从栈顶弹出元素
     * @return 栈非空返回栈顶元素，否则返回null
     */
    E pop();

    /**
     * 返回栈顶元素，不弹出
     * @return 栈非空返回栈顶元素，否则返回null
     */
    E peek();

    /**
     * 判断栈是否为空
     * @return 栈为空返回true，否则返回false
     */
    boolean isEmpty();

    /**
     * 栈是否已满
     * @return 栈已满返回true，否则返回false
     */
    boolean isFull();


}
