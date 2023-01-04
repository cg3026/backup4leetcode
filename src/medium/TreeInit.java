package medium;

import medium.TreeNode;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
import java.util.Queue;

public class TreeInit {
    public TreeNode TreeInit(int @NotNull [] tree){
        TreeNode head;
        int par = 0;
        int chi = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        head = new TreeNode(tree[par]);
        queue.add(head);
        while (chi<tree.length){
            TreeNode node =queue.poll();
            if (tree[chi]!=-1){node.left = new TreeNode(tree[chi]);queue.add(node.left);}
            if (chi+1<tree.length) {
                if (tree[chi + 1] != -1) {node.right = new TreeNode(tree[chi + 1]);queue.add(node.right);}
                chi++;
            }
            chi++;
        }
        return head;
    }
}
