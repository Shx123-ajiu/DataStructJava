/**
 * @discription 阿鸠本人所著，未经许可，不得转发，否则追求法律责任
 * @author 阿鸠
 * @date 2025/11/24 19:57
 * @param null
 * @return {@code null}
 **/

package com.itajiu.LeetCode;

public class LinkedListP203 {


    //方法1
    //head 表示链表头 val 表示要删除的目标值

    public ListNode removeElements1(ListNode head, int val) {
        ListNode s = new ListNode(-1, head);
        ListNode p1 = s;
        ListNode p2 = s.next;

        while (p2 != null) {
            if (p2.val == val) {
                p1.next = p2.next;
                p2 = p1.next;
            } else {
                p1 = p1.next;
                p2 = p2.next;
            }
        }
        return s.next;
    }


    //方法2
    public ListNode removeElements2(ListNode p, int val) {
        if (p == null) {
            return null;
        }
        if (p.val == val) {
            return removeElements2(p.next, val);
        } else {
            p.next = removeElements2(p.next, val);
            return p;
        }
    }


}
