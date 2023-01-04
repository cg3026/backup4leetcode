package medium;

import easy.Node;

import java.util.HashMap;
import java.util.Map;

public class Offer_35 {

    Map<Node, Node> cachedNode = new HashMap<>();
    // 用哈希表统计已经拷贝的节点
    // 建立后继节点和建立随机节点分开，先创建后继后补充随机，用递归保存回溯节点状态
    public Node copyRandomList_HashMap(Node head) {
        if (head == null){
            return null;
        }
        if (!cachedNode.containsKey(head)) {
            Node headNew = new Node(head.val);
            cachedNode.put(head, headNew);
            headNew.next = copyRandomList_HashMap(head.next);
            headNew.random = copyRandomList_HashMap(head.random);
        }
        return cachedNode.get(head);
    }
    public Node copyRandomList_copy(Node head) {
        if (head == null){
            return null;
        }
        Node loop = head;
        Node current = head;
        Node head_copy;
        Node loop_copy;
        while(loop!=null){
            Node copy = new Node(current.val);
            loop= current.next;
            current.next=copy;
            copy.next=loop;
            current = loop;
        }
        loop = head;
        while(loop!=null){
            if (loop.random!=null) {
                loop.next.random = loop.random.next;
            }
            loop = loop.next.next;
        }
        loop = head;
        head_copy = loop.next;
        loop_copy = head_copy;
        while(loop_copy.next!=null){
            loop.next = loop.next.next;
            loop_copy.next = loop_copy.next.next;
            loop=loop.next;
            loop_copy = loop_copy.next;
        }
        loop.next = null;
        return head_copy;
    }


    public static void main(String[] args) {
        Map<Integer,Node> store = new HashMap<>();
        Offer_35 o35 = new Offer_35();
        int[][] ques = new int[][]{{7,-1},{13,0},{11,4},{10,2},{1,0}};
        Node head=null,loop=null;
        int i=0;
        for (int[] que:ques){
            Node newNode = new Node(que[0]);
            store.put(i, newNode);
            i++;
            if (head == null){
                head = newNode;
                loop = head;
                continue;
            }
            loop.next=newNode;
            loop = loop.next;
        }
        loop=head;
        for (int[] que:ques){
            if (que[1]!=-1) {
                loop.random = store.get(que[1]);
            }
            loop = loop.next;
        }
        loop = o35.copyRandomList_copy(head);
        while (loop!=null){
            System.out.println(loop.val);
            loop=loop.next;
        }

    }
}
