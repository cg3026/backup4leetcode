package medium;
import medium.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Offer_32_1 {

    public int[] levelOrder(TreeNode root) {
        if (root==null){
            return new int[]{};
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> res = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode loop = queue.poll();
            res.add(loop.val);
            if (loop.left!=null){
                queue.add(loop.left);
            }
            if (loop.right!=null){
                queue.add(loop.right);
            }
        }
        int[] arr = new int[res.size()];
        int i = 0;
        while (!res.isEmpty()){
            arr[i]=res.poll();
            i++;
        }
        return arr;
    }

    public static void main(String[] args) {
        Offer_32_1 o321 = new Offer_32_1();
        int[] tree = new int[]{3,9,20,-1,-1,15,7};
        TreeInit treeInit = new TreeInit();
        TreeNode head = treeInit.TreeInit(tree);
        System.out.println(Arrays.toString(o321.levelOrder(head)));

    }
}
