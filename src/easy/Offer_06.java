package easy;

import java.util.Stack;



public class Offer_06 {

    Stack<Integer> stack;

    public int[] reversePrint(ListNode head){
        ListNode loop = head;
        int len = 0;
        while (loop!=null){
            len++;
            loop=loop.next;
        }
        loop = head;
        int[] res = new int[len];
        while (loop!=null){
            res[len-1] = loop.val;
            len--;
            loop=loop.next;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode head;
        ListNode loop = new ListNode(0);
        int[] que = new int[]{1, 3, 2};
        head=loop;
        for (int qu:que){
            ListNode newNode = new ListNode(qu);
            loop.next = newNode;
            loop=newNode;
        }
        head=head.next;
        Offer_06 o06 = new Offer_06();
        int[] res = o06.reversePrint(head);
        for (int re:res){
            System.out.println(re);
        }
    }
}
