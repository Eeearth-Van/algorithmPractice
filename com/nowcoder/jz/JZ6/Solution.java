package nowcoder.jz.JZ6;

import java.util.ArrayList;

/**
 * @description: JZ6 从尾到头打印链表
 * @author: wangyao
 * @create: 2022-02-07 18:00
 **/
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null) {
            return new ArrayList<>();
        } else {
            ArrayList<Integer> tailList = printListFromTailToHead(listNode.next);
            tailList.add(listNode.val);
            return tailList;
        }
//        ArrayList<Integer> list = new ArrayList<Integer>();
//        while (listNode != null) {
//            list.add(0, listNode.val);
//            listNode = listNode.next;
//        }
//        return list;
    }

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}



