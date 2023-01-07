package medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import medium.TreeNode;
import org.jetbrains.annotations.NotNull;

public class Offer_34 {
    List<List<Integer>> sum = new LinkedList<>();

    public List<List<Integer>> pathSum_my(TreeNode root, int target) {
        if (root==null){
            return new LinkedList<>();
        }
        List<Integer> path = new LinkedList<>();
        judge(root,target,path);
        return sum;
    }

    public void judge(TreeNode head, int target, List<Integer> path){
        path.add(head.val);
        if (head.left==null && head.right==null && head.val==target){
            List<Integer> path_cp = new LinkedList<>(path);
            sum.add(path_cp);
            path.remove(path.size()-1);
            return;
        }
        if (head.left!=null){
            judge(head.left, (target- head.val), path);
        }
        if (head.right!=null){
            judge(head.right, (target- head.val), path);
        }
        path.remove(path.size()-1);
    }

    public TreeNode TreeInit(int @NotNull [] tree){
        TreeNode head;
        int par = 0;
        int chi = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        head = new TreeNode(tree[par]);
        queue.add(head);
        while (chi<tree.length){
            TreeNode node =queue.poll();
            if (tree[chi]!=-1){
                assert node != null;
                node.left = new TreeNode(tree[chi]);queue.add(node.left);}
            if (chi+1<tree.length) {
                if (tree[chi + 1] != -1) {
                    assert node != null;
                    node.right = new TreeNode(tree[chi + 1]);queue.add(node.right);}
                chi++;
            }
            chi++;
        }
        return head;
    }

    public static void main(String[] args) {
        Offer_34 o34 = new Offer_34();
        int[] root = new  int[]{5,4,8,11,-1,13,4,7,2,-1,-1,5,1};
        int target = 22;
        TreeNode head = o34.TreeInit(root);
        List<List<Integer>> res = o34.pathSum_my(head, target);
        for (List<Integer> re:res){
            System.out.println(re.toString());
        }
    }
}
