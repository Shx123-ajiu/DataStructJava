/**
 * @discription 阿鸠本人所著，未经许可，不得转发，否则追求法律责任
 * @author 阿鸠
 * @date 2025/11/24 19:57
 * @param null
 * @return {@code null}
 **/

package com.itajiu.LeetCode;

public class LinkedListP206 {

    //方法1
    public ListNode reverseList1(ListNode o1) {
        ListNode n1 = null;
        ListNode p = o1;
        while (p != null) {
            n1 = new ListNode(p.val, n1);
            p = p.next;
        }
        return n1;
    }

    //方法2
    public ListNode reverseList2(ListNode head) {
        List list1 = new List(head);
        List list2 = new List(null);
        while (true) {
            ListNode first = list1.removeFirst();
            if (first == null) {
                break;
            }
            list2.addFirst(first);
        }
        return list2.head;
    }

    static class List {
        ListNode head;

        public List(ListNode head) {
            this.head = head;
        }

        public void addFirst(ListNode first) {
            first.next = head;
            head = first;
        }

        public ListNode removeFirst() {
            ListNode first = head;
            if (head != null) {
                head = first.next;
            }
            return first;
        }
    }

    //方法3
    public ListNode reverseList3(ListNode p) {
        if (p == null || p.next == null) {
            return p;
        }
        ListNode last = reverseList3(p.next);
        //假如 p是4，p.next是5，p.next.next是4，让它实现反转
        p.next.next = p;
        p.next = null;
        return last;
    }

    //方法4
    public ListNode reverseList4(ListNode o1) {
        if (o1 == null || o1.next == null) {
            return o1;
        }
        ListNode o2 = o1.next;
        ListNode n1 = o1;
        while (o2 != null) {
            o1.next = o2.next;
            o2.next = o1;
            n1 = o2;
            o2 = o1.next;
        }
        return n1;
    }

    //方法5
    public ListNode reverseList5(ListNode o1) {
        if (o1 == null || o1.next == null) {
            return o1;
        }
        ListNode n1 = null;
        while (o1 != null) {
            ListNode o2 = o1.next;
            o1.next = n1;
            n1 = o1;
            o1 = o2;
        }
        return n1;
    }

}
