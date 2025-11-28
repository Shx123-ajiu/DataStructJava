/**
 * @discription 阿鸠本人所著，未经许可，不得转发，否则追求法律责任
 * @author 阿鸠
 * @date 2025/11/24 19:57
 * @param null
 * @return {@code null}
 **/

package com.itajiu.LeetCode;

import com.itajiu.Stack.ArrayStack;

public class StackP232 {
    ArrayStack<Integer> s1 = new ArrayStack<>(100);
    ArrayStack<Integer> s2 = new ArrayStack<>(100);

    public void push(int x){    //向队列尾添加
        s2.push(x);

    }

    public int pop(){      //从队列头移除
        if(s1.isEmpty()){
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }
        return s1.pop();
    }

    public int peek(){      //从队列头获取
        if(s1.isEmpty()){
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }
        return s1.peek();
    }

    public boolean empty(){
        return s1.isEmpty() && s2.isEmpty();
    }

}
