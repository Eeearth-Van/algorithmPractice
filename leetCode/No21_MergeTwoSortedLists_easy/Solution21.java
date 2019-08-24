package No21_MergeTwoSortedLists_easy;

import com.sun.xml.internal.bind.v2.TODO;

/**
 * @program: wy
 * @package:
 * @description:
 * @author: Kevin
 * @create: 2019-05-29 09:02
 **/
class Solution21Test {
    //TODO
    public static void main(String[] args) {
        Solution21 solution = new Solution21();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(22);
        l1.next = l2;
        System.out.println(l1);
    }
}

public class Solution21 {
    ListNode res = null;
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        mergeProcess(l1,l2,res);
        return res;
    }
    ListNode mergeProcess(ListNode l1,ListNode l2,ListNode res){
        if (l1==null){
            res=l2;
            return res;
        }
        if (l2==null){
            res=l1;
            return res;
        }
        if (l1.val > l2.val) {
            res = l2;
            return mergeProcess(l1, l2.next, res.next);
        }
        res =l1;
        return mergeProcess(l1.next, l2, res.next);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
