package medium;

import java.util.List;
import easy.ListNode;

public class Day_5_2 {

    // 3变量
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode last = head;
        int ex = 0;
        while (l1!=null || l2!=null) {
            int l1_0 = l1 == null ? 0 : l1.val;
            int l2_0 = l2 == null ? 0 : l2.val;
            int sum = l1_0 + l2_0 + ex;
            int data = sum % 10;
            ex = sum / 10;
            last.next = new ListNode(data);
            last = last.next;
            if (l1!= null){
                l1 = l1.next;
            }
            if (l2!= null){
                l2 = l2.next;
            }
        }
        if (ex!=0){
            last.next = new ListNode(ex);
        }
        return head.next;
    }
    //孙笑川粉丝的单进位变量
    public ListNode addTwoNumbers_1v(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1), pre = dummyHead;
        int t = 0;
        while (l1 != null || l2 != null || t != 0) {
            if (l1 != null) {
                t += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                t += l2.val;
                l2 = l2.next;
            }
            pre.next = new ListNode(t % 10);
            pre = pre.next;
            t /= 10;
        }

        return dummyHead.next;
    }
    public ListNode gen_list(int[] num){
        ListNode head = null;
        ListNode last = null;
        for (int nums:num){
            ListNode node = new ListNode(nums);
            if (head == null){
                head = node;
                last = head;
            }else {
                last.next = node;
                last = last.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Day_5_2 d5 = new Day_5_2();
        int[] number_1 = new int[]{9,9,9,9,9,9,9};
        int[] number_2 = new int[]{9,9,9};
        ListNode l1 = d5.gen_list(number_1);
        ListNode l2 = d5.gen_list(number_2);
        ListNode l3 = d5.addTwoNumbers(l1,l2);
        while (l3!=null){
            System.out.println(l3.val);
            l3 = l3.next;
        }
    }
}
