package medium;

import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Offer_36 {

    Node head = null;
    Node loop = null;

    public Node treeToDoublyList(Node root) {
        if (root==null){return null;}
        Node end = getmidroot(root,loop);
        end.right=head;
        head.left=end;
        return head;
    }


    public Node getmidroot(Node root, Node loop){
        if (root.left!=null){
            loop = getmidroot(root.left, loop);
        }
        if (loop == null){
            head = root;
        }else{
            loop.right = root;
            root.left = loop;
        }
        loop = root;
        if (root.right!=null){
            loop = getmidroot(root.right, loop);
        }
        return loop;
    }

    public Node TreeInit(int @NotNull [] tree){
        Node head;
        int par = 0;
        int chi = 1;
        Queue<Node> queue = new LinkedList<>();
        head = new Node(tree[par]);
        queue.add(head);
        while (chi<tree.length){
            Node node =queue.poll();
            if (tree[chi]!=-1){
                assert node != null;
                node.left = new Node(tree[chi]);queue.add(node.left);}
            if (chi+1<tree.length) {
                if (tree[chi + 1] != -1) {
                    assert node != null;
                    node.right = new Node(tree[chi + 1]);queue.add(node.right);}
                chi++;
            }
            chi++;
        }
        return head;
    }

    public static void main(String[] args) {
        Offer_36 o36 = new Offer_36();
        int[] tree = new int[]{4, 2, 5, 1, 3};
        Node root = o36.TreeInit(tree);
        o36.treeToDoublyList(root);
    }
}
