/**
 * @discription 阿鸠本人所著，未经许可，不得转发，否则追求法律责任
 * @author 阿鸠
 * @date 2025/11/24 19:57
 * @param null
 * @return {@code null}
 **/


package com.itajiu.LeetCode;

public class LinkedListP142 {
    //龟兔赛跑
    public ListNode hasCycle(ListNode head) {
        ListNode h = head; //兔
        ListNode t = head; //龟
        while (h != null && h.next != null) {
            t = t.next;
            h = h.next.next;
            //龟兔相遇,链表有环
            if (h == t) {
                //找到环的入口:龟从链表头开始,兔从相遇点开始,龟兔每次移动一步,当龟兔相遇时,就是环的入口
                t = head;
                while (true) {
                    if (t == h) {
                        return t;   //环的入口
                    }
                    t = t.next;
                    h = h.next;
                }
            }
        }
        return null;
    }
}
