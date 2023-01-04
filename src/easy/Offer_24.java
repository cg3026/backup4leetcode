package easy;


public class Offer_24 {
    public ListNode reverseList(ListNode head) {
        ListNode last = new ListNode(head.val);
        ListNode loop;
        head = head.next;
        while (head!=null){
            loop = head.next;
            head.next = last;
            last = head;
            head = loop;
        }
        return last;
    }

    public static void main(String[] args) {
        ListNode head;
        ListNode loop = new ListNode(0);
        int[] que = new int[]{1, 2, 3, 4, 5};
        head=loop;
        for (int qu:que){
            ListNode newNode = new ListNode(qu);
            loop.next = newNode;
            loop=newNode;
        }
        head=head.next;
        Offer_24 o24 = new Offer_24();
        head = o24.reverseList(head);
        while (head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
